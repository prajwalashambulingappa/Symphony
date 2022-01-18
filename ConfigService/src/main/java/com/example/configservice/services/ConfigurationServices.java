package com.example.configservice.services;

import com.example.configservice.dao.Configurationdao;
import com.example.configservice.entity.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationServices {

    @Autowired
    private Configurationdao configurationdao;

    Logger logger = LoggerFactory.getLogger(ConfigurationServices.class);

    @Autowired
    private Cache cache;

    public Configuration getconfiguration(int tenantid){
        Configuration configfromCache = cache.getConfig(tenantid);

        if(configfromCache!=null){
            logger.info("object found in cache for tenant - {}",tenantid);
            return (Configuration) configfromCache;
        }

        Configuration configfromMongo = configurationdao.getconfigurations(tenantid);
        System.out.println(configfromMongo);
        logger.info(configfromMongo.getAccount());
        cache.addConfigcache(tenantid, configfromMongo);

        return configfromMongo;
//        return configurationdao.getconfigurations(tenantid);
    }

    public Configuration updateconfigurations (Configuration new_configuration){
        return configurationdao.updateconfigurations(new_configuration);
    }
}
