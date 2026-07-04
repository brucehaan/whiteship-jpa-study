package me.whiteship.demospringdata;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {
    @PersistenceContext
    EntityManager em;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setUsername("brucehan");
        account.setPassword("hibernate");

        Study study = new Study();
        study.setName("Spring Data JPA");

        account.addStudy(study);

        Session session = em.unwrap(Session.class);
        session.persist(account);
        session.persist(study);
//        em.persist(account);
    }
}
