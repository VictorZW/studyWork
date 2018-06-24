package com.cdsoft.platform.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.cdsoft.platform.entity.Resource;

@Repository(value="resourceMapper")
public interface ResourceMapper {

	/**
	 * 查询所有的menu信息
	 * @return
	 */
	public List<Map<String, Object>> findFrontList(@Param("usercode")String usercode);
	
	//查询所有资源
	List<Resource> selectResource();
	
	//根据主键id删除resource
	int deleteByPrimaryKey(String id);

	//添加resource
    int insert(Resource record);

    //条件添加
    int insertSelective(Resource record);

    //根据主键查询资源
    Resource selectByPrimaryKey(String id);

    //根据主键条件修改资源
    int updateByPrimaryKeySelective(Resource record);

    //根据主键修改资源
    int updateByPrimaryKey(Resource record);

    //查询资源名是否重复
	public int checkName(String name);

	//查询总条数
	public Long queryPageCount(Map<String, Object> param);

	//查询结果集
	//public List<Map<String, Object>> queryPage(Map<String, Object> param);
	public List<Resource> queryPage(Map<String, Object> param);

	//删除
	public int delete(List<String> list);
}
