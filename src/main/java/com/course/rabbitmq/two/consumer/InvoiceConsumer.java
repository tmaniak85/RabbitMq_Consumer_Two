package com.course.rabbitmq.two.consumer;

import com.course.rabbitmq.two.entity.InvoiceCreatedMessage;
import com.course.rabbitmq.two.entity.InvoicePaidMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

//@Service
@RabbitListener(queues = "q.invoice")
public class InvoiceConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(InvoiceConsumer.class);

    @RabbitHandler
    public void handleInvoiceCreated(InvoiceCreatedMessage message) {
        LOG.info("Invoice created: {}", message);
    }

    @RabbitHandler
    public void handleInvoicePaid(InvoicePaidMessage message) {
        LOG.info("Invoice paid: {}", message);
    }

    @RabbitHandler(isDefault = true)
    private void handleDefault(Object message) {
        LOG.info("Default handler: {}", message);
    }
}
