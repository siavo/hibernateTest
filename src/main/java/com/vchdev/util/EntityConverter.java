package com.vchdev.util;

import com.vchdev.dao.entity.BaseEntity;
import com.vchdev.dto.BaseTO;
import lombok.experimental.UtilityClass;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@UtilityClass
public class EntityConverter {

    private final String toPackageName = BaseTO.class.getPackageName();
    private final String toPackageNameWithDot = BaseTO.class.getPackageName() + ".";
    private final String entityPackageName = BaseEntity.class.getPackageName();
    private final String entityPackageNameWithDot = BaseEntity.class.getPackageName() + ".";

    public static List<BaseTO> convertToDTOs(List<? extends BaseEntity> entities) {
        List<BaseTO> result = new ArrayList<>();

        for (BaseEntity entity : entities) {
            try {
                result.add(convertToDto(entity));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    public static List<BaseEntity> convertToEntities(List<? extends BaseTO> baseTOS) {
        List<BaseEntity> result = new ArrayList<>();

        for (BaseTO baseTO : baseTOS) {
            try {
                result.add(convertToEntity(baseTO));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    public BaseTO convertToDto(BaseEntity entity) {
        BaseTO baseTO;
        try {
            String className = toPackageNameWithDot + entity.getClass().getSimpleName() + "TO";
            baseTO = (BaseTO) Class.forName(className).newInstance();
            List<Field> entityFields = new ArrayList<>();
            entityFields.addAll(Arrays.asList(baseTO.getClass().getDeclaredFields()));
            if (baseTO.getClass().getSuperclass() != null){
                entityFields.addAll(Arrays.asList(baseTO.getClass().getSuperclass().getDeclaredFields()));
            }
            for (Field toField : entityFields) {
                Field entityField = ReflectionUtils.findField(entity.getClass(), toField.getName());
                if (entityField != null) {
                    entityField.setAccessible(true);
                    toField.setAccessible(true);
                    toField.set(baseTO, entityField.get(entity));
                    entityField.setAccessible(false);
                    toField.setAccessible(false);
                }
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

        return baseTO;
    }

    public BaseEntity convertToEntity(BaseTO baseTO) {
        BaseEntity baseEntity;
        try {
            String simpleClassName = baseTO.getClass().getSimpleName();
            String className = entityPackageNameWithDot + simpleClassName.substring(0, simpleClassName.length()-2);
            baseEntity = (BaseEntity) Class.forName(className).newInstance();
            List<Field> toFields = new ArrayList<>();
            toFields.addAll(Arrays.asList(baseTO.getClass().getDeclaredFields()));
            if (baseTO.getClass().getSuperclass() != null){
                toFields.addAll(Arrays.asList(baseTO.getClass().getSuperclass().getDeclaredFields()));
            }
            for (Field toField : toFields) {
                Field entityField = ReflectionUtils.findField(baseEntity.getClass(), toField.getName());
                entityField.setAccessible(true);
                toField.setAccessible(true);
                entityField.set(baseEntity, toField.get(baseTO));
                entityField.setAccessible(false);
                toField.setAccessible(false);
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

        return baseEntity;
    }

}
