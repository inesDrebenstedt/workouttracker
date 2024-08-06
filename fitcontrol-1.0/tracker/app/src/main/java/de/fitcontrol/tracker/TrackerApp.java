package de.fitcontrol.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.fitcontrol.tracker.config.MongoConfig;
import lombok.extern.log4j.Log4j2;


@SpringBootApplication//(scanBasePackages={"de.fitcontrol.domain.service", "de.fitcontrol.domain.service.ports" , "de.fitcontrol.adapter.restapi.controller"})
@EnableAutoConfiguration //TODO: obsolet?
@EnableMongoRepositories(basePackages="de.fitcontrol.domain.service.ports")
@RestController
@Log4j2
@Import(MongoConfig.class) 
@ComponentScan( basePackages="de.fitcontrol") //TODO: obsolet?  //, "de.fitcontrol.domain.service.ports", "de.fitcontrol.adapter.restapi.controller"})
public class TrackerApp 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(TrackerApp.class, args);
    }
    
    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello!";
    }
}
