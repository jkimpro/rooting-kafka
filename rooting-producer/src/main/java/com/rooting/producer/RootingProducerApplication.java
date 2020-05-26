package com.rooting.producer;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RootingProducerApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder().bannerMode(Banner.Mode.OFF).sources(RootingProducerApplication.class).properties("spring.config.location="
                + "classpath:/domain.yml"
                + ", classpath:/application.yml").run(args);
    }

}
