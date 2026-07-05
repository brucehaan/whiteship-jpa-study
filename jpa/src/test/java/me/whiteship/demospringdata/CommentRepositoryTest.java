package me.whiteship.demospringdata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;

    @Test
    void crud() {
        createComment("spring data jpa", 100);
        createComment("Spring hibernate", 77);

        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "LikeCount"));

        try(Stream<Comment> comments = commentRepository.findByCommentContainsIgnoreCase("spring", pageRequest)) {
            Comment firstComment = comments.findFirst().get();
            assertThat(firstComment.getLikeCount()).isEqualTo(100);
        }
//        assertThat(comments.getNumberOfElements()).isEqualTo(2);
//        assertThat(comments).first().hasFieldOrPropertyWithValue("likeCount", 100);
    }

    private void createComment(String comment, int likes) {
        Comment newComment = new Comment();
        newComment.setComment(comment);
        newComment.setLikeCount(likes);
        commentRepository.save(newComment);
    }
}
