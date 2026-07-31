package com.back.p_62_260730.domain.post.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Column(columnDefinition = "TEXT" )
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;



    public Post(String title, String content){
        this.title = title;
        this.content = content;
        createDate = LocalDateTime.now();
        modifyDate = createDate;
    }



}
