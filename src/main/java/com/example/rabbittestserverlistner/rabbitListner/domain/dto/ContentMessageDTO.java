package com.example.rabbittestserverlistner.rabbitListner.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ContentMessageDTO {

    private String sender;
    private String content;
    private String productId;

}
