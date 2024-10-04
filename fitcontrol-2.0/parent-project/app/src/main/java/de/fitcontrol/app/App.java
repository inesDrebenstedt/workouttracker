package de.fitcontrol.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.extern.log4j.Log4j2;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "de.fitcontrol.service.ports")
@EntityScan(basePackages = "de.fitcontrol.model") 
@Log4j2
@ComponentScan( basePackages={"de.fitcontrol", "de.fitcontrol.service.ports", "de.fitcontrol.restapi.controller"})
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }

}

