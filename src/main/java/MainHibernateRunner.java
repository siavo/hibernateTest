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

        Company company = Company.builder().name("Google").build();
        User user = User.builder().
                username("vlad").
                firstname("vlad").
                firstname("vlad").
                lastname("vladov").
                birthdate(new BirthDay(LocalDate.of(1985, 4, 6))).
                company(company).
                role(Role.USER).build();

        /*User user2 = User.builder().
                username("Sasha").
                firstname("vlad").
                firstname("vlad").
                lastname("vladov").
                birthdate(new BirthDay(LocalDate.of(1985, 4, 6))).
                company(company).
                role(Role.USER).build();*/

        Profile profile = Profile.builder()
                .street("Street")
                .language("ru")
                .build();
        profile.setUser(user);

        Chat chat = Chat.builder()
                .name(user.getUsername() + "_chat").build();
        UserChat userChat = UserChat.builder().build();
        userChat.setUser(user);
        userChat.setChat(chat);

        Chat chat2 = Chat.builder()
                .name(user.getUsername() + "_chat2").build();
        UserChat userChat2 = UserChat.builder().build();
        userChat2.setUser(user);
        userChat2.setChat(chat);



        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession();
        ) {

            session.beginTransaction();

            //session.delete(session.get(Company.class, 1));
            /*session.save(company);
            session.save(user);
            session.save(chat);
            session.save(userChat);
            company.addUser(user);*/

            //session.get(session.get(User.class, 1L));

            User user1 = session.get(User.class, 2L);
            user1.getUserChats().add(userChat2);

            session.getTransaction().commit();

        }catch (Exception e){
            log.info("transaction error");
            log.error(e.getMessage(), e);
            throw e;
        }
    }
}
