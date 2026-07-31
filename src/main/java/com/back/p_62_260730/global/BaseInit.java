package com.back.p_62_260730.global;

import com.back.p_62_260730.domain.post.entity.Post;
import com.back.p_62_260730.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BaseInit {

    private final PostService postService;

    @Lazy
    @Autowired
    private BaseInit self;



    @Bean
    ApplicationRunner initDataRunner(){
        return  args -> {
            System.out.println("초기화 작업을 수행합니다.");
            work1();
            work2();
            new Thread(() -> {
                self.work3();
            }).start();

        };
    }
    @Transactional
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

    @Transactional
    void work3() {
        Post post1 = postService.findById(1).get();
        Post post2 = postService.findById(2).get();

        postService.delete(post1);
        if(true){
            throw new RuntimeException("테스트 예외");
        }
        postService.delete(post2);
    }
}
