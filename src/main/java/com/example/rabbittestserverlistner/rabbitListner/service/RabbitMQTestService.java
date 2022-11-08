package com.example.rabbittestserverlistner.rabbitListner.service;

import com.example.rabbittestserverlistner.rabbitListner.domain.dto.ContentMessageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Service
public class RabbitMQTestService {

    List<ContentMessageDTO> testList = new ArrayList<>();


    public void insertDB(ContentMessageDTO contentMessageDTO) {

        testList.add(contentMessageDTO);
        log.info("testList : {} ", testList);

    }



}
