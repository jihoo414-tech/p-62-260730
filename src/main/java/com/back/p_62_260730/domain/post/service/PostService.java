package com.back.p_62_260730.domain.post.service;

import com.back.p_62_260730.domain.post.entity.Post;
import com.back.p_62_260730.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post write(String title, String content){

        Post post = new Post(title,content);
        return postRepository.save(post);


    }
    public Optional<Post> findById(int id){
        return postRepository.findById(id);
    }

    public long count(){
        return postRepository.count();
    }

    public void delete(Post post) {
        postRepository.delete(post);
    }

    public void modify(Post post, String title, String content) {
        post.setTitle(title);
        post.setContent(content);
        post.setModifyDate(LocalDateTime.now());

        postRepository.save(post);
    }
}
