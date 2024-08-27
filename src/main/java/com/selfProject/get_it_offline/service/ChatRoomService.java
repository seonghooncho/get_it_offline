package com.selfProject.get_it_offline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class ChatRoomService {

    @Autowired
    private ChatRoomRepository chatRoomRepository;

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Autowired
    private ChatRoomUserRepository chatRoomUserRepository;

    @Autowired
    private FileService fileService;

    @Transactional
    public ChatRoomEntity createChatRoom(String roomName) {
        ChatRoomEntity chatRoom = new ChatRoomEntity();
        chatRoom.setRoomName(roomName);
        chatRoom.setCreatedDate(LocalDateTime.now());
        return chatRoomRepository.save(chatRoom);
    }

    @Transactional
    public ChatMessageEntity sendMessage(Long chatRoomId, Long senderId, String messageContent, MultipartFile attachedFile) throws IOException {
        ChatRoomEntity chatRoom = chatRoomRepository.findById(chatRoomId).orElseThrow(() -> new RuntimeException("Chat room not found"));
        UserEntity sender = new UserEntity();
        sender.setUserID(senderId);  // Assume user exists; replace with proper retrieval
        
        ChatMessageEntity message = new ChatMessageEntity();
        message.setChatRoom(chatRoom);
        message.setSender(sender);
        message.setMessageContent(messageContent);
        message.setMessageTimestamp(LocalDateTime.now());

        if (attachedFile != null && !attachedFile.isEmpty()) {
            FileEntity fileEntity = fileService.store(attachedFile);
            message.setAttachedFile(fileEntity);
        }

        return chatMessageRepository.save(message);
    }
}
