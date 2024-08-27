package com.selfProject.get_it_offline.entity;
import com.selfProject.get_it_offline.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name ="userTable")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    public UserDTO toUserDTO(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        userDTO.set
    }
}
