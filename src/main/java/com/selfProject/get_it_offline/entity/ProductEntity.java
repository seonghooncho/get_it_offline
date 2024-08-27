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
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productID;

    private Long productImageFileID; // 제품 사진 파일 ID
    private String productName; // 제품 이름
    private int productQuantity; // 제품 개수
    private String productDetail; // 제품 자세히
    private BigDecimal price; // 제품 가격
    private String description; // 제품 설명

    @ManyToOne
    @JoinColumn(name = "ownerID")
    private UserEntity productOwner; // 제품 소유자
}
