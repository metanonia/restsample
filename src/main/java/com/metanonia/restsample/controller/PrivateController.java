package com.metanonia.restsample.controller;

import com.metanonia.restsample.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@Slf4j
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
