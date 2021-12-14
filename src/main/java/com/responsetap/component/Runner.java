package com.responsetap.component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import com.responsetap.Application;
import com.responsetap.vo.Telephone;

@Component
public class Runner implements CommandLineRunner {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;
    private final ConfigurableApplicationContext context;

    public Runner(Receiver receiver, RabbitTemplate rabbitTemplate,
            ConfigurableApplicationContext context) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Sending messages...");
        Telephone message = null;
        
        message = new Telephone(UUID.randomUUID().toString(), "+44123412345");
        rabbitTemplate.convertAndSend(Application.queueName, message.toString());
        TimeUnit.SECONDS.sleep(5);
        
        message = new Telephone(UUID.randomUUID().toString(), "+1123412345");
        rabbitTemplate.convertAndSend(Application.queueName, message.toString());
        TimeUnit.SECONDS.sleep(5);

        message = new Telephone(UUID.randomUUID().toString(), "+54123412345");
        rabbitTemplate.convertAndSend(Application.queueName, message.toString());
        TimeUnit.SECONDS.sleep(5);

        message = new Telephone(UUID.randomUUID().toString(), "+39123412345");
        rabbitTemplate.convertAndSend(Application.queueName, message.toString());
        TimeUnit.SECONDS.sleep(5);

        message = new Telephone(UUID.randomUUID().toString(), "+44123412345");
        rabbitTemplate.convertAndSend(Application.queueName, message.toString());
        TimeUnit.SECONDS.sleep(5);

        message = new Telephone(UUID.randomUUID().toString(), "+441823412345");
        rabbitTemplate.convertAndSend(Application.queueName, message.toString());
        TimeUnit.SECONDS.sleep(5);

        message = new Telephone(UUID.randomUUID().toString(), "+39123412345");
        rabbitTemplate.convertAndSend(Application.queueName, message.toString());
        TimeUnit.SECONDS.sleep(5);

        message = new Telephone(UUID.randomUUID().toString(), "+54123412345");
        rabbitTemplate.convertAndSend(Application.queueName, message.toString());
        TimeUnit.SECONDS.sleep(5);

        message = new Telephone(UUID.randomUUID().toString(), "+44123412345");
        rabbitTemplate.convertAndSend(Application.queueName, message.toString());
        TimeUnit.SECONDS.sleep(5);

        message = new Telephone(UUID.randomUUID().toString(), "+1123412345");
        rabbitTemplate.convertAndSend(Application.queueName, message.toString());
        TimeUnit.SECONDS.sleep(5);

        
        this.context.close();
        
        Thread.currentThread().interrupt();
        
        
    }    
}
