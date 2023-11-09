package com.example.botscrewtask;

import com.example.botscrewtask.utils.ConsoleInputInterfaceUtil;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(entityManagerFactoryRef = "sessionFactory")
public class BotsCrewTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(BotsCrewTaskApplication.class, args);
    }


}
