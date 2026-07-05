package me.whiteship.demospringdata;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Component
@Transactional
public class JpaRunner implements ApplicationRunner {
//    @PersistenceContext
//    EntityManager em;

    @Autowired
    PostRepository postRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Type Safe하지 않음.
//        TypedQuery<Post> query = em.createQuery("select p from Post as p", Post.class);// DB에 독립적임
//        List<Post> posts = query.getResultList();
//        posts.forEach(System.out::println);
        postRepository.findAll().forEach(System.out::println);
    }
}
