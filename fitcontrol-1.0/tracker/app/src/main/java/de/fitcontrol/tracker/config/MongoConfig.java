package de.fitcontrol.tracker.config;

import java.util.ArrayList;
import java.util.List;

import org.bson.UuidRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import de.fitcontrol.domain.service.ports.LongToObjectIdConverter;
import de.fitcontrol.domain.service.ports.MapToArrayListConverter;
import de.fitcontrol.domain.service.ports.ArrayListToMapConverter;
import de.fitcontrol.domain.service.ports.ObjectIdToLongConverter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableReactiveMongoRepositories
@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration{
	
	@Value("${spring.data.mongodb.uri}")		
	String mongoDbUrl;
	

    private static MongoClient mongoClient;

    static {
        // Configure the MongoDB client with UUID representation
        MongoClientSettings settings = MongoClientSettings.builder()
                .uuidRepresentation(UuidRepresentation.STANDARD)
                .build();

        mongoClient = MongoClients.create(settings);
    }
    
    public static MongoClient getMongoClient() {
        return mongoClient;
    }
	

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(new SimpleMongoClientDatabaseFactory(mongoDbUrl));
    }
    
    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(mongoDbUrl);//?authMode=SCRAM-SHA-1??

        //return MongoClients.create("mongodb://test01:test01@localhost/test_db?authMode=SCRAM-SHA-1");
    }
    
    @Override
    public MongoCustomConversions customConversions() {
    	log.warn("============================> !1!");
        List<Converter<?, ?>> converters = new ArrayList<>();
        converters.add(new ObjectIdToLongConverter());
        converters.add(new LongToObjectIdConverter());
        converters.add(new ArrayListToMapConverter());
        converters.add(new MapToArrayListConverter());
        return new MongoCustomConversions(converters);
    }

    @Override
    protected String getDatabaseName() {
        return "fitcontroldb";
    }
}
