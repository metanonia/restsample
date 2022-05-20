package com.metanonia.restsample.service;

import com.metanonia.restsample.model.Depth;
import com.metanonia.restsample.respository.DepthRepository;
import lombok.extern.slf4j.Slf4j;
import org.graalvm.compiler.serviceprovider.ServiceProvider;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class SampleService {
    @Autowired
    DepthRepository depthRepository;

    public String getDepth() {
        List<Depth> list = depthRepository.findAll();
        return list.toString();
    }

    public String genKey() {
        JSONObject jsonObject = new JSONObject();

        UUID uuid = UUID.randomUUID();
        try {
            jsonObject.put("APIKEY", uuid.toString().replaceAll("-",""));
            jsonObject.put("SECRETKEY", CommonService.Sha512(uuid.toString()));
        }
        catch (Exception e) {
            log.info(e.toString());
        }

        return jsonObject.toString();
    }
}
