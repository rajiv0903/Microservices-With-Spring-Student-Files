package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import demo.controller.HelloController;

@Configuration
@ComponentScan
@ImportResource("gemfire-context.xml")
@EnableGemfireRepositories
@EnableTransactionManagement
@SpringBootApplication
public class Application {

	public static void main(String[] args) 
	{
		ConfigurableApplicationContext xtx = SpringApplication.run(Application.class, args);
        HelloController c =    xtx.getBean(HelloController.class);
        c.doSomeStuff();
        xtx.stop();
	}
}
