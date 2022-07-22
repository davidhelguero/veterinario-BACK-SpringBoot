package com.veterinario.demo;

import com.veterinario.demo.service.FileService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

//@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.veterinario.demo.repository.AnimalRepository", entityManagerFactoryRef = "sessionFactory")

//@ComponentScan(basePackages = {"com.veterinario"})


@SpringBootApplication(scanBasePackages = {"service","com.veterinario.demo.service.FileService"} , exclude = {DataSourceAutoConfiguration.class,JpaRepositoriesAutoConfiguration.class})

//@SpringBootApplication(exclude = JpaRepositoriesAutoConfiguration.class)
//@ComponentScan({"com.veterinario.demo.service"})
//@EnableJpaRepositories("com.veterinario.demo.repository.AnimalRepository")

//@SpringBootApplication(scanBasePackages = {"boot.registration"} , exclude = {JpaRepositoriesAutoConfiguration.class})
//@ComponentScan({"com.veterinario.demo.service"})

//@SpringBootApplication(scanBasePackages = {"boot.registration"} , exclude = {JpaRepositoriesAutoConfiguration.class})

//@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, XADataSourceAutoConfiguration.class})
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@EnableAutoConfiguration
public class DemoApplication  implements CommandLineRunner {

	//@Resource
	//FileService fileService;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception{
		//fileService.deleteAll();
		//fileService.init();
	}

	/* En caso que tenga problema con los cors agregar este Bean */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
			}
		};
	}
}
