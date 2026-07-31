package com.back.p_62_260730.global;

import com.back.p_62_260730.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BaseInit {

    private final PostService postService;



    @Bean
    ApplicationRunner initDataRunner(){
        return  args -> {
            work1();
            work2();
        };
    }

    void work1() {

        if(postService.count() > 0) {
            return;
        }



        postService.write("제목1", "내용1");
        postService.write("제목2", "내용2");
    }

    void work2() {
        postService.findById(1);
    }
}
