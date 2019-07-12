package br.exemplo.minicrm.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@Configuration
public class ConfigApp {

    @Value("${fila.exibe.empresa}")
    private String fila;

    @Bean
    public Queue getQueue(){
        return new Queue(fila, true);
    }
}
