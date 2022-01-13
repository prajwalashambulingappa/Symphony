package com.example.poc1.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

@RestController
public class tenantController {
    long id;
    String tenantaccount;
    @RequestMapping("/tenanthello")
    public String tenanthello (@RequestParam(value = "tenantID")String tenantID) throws IOException, ParseException {

        JSONParser parser = new JSONParser();
        try{
            JSONObject tenant = (JSONObject) parser.parse(new FileReader("src/main/resources/1001.config.json"));
            JSONObject jsonArray = (JSONObject) tenant.get("tenant");
            
            id = (long) jsonArray.get("id");
            tenantaccount = (String) jsonArray.get("account");

        }
        catch (IOException | ParseException e){
            e.printStackTrace();
        }

        return ("Hello from tenantid: " + id + " and the account associated with the id is: " + tenantaccount );
    }
}
