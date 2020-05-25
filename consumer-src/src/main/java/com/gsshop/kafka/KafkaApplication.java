package com.gsshop.kafka;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KafkaApplication {

	public static void main(String[] args) {
        new SpringApplicationBuilder().bannerMode(Banner.Mode.OFF).sources(KafkaApplication.class).properties("spring.config.location="
                + "classpath:/domain.yml"
                + ", classpath:/application.yml").run(args);
        }
}
