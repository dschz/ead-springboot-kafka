package com.dsc.frm.mailsrv.kafka;

import com.dsc.frm.basedomains.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author DSchneider
 */
@Service
public class EMailConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(EMailConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent orderEvent) {
        LOGGER.info(String.format("Order Event received to process in EMAIL SRV : %s", orderEvent.toString()));

        //action EMAILING (not covered)
    }
}
