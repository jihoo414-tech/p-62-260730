package com.back.p_62_260730;

import com.back.p_62_260730.domain.post.post.entity.Post;
import com.back.p_62_260730.domain.post.post.repository.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional // 테스트 환경에서는 수행한 뒤 바뀐 DB를 원상복구 시켜준다. 여기에 붙이면, 메서드 단위로 수행
@ActiveProfiles("test")
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    @DisplayName("2번 글 조회")
    void t1() {
        Post post1 = postRepository.findById(2).get();

        assertThat(post1.getId()).isEqualTo(2);
        assertThat(post1.getTitle()).isEqualTo("테스트용 제목2");
        assertThat(post1.getContent()).isEqualTo("테스트용 내용2");

    }
}