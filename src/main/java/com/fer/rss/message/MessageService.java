package com.fer.rss.message;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log
@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;
    private final ModelMapper modelMapper;

    Message addNewMessage(MessageDTO messageDTO) {
        Message newMessage = modelMapper.map(messageDTO, Message.class);
        log.info("Message added: " + newMessage.toString());

        return messageRepository.save(newMessage);
    }

    List<MessageDTO> getMessagesByReceiverId(Long receiverId) {
        List<Message> messages = messageRepository.getMessagesByReceiverId(receiverId);

        return messages.stream()
                .map(message -> modelMapper.map(message, MessageDTO.class))
                .collect(Collectors.toList());
    }

    public List<MessageDTO> getAllMessages() {
        return messageRepository.findAll()
                .stream()
                .map(message -> modelMapper.map(message, MessageDTO.class))
                .collect(Collectors.toList());
    }
}
