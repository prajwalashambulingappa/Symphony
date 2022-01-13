package com.example.coreservicesmongo.configurations;

import com.mongodb.ConnectionString;
import org.springframework.context.annotation.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.context.WebApplicationContext;

/*@Configuration
@Lazy*/
public class MongoConfig {

   /* @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    @Lazy
    @Primary
    public MongoTemplate mongoTemplate(){
        TenantContext tenantContext = TenantContext.getContext();
        ConnectionString connection = new ConnectionString(tenantContext.getDBConnectionString());
        System.out.println(tenantContext+"  "+connection);
        return new MongoTemplate(new DatabaseConfig(tenantContext.getDBConnectionString(), connection));
    }*/
}
