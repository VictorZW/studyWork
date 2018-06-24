package com.cdsoft.platform.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cdsoft.platform.entity.RoleResource;
@Repository
public interface RoleResourceMapper  {

    int insert(RoleResource record);

    int insertSelective(RoleResource record);

    int delete(String rolecode);
    
    List<Map<String,Object>> selectResCode(String rolecode);
}