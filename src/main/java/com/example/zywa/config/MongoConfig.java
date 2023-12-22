package com.example.zywa.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.zywa.repo.CardStatusRepository;

@Configurable
@EnableMongoRepositories(basePackageClasses = CardStatusRepository.class)
public class MongoConfig {

	@Bean
	public CommandLineRunner commandLineRunner(CardStatusRepository userRepo) {
		return null;
	}

}
//@Configuration
//@EnableMongoRepositories(basePackages = "com.zywa.cardstatus.repository")
//public class MongoConfig extends AbstractMongoClientConfiguration {
//
//    @Override
//    protected String getDatabaseName() {
//        return "cardstatus";
//    }
//
//    @Bean
//    @Override
//    public MongoClient mongoClient() {
//        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/cardstatus");
//        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
//                .applyConnectionString(connectionString)
//                .build();
//
//        return MongoClients.create(mongoClientSettings);
//    }
//}