import com.vchdev.dao.entity.*;
import com.vchdev.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class MainTest {

    /*@Test
    void initData() {
        Company company = Company.builder().name("Google").build();

        User user = User.builder()
                .username("vald")
                .userInfo(UserInfo.builder().firstName("vlad").lastName("vladov").build()).
                role(Role.USER)
                .birthdate(new BirthDay(LocalDate.of(1999, 1, 1)))
                .company(company).build();

        Profile profile = Profile.builder().language("ru").street("street").build();
        profile.setUser(user);

        Chat chat = Chat.builder().name(user.getUsername() + " chat").build();

        UserChat userChat = UserChat.builder().build();
        userChat.setChat(chat);
        userChat.setUser(user);

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory(); Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            session.save(company);
            session.save(user);
            session.save(chat);
            session.save(userChat);

            session.getTransaction().commit();
        } catch (Exception e) {
            //log.error(e.getMessage(), e);
            throw e;
        }

    }

    @Test
    void addUser() {
        User user = User.builder()
                .username("vald" + String.valueOf(Math.round(Math.random()*100)))
                .userInfo(UserInfo.builder().firstName("vlad").lastName("vladov").build())
                .role(Role.USER)
                .birthdate(new BirthDay(LocalDate.of(1999, 1, 1)))
                .build();

        Profile profile = Profile.builder().language("ru").street("street").build();
        profile.setUser(user);

        Chat chat = Chat.builder().name(user.getUsername() + " chat").build();

        UserChat userChat = UserChat.builder().build();
        userChat.setChat(chat);
        userChat.setUser(user);

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory(); Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            Company company = session.get(Company.class, 1);
            user.setCompany(company);
            session.save(user);
            session.save(chat);
            session.save(userChat);

            session.getTransaction().commit();
        } catch (Exception e) {
            //log.error(e.getMessage(), e);
            throw e;
        }

    }

    @Test
    void checkOrder(){
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory(); Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            Company company = session.get(Company.class, 1);
            company.getUsers().forEach(System.out::println);

            session.getTransaction().commit();
        } catch (Exception e) {
            //log.error(e.getMessage(), e);
            throw e;
        }
    }*/
}
