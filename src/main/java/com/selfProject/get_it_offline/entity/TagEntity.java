package com.selfProject.get_it_offline.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagID;

    private String tagName; // 태그 이름

    @ManyToMany
    @JoinTable(
            name = "post_tags",
            joinColumns = @JoinColumn(name = "tagID"),
            inverseJoinColumns = @JoinColumn(name = "postID")
    )
    private List<PostEntity> posts; // 태그가 연결된 게시글들
}
