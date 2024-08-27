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
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageID;

    private String content; // 메시지 내용
    private LocalDateTime sentDate; // 메시지 전송일

    @ManyToOne
    @JoinColumn(name = "chatRoomID")
    private ChatRoomEntity chatRoom; // 메시지가 속한 채팅방

    @ManyToOne
    @JoinColumn(name = "senderID")
    private UserEntity sender; // 메시지 발신자

    @ManyToOne
    @JoinColumn(name = "receiverID")
    private UserEntity receiver; // 메시지 수신자 (선택적, 필요에 따라)
}
