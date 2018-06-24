package com.cdsoft.platform.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cdsoft.platform.entity.Message;


@Repository
public interface MessageMapper {
	
	List<Map<String,Object>> queryMessage(Map<String,Object> param);
	
	long queryMessageCount(Map<String,Object> param);
	
	int addMessage(Map<String,Object> param);

	int insert(Message message);

	int update(Message message);

	int delete(List<String> list);
}
