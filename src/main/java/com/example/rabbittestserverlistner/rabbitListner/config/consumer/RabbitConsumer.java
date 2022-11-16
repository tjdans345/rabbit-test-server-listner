package com.example.rabbittestserverlistner.rabbitListner.config.consumer;

import com.example.rabbittestserverlistner.rabbitListner.domain.dto.MessageDTO;
import com.example.rabbittestserverlistner.rabbitListner.service.RabbitMQTestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class RabbitConsumer {

    private final RabbitMQTestService rabbitMQTestService;

    /**
     * rabbitMQ 메시지 구독중 ..
     * @RabbitListener 어노테이션을 이용해서 사용할 queue 를 설정
     * @param message message
     */
    // queues 라는 네이밍을 보아 짐작할 수 있듯이, queue 는 리스트 형식으로 여러개를 입력할 수 있다.
    // ex) queues={"hello","world"}
    // concurrency = "2" 는 한 큐가 2번의 일을 수행한다는 것
    // @RabbitListener(queues = "meteor.queue", concurrency = "2")
    @RabbitListener(queues = "meteor.queue")
    public void processMessage(MessageDTO message) {
        log.info("message : {} ",message.toString());
        rabbitMQTestService.insertDB(message);
        // 1. 주문 메시지 발행 시 주문 로직
    }


}
