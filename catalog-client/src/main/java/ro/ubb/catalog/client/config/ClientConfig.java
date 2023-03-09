package ro.ubb.catalog.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import ro.ubb.catalog.client.ui.Console;

@Configuration
public class ClientConfig {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    Console clientConsole() {
        Console clientConsole = new Console();
        return clientConsole;
    }

}
