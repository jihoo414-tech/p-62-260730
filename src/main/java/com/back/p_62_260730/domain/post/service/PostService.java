package com.back.p_62_260730.domain.post.service;

import com.back.p_62_260730.domain.post.entity.Post;
import com.back.p_62_260730.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post write(String title, String content){

        Post post1 = new Post(title,content);
        return postRepository.save(post1);


    }
    public Optional<Post> findById(int id){
        return postRepository.findById(id);
    }

    public long count(){
        return postRepository.count();
    }
}
