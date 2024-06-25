import entity.BirthDay;
import entity.Company;
import entity.Role;
import entity.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.sql.SQLException;
import java.time.LocalDate;

@Slf4j
public class MainHibernateRunner {

    public static void main(String[] args) throws SQLException {

        Company company = Company.builder().name("Google").build();
        User user = User.builder().
                username("vlad").
                firstname("vlad").
                firstname("vlad").
                lastname("vladov").
                birthdate(new BirthDay(LocalDate.of(1985, 4, 6))).
                company(company).
                role(Role.USER).build();

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession();
        ) {

            log.info("begin transaction");
            session.beginTransaction();

            session.save(company);
            session.save(user);

            log.info("Company: {}", user.getCompany().getName());

            session.getTransaction().commit();
            log.info("transaction end");

        }catch (Exception e){
            log.info("transaction error");
            log.error(e.getMessage(), e);
            throw e;
        }
    }
}
