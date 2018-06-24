package com.cdsoft.platform.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.cdsoft.platform.entity.Dict;

@Repository
public interface DictMapper {
	
	List<Map<String, Object>> queryPage(Map<String, Object> param);
	
	Long queryPageCount(Map<String, Object> param);
	
	List<Map<String,Object>>queryDictType();
	
	Dict selNewType(Map<String, Object> param);
	
	int addDict(Map<String, Object> param);
	
	int updateDictByNo(Map<String, Object> param);
	
	int updateDict(Map<String, Object> param);
	
	int deleteRow(Map<String, Object> param);
	
	int deleteDictType(Map<String, Object> param);
	
	int check1(@Param("dictType")String dictType);
	
	int check2(@Param("no")String no,@Param("dictName")String dictName,@Param("parentNo")String parentNo);

	List<Map<String, Object>> list(Map<String, Object> param);
	
	String queryNoByValue(Map<String, Object> param);

	List<Map<String, Object>> queryByType(String type);
	List<Dict> selDictTree();

	List<Dict> queryType();
}
