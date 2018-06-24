package com.cdsoft.mcm.index.service.impl;

import com.cdsoft.mcm.index.mapper.QueryIndexMapper;
import com.cdsoft.mcm.index.service.IQueryIndexService;
import com.cdsoft.platform.common.CustomerContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class QueryIndexServiceImpl implements IQueryIndexService {
    @Resource
    private QueryIndexMapper queryIndexMapper;

    @Override
    public List<HashMap> queryChSzIndex(HashMap params) {
        //切换查询的数据库
        CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_ECHARTS);
        return queryIndexMapper.queryChSzIndex(params);
    }
}
