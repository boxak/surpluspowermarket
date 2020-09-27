package com.project.surpluspowermarket;

import com.project.surpluspowermarket.entity.UserEntity;
import com.project.surpluspowermarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.ModelAttribute;

@SpringBootApplication
public class SurpluspowermarketApplication {
    public static void main(String[] args) {
        SpringApplication.run(SurpluspowermarketApplication.class, args);
    }
}
