/**
* The Buys Used Cars Application Service that provide API 
*
* @author  Kiran K
* @version 1.0
*/

package com.buycars.warehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class BuyCarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuyCarsApplication.class, args);
	}

}
