package com.rooting.producer.controller;


import com.rooting.producer.service.SampleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class SampleController {
    @Autowired
    private SampleService sampleService;

    @RequestMapping(value = "/kafka/sample", method = RequestMethod.GET)
    public String sample(@RequestParam String prdCd){
        if(StringUtils.isBlank(prdCd)){
            throw new RuntimeException();
        }
        return sampleService.sample(new BigDecimal(prdCd));
    }


}
