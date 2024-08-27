package com.selfProject.get_it_offline.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postID;

    private String title; // 게시글 제목

    @OneToMany
    private List<CommentEntity> commentIDList;

    private int postType; // 0: 장소, 1: 제품

    private Long placeOrProductID; // 장소 또는 제품 ID
    @ManyToOne
    @JoinColumn(name = "fileId")
    private FileEntity attachedFile; // 첨부된 파일 (이미지 등)

    @ManyToOne
    @JoinColumn(name = "authorID")
    private UserEntity author; // 작성자

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
