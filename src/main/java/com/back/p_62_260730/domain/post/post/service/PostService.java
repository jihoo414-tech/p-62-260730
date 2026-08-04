package com.back.p_62_260730.domain.post.post.service;

import com.back.p_62_260730.domain.post.post.entity.Post;
import com.back.p_62_260730.domain.post.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post write(String title, String content, int authorId){

        Post post = new Post(title,content,authorId);
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
        post.modify(title,content);
    }
}
