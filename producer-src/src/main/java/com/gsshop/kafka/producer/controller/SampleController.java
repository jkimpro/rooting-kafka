package com.gsshop.kafka.producer.controller;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gsshop.kafka.producer.service.SampleService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class SampleController {
    @Autowired
    private SampleService sampleService;
    
    @RequestMapping(value="/prd/kafka/mpprdm", method = RequestMethod.GET)
    public String samplePrdPrdM(@RequestParam String prdCd ) {
        if(StringUtils.isBlank(prdCd)) {
            throw new RuntimeException();
        }
        
        return sampleService.samplePrdPrdM(new BigDecimal(prdCd));
    }
    
    @RequestMapping(value="/prd/kafka/partition", method = RequestMethod.GET)
    public String samplePrdPrdMPartition() {
        return sampleService.samplePrdPrdMPartition();
    }

    
//    @RequestMapping(value = "prd/kafka/mpPrdMTest", method = RequestMathod.GET)
//    public String sampleOtherPartition() {
//    	return sampleService.samplePr d
//    }

}
            