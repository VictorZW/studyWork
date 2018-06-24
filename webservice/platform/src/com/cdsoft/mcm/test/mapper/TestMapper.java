package com.cdsoft.mcm.test.mapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface TestMapper {
	
	List<HashMap> queryList(HashMap map); 

}
