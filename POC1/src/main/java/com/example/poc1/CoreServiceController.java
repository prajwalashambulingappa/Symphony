package com.example.poc1;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoreServiceController {
    private final ConfigStore store;

    public CoreServiceController(@Qualifier("fileConfigStore") ConfigStore store) {
        this.store = store;
    }

    @GetMapping("/config")
    public JSONObject getConfig(){
        int id = 0;

        id = TenantContext.getTenantID();

        if (id==0){
            throw new RuntimeException("ID can't be fetched");
        }
        JSONObject properties = store.getProperty();

        return properties;
    }
}
