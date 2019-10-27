package com.yizuslabs.jobsfaith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.yizuslabs.jobsfaith")
@EnableJpaRepositories("com.yizuslabs.jobsfaith.persistence.repository")
@EntityScan("com.yizuslabs.jobsfaith.persistence.model")
public class JobsfaithApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobsfaithApplication.class, args);
    }

}
