package com.ym.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ConfigTest {

    @Value("${global.params.x}")
    private int x;
    @Value("${global.params.y}")
    private int y;
    @Value("${accounts.params.a}")
    private int a;
    @Value("${accounts.params.b}")
    private int b;

    @GetMapping("/test-config-1")
    public Map<String, Integer> testConfig1(){
        Map<String,Integer> params = new HashMap<>();
        params.put("x", x);
        params.put("y", y);
        params.put("a", a);
        params.put("b", b);
        return params;
    }
}
