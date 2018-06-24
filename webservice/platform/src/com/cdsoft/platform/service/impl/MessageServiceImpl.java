package com.cdsoft.platform.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cdsoft.platform.entity.Message;
import com.cdsoft.platform.mapper.MessageMapper;
import com.cdsoft.platform.service.MessageService;
import com.cdsoft.platform.util.DataGrid;

@Service
public class MessageServiceImpl implements MessageService {

	@Resource
	private MessageMapper messageMapper;
	
	@Override
	public DataGrid queryPage(Map<String, Object> param){
		Long count = messageMapper.queryMessageCount(param);
		List<Map<String, Object>> list = messageMapper.queryMessage(param);
		DataGrid data = new DataGrid();
		data.setTotal(count);
		data.setRows(list);
		return data;
	}

	@Override
	public int addMessage(Map<String, Object> param) {
		int count = messageMapper.addMessage(param);
		return count;
	}

	@Override
	public int insert(Message message) {
		int count=messageMapper.insert(message);
		return count;
	}

	@Override
	public int update(Message message) {
		int count=messageMapper.update(message);
		return count;
	}

	@Override
	public int delete(String ids) {
		List<String> list = new ArrayList<String>();
		if (ids != null) {
			String[] idstr = ids.split(",");
			for (int i = 0; i < idstr.length; i++) {
				list.add(i, idstr[i]);
			}
		}
		int count= messageMapper.delete(list);
		return count;
	}

}
