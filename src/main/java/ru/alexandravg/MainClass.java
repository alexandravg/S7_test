package ru.alexandravg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class},
        scanBasePackages = {"ru.alexandravg.controller", "ru.alexandravg.entity", "ru.alexandravg.repository",
                "ru.alexandravg.service"})
@EnableJpaRepositories(basePackages = "ru.alexandravg.repository")
@EntityScan(basePackages = "ru.alexandravg.entity")
@EnableAutoConfiguration
public class MainClass {
    public static void main(String[] args) {
        SpringApplication.run(MainClass.class, args);
    }
}
