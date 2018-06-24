package com.cdsoft.mcm.test.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdsoft.mcm.test.service.TestService;

@Controller
@RequestMapping("android/test")
public class TestController {

	private static final Logger logger = Logger.getLogger(TestController.class);
    @Resource
    private TestService testService;
    
    @RequestMapping("queryTest")
    @ResponseBody
    public List<HashMap> queryTest() {
        HashMap map = new HashMap();
        map.put("startDate", "2017-03");
        map.put("endDate", "2018-02");
        List<HashMap> resultList = testService.queryList(map);
        return resultList;
    }
}
