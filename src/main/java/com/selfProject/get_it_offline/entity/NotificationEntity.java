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
public class NotificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationID;

    private String message; // 알림 내용
    private boolean isRead; // 알림 읽음 여부
    private LocalDateTime createdDate; // 알림 생성 날짜

    @ManyToOne
    @JoinColumn(name = "userID")
    private UserEntity user; // 알림을 받을 사용자
}
