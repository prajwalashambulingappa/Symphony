package com.example.coreservicesmongo.configurations;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoDatabase;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import java.util.Objects;

public class DatabaseConfig {

/*    private String DbConnectionString;
    public DatabaseConfig(String dbConnectionString, ConnectionString connection){
        super(connection);
        this.DbConnectionString = dbConnectionString;
    }

    @Override
    protected MongoDatabase doGetMongoDatabase(String dbName){
        ConnectionString connection = new ConnectionString(DbConnectionString);
        return super.doGetMongoDatabase(Objects.requireNonNull(connection.getDatabase()));
    }
}*/
}
