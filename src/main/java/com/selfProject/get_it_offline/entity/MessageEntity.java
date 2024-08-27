package com.selfProject.get_it_offline.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;
import javax.persistence.JoinColumn;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageID;

    @ManyToOne
    @JoinColumn(name = "chatRoomId")
    private ChatRoomEntity chatRoom;

    @ManyToOne
    @JoinColumn(name = "senderId")
    private UserEntity sender;

    private String messageContent; // 텍스트 메시지 내용
    private LocalDateTime messageTimestamp; // 메시지 전송 시간

    @ManyToOne
    @JoinColumn(name = "fileId")
    private FileEntity attachedFile; // 첨부된 파일 (이미지 등)
}
