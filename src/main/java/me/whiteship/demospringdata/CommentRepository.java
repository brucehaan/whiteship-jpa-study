package me.whiteship.demospringdata;

import jakarta.annotation.Nonnull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;
import java.util.stream.Stream;


/**
 * 쿼리 만드는 방법
 * 리턴타입 {접두어}{도입부}By{프로퍼티 표현식}(조건식)[(And|Or){프로퍼티 표현식}(조건식)]{정렬 조건} (매개변수)
 */
//@RepositoryDefinition(domainClass = Comment.class, idClass = Long.class)
public interface CommentRepository extends MyRepository<Comment, Long> {

//    List<Comment> findByCommentContainsIgnoreCaseAndLikeCountGreaterThan(String keyword, int likeCount);
//    List<Comment> findByCommentContainsIgnoreCaseOrderByLikeCountDesc(String keyword);
//    Page<Comment> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);
    Stream<Comment> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);
}
