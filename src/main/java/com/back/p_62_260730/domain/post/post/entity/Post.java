package com.back.p_62_260730.domain.post.post.entity;


import com.back.p_62_260730.global.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Post extends BaseEntity{


    private String title; // varchar(255)
    @Column(columnDefinition = "TEXT" )
    private String content; // varchar(255)
    private int authorId; // 작성자 외래키


    public Post(String title, String content, int authorId){
        this.title = title;
        this.content = content;
        this.authorId = authorId;
    }

    public void modify(String title, String content){
        this.title = title;
        this.content = content;
    }



}
