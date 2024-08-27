package com.selfProject.get_it_offline.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long placeID;

    private Long placeImageFileID; // 장소 사진 파일 ID
    private String placelocation; // 장소 위치
    private String placeWorkingTime; // 장소 영업 시간
    private String placeDetail; // 장소 자세히
    private BigDecimal price; // 장소 대여 가격

    @ManyToOne
    @JoinColumn(name = "ownerID")
    private UserEntity placeOwner; // 장소 소유자
}
