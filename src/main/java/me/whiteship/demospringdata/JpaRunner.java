package me.whiteship.demospringdata;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@Transactional
public class JpaRunner implements ApplicationRunner {
    @PersistenceContext
    EntityManager em;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Account account = new Account();
//        account.setUsername("brucehan");
//        account.setPassword("hibernate");
//
//        Study study = new Study();
//        study.setName("Spring Data JPA");
//
//        account.addStudy(study);
//
//        Session session = em.unwrap(Session.class);
//        session.persist(account);
//        session.persist(study);
////        em.persist(account);
//        Account brucehan = session.find(Account.class, account.getId());
//        brucehan.setUsername("brrrrrsan");
//        log.info("brucehan: {}", brucehan.getUsername());

        Post post = new Post();
        post.setTitle("Spring Data JPA");

        Comment comment = new Comment();
        comment.setComment("JPA");
        post.addComment(comment);

        Comment comment1 = new Comment();
        comment1.setComment("스프링 데이터 제이피에이");
        post.addComment(comment1);

        Session session = em.unwrap(Session.class);
        session.persist(post);
    }
}
