package com.metanonia.restsample.controller;

import com.metanonia.restsample.service.SampleService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class SampleController {
    @Autowired
    SampleService sampleService;

    @GetMapping("/")
    public String helloString(@RequestParam HashMap<String,Object>params) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", "OK");
        jsonObject.put("message", "Hello GET");
        jsonObject.put("params", params.toString());
        return jsonObject.toString();
    }
    @PostMapping("/")
    public String postString(@RequestBody String jParam) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", "OK");
        jsonObject.put("message", "Hello POST");
        jsonObject.put("params", jParam);
        return jsonObject.toString();
    }
    @PutMapping("/")
    public String putString(@RequestBody String jParam) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", "OK");
        jsonObject.put("message", "Hello PUT");
        jsonObject.put("params", jParam);
        return jsonObject.toString();
    }
    @DeleteMapping("/")
    public String delString(@RequestBody String jParam) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", "OK");
        jsonObject.put("message", "Hello DELETE");
        jsonObject.put("params", jParam);
        return jsonObject.toString();
    }
    @PatchMapping("/")
    public String pathString(@RequestBody String jParam) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", "OK");
        jsonObject.put("message", "Hello PATCH");
        jsonObject.put("params", jParam);
        return jsonObject.toString();
    }
    @PostMapping("/test/{id}/{sub}")
    public String testId(@RequestParam HashMap<String,Object> params,
                         @RequestBody String body,
                         @PathVariable String id,
                         @PathVariable String sub
                         ) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", "OK");
        jsonObject.put("message", "Hello Multi");
        jsonObject.put("params", params);
        jsonObject.put("body", body);
        jsonObject.put("id", id);
        jsonObject.put("sub", sub);
        return jsonObject.toString();
    }
    @GetMapping("/depth")
    public String depth() {
        return sampleService.getDepth();
    }
}
