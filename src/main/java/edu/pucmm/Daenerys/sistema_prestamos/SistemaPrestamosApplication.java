package edu.pucmm.Daenerys.sistema_prestamos;

import edu.pucmm.Daenerys.sistema_prestamos.Encapsulation.Role;
import edu.pucmm.Daenerys.sistema_prestamos.Encapsulation.User;
import edu.pucmm.Daenerys.sistema_prestamos.Repository.Security.RolRepository;
import edu.pucmm.Daenerys.sistema_prestamos.Repository.Security.UserRepository;
import edu.pucmm.Daenerys.sistema_prestamos.Service.Security.SecurityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class SistemaPrestamosApplication {


	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SistemaPrestamosApplication.class, args);

//		String[] lista = applicationContext.getBeanDefinitionNames();
//		System.out.println("====== Beans Registrados =====");
//		for(String bean : lista){
//			System.out.println(""+bean);
//		}


		SecurityServices securityServices = (SecurityServices) applicationContext.getBean("securityServices");
		securityServices.crearUsuarios();

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
