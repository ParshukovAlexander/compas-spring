package com.example.compasspring.controller;

import com.example.compasspring.Forward;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class Controller {

    @Autowired
    Forward forward;

    @PostMapping("/settings-forward")
    public void setForward(@RequestBody Object o){

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject jobj=gson.fromJson(String.valueOf(o),JsonObject.class);
        forward.setForwards(jobj);
    }

    @GetMapping("/get-side")
    public String getSide(@RequestBody Object o) throws JSONException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject jobj=gson.fromJson(String.valueOf(o),JsonObject.class);
        int degree = Integer.parseInt(jobj.get("Degree").getAsString());

        Map<String, String> forwards = Forward.getForwards();

        String side="Не найденно";
        for (var f:forwards.entrySet()){
            String []startAndFinish =f.getValue().split("-");
            if (Integer.parseInt(startAndFinish[0]) >Integer.parseInt(startAndFinish[1])){
                if (Integer.parseInt(startAndFinish[0]) >= degree && Integer.parseInt(startAndFinish[1]) >= degree ){
                    side=f.getKey();
                }
            }else {
                if (Integer.parseInt(startAndFinish[0]) <= degree && Integer.parseInt(startAndFinish[1]) >= degree) {
                    side = f.getKey();
                }

            }
        }

        JSONObject jo = new JSONObject();
        jo.put("Side", side);
        return jo.toString();
    }
}
