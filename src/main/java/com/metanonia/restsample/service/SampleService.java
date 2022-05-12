package com.metanonia.restsample.service;

import com.metanonia.restsample.model.Depth;
import com.metanonia.restsample.respository.DepthRepository;
import org.graalvm.compiler.serviceprovider.ServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleService {
    @Autowired
    DepthRepository depthRepository;

    public String getDepth() {
        List<Depth> list = depthRepository.findAll();
        return list.toString();
    }
}
