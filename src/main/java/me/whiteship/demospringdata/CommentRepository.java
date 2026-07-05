package me.whiteship.demospringdata;

import jakarta.annotation.Nonnull;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

//@RepositoryDefinition(domainClass = Comment.class, idClass = Long.class)
public interface CommentRepository extends MyRepository<Comment, Long>{
    @Override
    <E extends Comment> E save(@Nonnull E entity);

    @Override
    List<Comment> findAll();

    @Override
    long count();
}
