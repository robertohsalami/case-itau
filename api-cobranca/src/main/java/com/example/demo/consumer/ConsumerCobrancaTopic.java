package com.example.demo.consumer;

import com.example.demo.model.sns.Notification;
import com.example.demo.service.CobrancaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerCobrancaTopic {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerCobrancaTopic.class);

    @Autowired
    private CobrancaService cobrançaService;

    @KafkaListener(topics = "${kafka.topic_name}", groupId = "${kafka.group_id}")
    public void listener(String message){
        logger.info("Recebendo a mensagem = {}", message);
        Notification notification = new Notification("Cobrança", message);
        logger.info("Notificando o cliente!!!");
        cobrançaService.publishMessage(notification);
        logger.info("Cliente notificado com sucesso");
        logger.info("Persistindo cobranca no banco de dados!");
        cobrançaService.save(cobrançaService.preencheCobranca(message));
        logger.info("Cobranca persistida no banco com sucesso!");
    }

}
