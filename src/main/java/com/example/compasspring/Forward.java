package com.example.compasspring;

import com.google.gson.JsonObject;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Forward {

    private static Map<String,String> forwards=new HashMap<>();

    public void setForwards(JsonObject jobj) {
        forwards.put("North",jobj.get("North").getAsString());
        forwards.put("North-east",jobj.get("North-east").getAsString());
        forwards.put("East",jobj.get("East").getAsString());
        forwards.put("East-south",jobj.get("East-south").getAsString());
        forwards.put("South",jobj.get("South").getAsString());
        forwards.put("South-west",jobj.get("South-west").getAsString());
        forwards.put("West",jobj.get("West").getAsString());
        forwards.put("West-north",jobj.get("West-north").getAsString());
    }

    public static Map<String, String> getForwards() {
        return forwards;
    }

}
