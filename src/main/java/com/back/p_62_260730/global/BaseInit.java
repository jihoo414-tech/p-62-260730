package com.back.p_62_260730.global;

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
        };
    }
}
