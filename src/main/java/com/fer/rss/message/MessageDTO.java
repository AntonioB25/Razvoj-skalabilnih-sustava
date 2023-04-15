package com.fer.rss.message;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageDTO {
    private Long senderId;
    private Long receiverId;
    private String message;
}
