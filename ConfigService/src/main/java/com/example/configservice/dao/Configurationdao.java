package com.example.configservice.dao;
import com.example.configservice.entity.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class Configurationdao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Configuration getconfigurations (int tenantid){
        Query query = new Query();
        query.addCriteria(Criteria.where("tenantid").is(tenantid));
        List<Configuration> configuration = mongoTemplate.find(query, Configuration.class, "tenant_configuration");
        return configuration.size()==1?configuration.get(0):null;
    }

    public Configuration updateconfigurations (Configuration configuration){
        Configuration updated = mongoTemplate.save(configuration, "tenant_configuration");
        return updated;
    }
}
