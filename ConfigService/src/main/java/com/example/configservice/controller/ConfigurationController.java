package com.example.configservice.controller;

import com.example.configservice.entity.Configuration;
import com.example.configservice.services.ConfigurationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/configuration")
public class ConfigurationController {

    @Autowired
    private ConfigurationServices configurationServices;

    @GetMapping("/{id}")
    public Configuration getconfiguration(@PathVariable int id){
        return configurationServices.getconfiguration(id);
    }

    @PostMapping("/new-tenant")
    public Configuration addConfiguration(@RequestBody Configuration configuration){
        return configurationServices.updateconfigurations(configuration);
    }
}
