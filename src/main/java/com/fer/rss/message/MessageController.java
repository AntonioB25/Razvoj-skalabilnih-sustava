package com.fer.rss.message;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Log
@RequiredArgsConstructor
@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;

    @GetMapping("")
    List<MessageDTO> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping(params = "receiverId")
    List<MessageDTO> getMessagesByReceiverId(@RequestParam Long receiverId) {
        return messageService.getMessagesByReceiverId(receiverId);
    }

    @PostMapping
    ResponseEntity<String> addNewMessage(@RequestBody MessageDTO messageDTO) {
        Message savedMessage = messageService.addNewMessage(messageDTO);

        URI location =
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(savedMessage.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
