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
public class ChatRoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatRoomID;

    private LocalDateTime createdDate; // 채팅방 생성일

    @ManyToOne
    @JoinColumn(name = "user1ID")
    private UserEntity user1; // 채팅방의 사용자1(장소제공자)

    @ManyToOne
    @JoinColumn(name = "user2ID")
    private UserEntity user2; // 채팅방의 사용자2(장소대여자)
}
