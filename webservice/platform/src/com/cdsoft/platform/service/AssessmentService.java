package com.cdsoft.platform.service;

import java.util.List;
import java.util.Map;

public interface AssessmentService {

	List<Map<String,Object>> selectWorkPackge(String wpid,String wtid,String taskName,String modiId,String applyUser,String  approveUser,String status,int page,int rows,String sort,String order,String sqlCode);

	int countWorkPackge(String wpid,String wtid,String taskName,String modiId,String applyUser,String  approveUser,String status,String sqlCode);

	int updateWordPackgeWithAssess(String wpid);
	
	List<Map<String,Object>> selectWorkTikect(Map<String,Object> params);
	
	int countWorkTikect(Map<String,Object> params);
	
	int updateWordTikectWithAssess(String wtid);
	
	List<Map<String,Object>> selectOperateTicket(String otid,String wtid,String taskName,String applyUser,String  otUsers,String status,int page,int rows,String sort,String order,String sqlCode);

	int countOperateTicket(String otid,String wtid,String taskName,String applyUser,String  otUsers,String status,String sqlCode);

	int updateOperateTicketWithAssess(String otid);
	
	String selectOtidByWtid(String wtid);
}
