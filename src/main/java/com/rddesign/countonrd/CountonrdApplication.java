package com.rddesign.countonrd;

import java.time.LocalDateTime;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class CountonrdApplication {

	private static final Logger LOG = LogManager.getLogger(CountonrdApplication.class.getName());
	
	public static void main(String[] args) {
		SpringApplication.run(CountonrdApplication.class, args);
		LOG.info("UP & RUNNING from {info}" + LocalDateTime.now().toString());
		System.out.println("UP AND RUNNING " + LocalDateTime.now().toString());
	}

}
