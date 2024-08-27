package com.selfProject.get_it_offline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatRoomController {

    @Autowired
    private ChatRoomService chatRoomService;

    @PostMapping("/create")
    public ChatRoomEntity createChatRoom(@RequestParam String roomName) {
        return chatRoomService.createChatRoom(roomName);
    }

    @PostMapping("/send")
    public ChatMessageEntity sendMessage(
            @RequestParam Long chatRoomId,
            @RequestParam Long senderId,
            @RequestParam String messageContent,
            @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        return chatRoomService.sendMessage(chatRoomId, senderId, messageContent, file);
    }
}
