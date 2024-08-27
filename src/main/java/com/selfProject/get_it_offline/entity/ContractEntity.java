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
public class ContractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractID;

    private Long placeID; // 장소 계약 ID
    private Long productID; // 제품 계약 ID
    private Long contractFileID; // 계약서 파일 ID

    private LocalDateTime contractDate; // 계약 체결일
    private String status; // 계약 상태 ("IN_PROGRESS", "COMPLETED", "CANCELED")
}
