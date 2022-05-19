package com.metanonia.restsample.controller;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/private")
public class PrivateController {
    @GetMapping("/info")
    public String getUserInfo(@RequestHeader("x-apikey") String apiKey) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("APIKEY", apiKey);

        return jsonObject.toString();
    }

    @GetMapping("/header")
    public String getUserInfo(@RequestHeader HashMap<String,Object> map) {
        JSONObject jsonObject = new JSONObject(map);

        return jsonObject.toString();
    }
}
