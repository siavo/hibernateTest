package com.vchdev.util;

import com.vchdev.dao.entity.AbstractEntity;
import com.vchdev.dao.entity.BaseEntity;
import com.vchdev.dao.entity.Company;
import com.vchdev.dto.BaseTO;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@UtilityClass
public class EntityConverter {

    public static List<BaseTO> convertToDTOs(List<? extends BaseEntity> entities) {
        List<BaseTO> toList = new ArrayList<>();

        for (BaseEntity entity : entities) {
            try {
                toList.add(convertToDto(entity));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return toList;
    }

    public BaseTO convertToDto(BaseEntity entity) {
        BaseTO to;
        try {
            String className = entity.getClass().getName().replace("dao.entity", "dto") + "TO";
            Class clazz = Class.forName(className);
            to = (BaseTO) clazz.newInstance();
            List<Field> toFields = Arrays.asList(to.getClass().getDeclaredFields());
            for (Field toField : toFields) {
                Field entityField = entity.getClass().getDeclaredField(toField.getName());
                entityField.setAccessible(true);
                toField.setAccessible(true);
                toField.set(to, entityField.get(entity));
                entityField.setAccessible(false);
                toField.setAccessible(false);
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

        return to;
    }
}
