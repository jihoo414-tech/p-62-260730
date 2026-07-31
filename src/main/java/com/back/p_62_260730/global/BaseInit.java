package com.back.p_62_260730.global;

import com.back.p_62_260730.domain.post.entity.Post;
import com.back.p_62_260730.domain.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseInit {


    @Autowired
    PostRepository postRepository;

    @Bean
    ApplicationRunner initDataRunner(){
        return  args -> {
            System.out.println("post의 row 개수를 셉니다.");
            postRepository.count();

            //post 하나 저장
            Post post = new Post();
            post.setTitle("제목1");
            post.setContent("내용1");
            postRepository.save(post);

            //post 조회
        };
    }
}
