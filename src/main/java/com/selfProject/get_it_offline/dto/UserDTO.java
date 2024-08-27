package com.selfProject.get_it_offline.dto;

import com.selfProject.get_it_offline.entity.ChatRoomEntity;
import com.selfProject.get_it_offline.entity.MessageEntity;

import javax.persistence.OneToMany;
import java.util.List;

public class UserDTO {
    private Long userID;

    private String userEmail;
    private String userPassword;
    private String userName;
    private String userRole; // 예: "USER", "ADMIN"
    private Long rating;     // 평점 (점수에 따라 구현파트에서 등급을 정해줌, 표정 이모티콘으로?)1~100

    @OneToMany(mappedBy = "user1")
    private List<ChatRoomEntity> chatRoomsAsUser1; // 사용자가 첫 번째 사용자로 참여한 채팅방들

    @OneToMany(mappedBy = "user2")
    private List<ChatRoomEntity> chatRoomsAsUser2; // 사용자가 두 번째 사용자로 참여한 채팅방들

    @OneToMany(mappedBy = "sender")
    private List<MessageEntity> sentMessages; // 사용자가 보낸 모든 메시지들

    @OneToMany(mappedBy = "receiver")
    private List<MessageEntity> receivedMessages; // 사용자가 받은 모든 메시지들

}
