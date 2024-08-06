package de.fitcontrol.domain.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.TestPropertySource;

import de.fitcontrol.domain.config.MongoTestConfig;
import de.flapdoodle.embed.mongo.MongodExecutable;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(properties = "spring.mongodb.embedded.version=3.6.5")
public class MyMongoTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    private MongodExecutable mongodExecutable;

    @BeforeAll
    public void setUp() throws Exception {
        // Set up the embedded MongoDB instance
    	MongoTestConfig mongoConfig = new MongoTestConfig();
//        mongodExecutable = mongoConfig.mongoClient();
//        mongoTemplate = mongoConfig.mongoTemplate();
    }

    @AfterAll
    public void tearDown() {
        // Stop the embedded MongoDB instance
        if (mongodExecutable != null) {
            mongodExecutable.stop();
        }
    }

    // Your test methods here
}
