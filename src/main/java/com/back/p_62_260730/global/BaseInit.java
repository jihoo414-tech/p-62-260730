package com.back.p_62_260730.global;

import com.back.p_62_260730.domain.post.entity.Post;
import com.back.p_62_260730.domain.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class BaseInit {


    @Autowired
    PostRepository postRepository;

    @Bean
    ApplicationRunner initDataRunner(){
        return  args -> {
            System.out.println("초기화 작업을 수행합니다.");
            if(postRepository.count() > 0){
                return;
            }

            //post 하나 저장
            Post post = new Post("제목","내용");
//            post.setTitle("제목1");
//            post.setContent("내용1");
            postRepository.save(post);

            //post 조회
           Optional<Post> opPost =  postRepository.findById(1);

           if(opPost.isPresent()){
               System.out.println(opPost.get().getTitle());
               System.out.println(opPost.get().getContent());
           }
        };
    }
}
