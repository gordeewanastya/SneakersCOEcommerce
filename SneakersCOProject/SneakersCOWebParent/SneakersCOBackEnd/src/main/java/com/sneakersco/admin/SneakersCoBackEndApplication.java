package com.sneakersco.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.sneakersco.common.entity", "com.sneakersco.admin.user"})
public class SneakersCoBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(SneakersCoBackEndApplication.class, args);
	}

}
