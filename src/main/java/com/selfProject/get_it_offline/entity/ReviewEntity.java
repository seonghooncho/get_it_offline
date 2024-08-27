package com.selfProject.get_it_offline.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewID;

    private int rating; // 평점
    private String comment; // 리뷰 내용

    @ManyToOne
    @JoinColumn(name = "userID")
    private UserEntity user; // 리뷰 작성자

    @ManyToOne
    @JoinColumn(name = "productID")
    private ProductEntity product; // 리뷰 대상 제품

    @ManyToOne
    @JoinColumn(name = "placeID")
    private PlaceEntity place; // 리뷰 대상 장소

    private LocalDateTime createdDate; // 리뷰 작성 날짜
}
