package com.example.demo.service;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.example.demo.model.sns.Cobranca;
import com.example.demo.model.sns.Notification;
import com.example.demo.repository.CobrancaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CobrancaService {

    private static final String TOPIC_ARN = "arn:aws:sns:us-east-1:508847964654:cobrancaSNSTopic";

    @Autowired
    private AmazonSNSClient amazonSNSClient;

    @Autowired
    private CobrancaRepository cobrancaRepository;

    public void publishMessage(Notification notification){
        PublishRequest publishRequest = new PublishRequest(TOPIC_ARN, notification.getMessage(), notification.getSubject());
        amazonSNSClient.publish(publishRequest);
    }

    public void save(Cobranca cobranca){
        cobrancaRepository.save(cobranca);
    }

    public Cobranca preencheCobranca(String message){
        Cobranca cobranca = new Cobranca();
        cobranca.setCpf_cliente("25512297711");
        cobranca.setCreated_at(LocalDateTime.now());
        cobranca.setMensagem(message);
        return cobranca;
    }

}
