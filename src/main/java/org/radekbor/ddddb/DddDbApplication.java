package org.radekbor.ddddb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DddDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(DddDbApplication.class, args);
    }

}
