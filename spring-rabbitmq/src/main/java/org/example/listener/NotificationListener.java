package org.example.listener;

import org.example.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @RabbitListener(queues = "examples-queue")
    public void handlerQueue(Notification notification){
        System.out.println("Message received...");
        System.out.println(notification.toString());
    }
}
