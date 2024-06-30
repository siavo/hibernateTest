import entity.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.sql.SQLException;
import java.time.LocalDate;

@Slf4j
public class MainHibernateRunner {

    public static void main(String[] args) throws SQLException {

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession();
        ) {

            session.beginTransaction();

            User user = session.get(User.class, 1L);

            session.getTransaction().commit();

        }catch (Exception e){
            log.info("transaction error");
            log.error(e.getMessage(), e);
            throw e;
        }
    }
}
