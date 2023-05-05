package com.example.demo.controller;

import com.example.demo.model.sns.Notification;
import com.example.demo.service.CobrancaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CobrancaController {

    @Autowired
    private CobrancaService cobrançaService;

    @PostMapping(value = "/sendNotification")
    public ResponseEntity<String> publishMessageToTopic(@RequestBody final Notification notification){
        cobrançaService.publishMessage(notification);
        return new ResponseEntity<>("Notification sent successfully!!", HttpStatus.OK);
    }

}
