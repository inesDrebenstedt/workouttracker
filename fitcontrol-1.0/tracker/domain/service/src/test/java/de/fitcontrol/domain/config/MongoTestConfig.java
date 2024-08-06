package de.fitcontrol.domain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
//import de.flapdoodle.embed.mongo.config.IMongodConfig;
//import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;

@Configuration
public class MongoTestConfig {

    private MongodExecutable mongodExecutable;

//    @Bean
//    public MongoClient mongoClient() throws Exception {
//        MongodStarter starter = MongodStarter.getDefaultInstance();
//        String bindIp = "localhost";
//        int port = 27017;
//        IMongodConfig mongodConfig = new MongodConfigBuilder()
//                .version(Version.Main.PRODUCTION)
//                .net(new de.flapdoodle.embed.mongo.config.Net(bindIp, port, Network.localhostIsIPv6()))
//                .build();
//
//        mongodExecutable = starter.prepare(mongodConfig);
//        MongodProcess mongod = mongodExecutable.start();
//
//        return new MongoClient(bindIp, port);
//    }
//
//    @Bean
//    public MongoTemplate mongoTemplate() throws Exception {
//        return new MongoTemplate(mongoClient(), "test");
//    }
}

