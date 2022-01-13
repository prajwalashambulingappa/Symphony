package com.example.poc1;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface ConfigStore {

    public JSONObject getProperty();
}
