package com.example.rabbittestserverlistner.rabbitListner.config.listnener;

import com.example.rabbittestserverlistner.rabbitListner.domain.dto.ContentMessageDTO;
import com.example.rabbittestserverlistner.rabbitListner.service.RabbitMQTestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class RabbitListenerConfig {

    private final RabbitMQTestService rabbitMQTestService;

    /**
     * rabbitMQ 메시지 구독중 ..
     * @param contentMessageDTO contentMessageDTO
     */
    @RabbitListener(queues = "TestQ")
    public void processMessage(ContentMessageDTO contentMessageDTO) {
        log.info(contentMessageDTO.getContent());
        rabbitMQTestService.insertDB(contentMessageDTO);
        // 1. 주문 메시지 발행 시 주문 로직


    }

}
