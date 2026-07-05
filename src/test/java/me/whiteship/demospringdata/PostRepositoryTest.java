package me.whiteship.demospringdata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
//@DataJpaTest // Data Access 단만 테스트
@SpringBootTest
@Transactional
class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;

    @Test
    void crudRepositoryTest() {
        // given
        Post post = new Post();
        post.setTitle("spring boot");
        assertThat(post.getId()).isNull();

        // when
        Post newPost = postRepository.save(post);

        // then
        assertThat(newPost.getId()).isNotNull();

        // when
        List<Post> posts = postRepository.findAll();

        // then
        assertThat(posts.size()).isEqualTo(1);
        assertThat(posts).contains(newPost);

        // when
        Page<Post> page = postRepository.findAll(PageRequest.of(0, 10));
        assertThat(page.getTotalElements()).isEqualTo(1);
        assertThat(page.getNumber()).isEqualTo(0);
        assertThat(page.getSize()).isEqualTo(10); // 요청했던 사이즈
        assertThat(page.getNumberOfElements()).isEqualTo(1);

        // when
        page = postRepository.findByTitleContains("spring", PageRequest.of(0, 10));

        // then
        assertThat(page.getTotalElements()).isEqualTo(1);
        assertThat(page.getNumber()).isEqualTo(0);
        assertThat(page.getSize()).isEqualTo(10);
        assertThat(page.getNumberOfElements()).isEqualTo(1);

        // when
        long spring = postRepository.countByTitleContains("spring");
        // then
        assertThat(spring).isEqualTo(1);


    }
}