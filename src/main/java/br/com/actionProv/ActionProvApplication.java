package br.com.actionProv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import br.com.actionProv.controller.UserController;


@Configuration(proxyBeanMethods = false)
@EnableAutoConfiguration
@EnableSpringDataWebSupport
@ComponentScan("br.com.actionProv.service")
@ComponentScan(basePackageClasses = UserController.class)//"br.com.brasilPrev.controller"
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ActionProvApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActionProvApplication.class, args);
	}

}
