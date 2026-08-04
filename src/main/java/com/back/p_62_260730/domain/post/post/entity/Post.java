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


    private String title;
    @Column(columnDefinition = "TEXT" )
    private String content;


    public Post(String title, String content){
        this.title = title;
        this.content = content;
    }

    public void modify(String title, String content){
        this.title = title;
        this.content = content;
    }



}
