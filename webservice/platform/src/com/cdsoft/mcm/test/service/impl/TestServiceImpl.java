package com.cdsoft.mcm.test.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cdsoft.mcm.test.mapper.TestMapper;
import com.cdsoft.mcm.test.service.TestService;
import com.cdsoft.platform.common.CustomerContextHolder;

@Service
public class TestServiceImpl implements TestService {

	@Resource
	private TestMapper testMapper;
	@Override
	public List<HashMap> queryList(HashMap map) {
		 //切换查询的数据库
        CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_ECHARTS);
        return testMapper.queryList(map);
	}

}
