package com.cdsoft.mcm.index.controller;


import com.cdsoft.mcm.index.service.IQueryIndexService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * echarts 指标查询接口
 */
@Controller
@RequestMapping("android/doQueryIndexForMobile")
public class QueryIndexAction {
    private static final Logger logger = Logger.getLogger(QueryIndexAction.class);
    @Resource
    private IQueryIndexService queryIndexService;

    /**
     * 电厂厂损值
     *
     * @return
     */
    @RequestMapping("queryChSzIndex")
    @ResponseBody
    public List<HashMap> queryChSzIndex() {
        HashMap params = new HashMap();
        params.put("startDate", "2017-01");
        params.put("endDate", "2018-01");
        List<HashMap> resultList = queryIndexService.queryChSzIndex(params);
        return resultList;
    }
}
