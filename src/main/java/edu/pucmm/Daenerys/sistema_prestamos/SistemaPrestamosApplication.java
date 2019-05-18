package edu.pucmm.Daenerys.sistema_prestamos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class SistemaPrestamosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaPrestamosApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200", "http://localhost:4200/categoria")
						.allowedMethods("GET","PUT","POST","DELETE","OPTIONS", "*")
						.allowedHeaders("Access-Control-Allow-Headers", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,", "Access-Control-Allow-Origin", "*")
						.allowCredentials(false).maxAge(3600);
			}
		};
	}
}
