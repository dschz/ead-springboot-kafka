package com.dsc.frm.ordersrv.controller;

import com.dsc.frm.basedomains.dto.Order;
import com.dsc.frm.basedomains.dto.OrderEvent;
import com.dsc.frm.ordersrv.kafka.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author DSchneider
 */
@RestController
@RequestMapping("api/v1")
public class OrderController {

    private OrderProducer producer;

    public OrderController(OrderProducer producer) {
        this.producer = producer;
    }

    @PostMapping("orders")
    public String addOrder(@RequestBody Order order) {
        order.setOrderId(UUID.randomUUID().toString());//def d'un id

        OrderEvent event = new OrderEvent();
        event.setStatus("PENDING");
        event.setMsg("Order in pending state");
        event.setOrder(order);

        producer.sendMessage(event);

        return "Order set in topic ok";
    }
}
