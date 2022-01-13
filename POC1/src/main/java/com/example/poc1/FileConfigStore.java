package com.example.poc1;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Service
public class FileConfigStore implements ConfigStore{

    Logger logger = LoggerFactory.getLogger(FileConfigStore.class);

    @Override
    public JSONObject getProperty() {
        int tenantId = TenantContext.getTenantID();

        JSONObject properties = readConfigFiles(tenantId);
        logger.info("tenant: "+properties);
        return properties;
    }

    public JSONObject readConfigFiles(int tenantID){

        JSONParser jsonParser = new JSONParser();
        String tenant_account;
        JSONObject jsonObject = null;
        JSONObject tenant = null;

        try{
            FileReader reader = new FileReader("src/main/resources/"+tenantID+".config.json");

            Object object = jsonParser.parse(reader);
            jsonObject = (JSONObject) object;
            tenant = (JSONObject) jsonObject.get("tenant");
            tenant_account = (String) tenant.get("account");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        } catch (ParseException e){
            e.printStackTrace();
        }

        return jsonObject;
    }
}
