package com.cdsoft.platform.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.cdsoft.platform.entity.Menu;

@Repository
public interface MenusMapper {
	
	List<Menu> selMenuTree(); 
	
	int updateMenuTreeChild(Map<String,Object> param);
	
	int insertParent(Map<String,Object> param);
	
	Menu selNewParent(Map<String,Object> param);
	
	int insertChild(Map<String,Object> param);
	
	int deleteMenuParent(Map<String,Object> param);
	
	int deleteMenuChild(Map<String,Object> param);
	
	int selectMenuChild(Map<String,Object> param);

	List<Menu> selMenu();
	List<Menu> selectMenu();
	
	List<Menu> selectMenuCode(@Param("name")String name);
	
}
