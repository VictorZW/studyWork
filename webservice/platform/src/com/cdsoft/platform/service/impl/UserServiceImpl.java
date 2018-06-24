package com.cdsoft.platform.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdsoft.platform.entity.Role;
import com.cdsoft.platform.entity.User;
import com.cdsoft.platform.mapper.UserMapper;
import com.cdsoft.platform.service.UserService;
import com.cdsoft.platform.util.DataGrid;
import com.cdsoft.platform.util.MD5Util;
@Service
@Transactional(rollbackFor={Exception.class,Error.class})
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	
	@Override
	public User selectUserByUserCode(String userCode) {
		return userMapper.selectUserByUserCode(userCode);
	}

	@Override
	public List<Role> selectRolesByUserCode(String userCode) {
		return userMapper.selectRolesByUserCode(userCode);
	}

	@Override
	public DataGrid queryUserInfo(Map<String, Object> param) {
		Long count = userMapper.queryPageCount(param);
		List<Map<String, Object>> list = userMapper.queryPage(param);
		DataGrid data = new DataGrid();
		data.setTotal(count);
		data.setRows(list);
		return data;
	}

	@Override
	public int delete(String ids) {
		List<String> list =new ArrayList<String>();
		if(ids!=null){
			String [] idstr= ids.split(",");
			for (int i = 0; i < idstr.length; i++) {
				list.add(i, idstr[i]);
			}
		}
		return userMapper.delete(list);
	}

	@Override
	public User check(String userCode) {
		// TODO Auto-generated method stub
		return userMapper.check(userCode);
	}

	@Override
	public int insert(Map<String, Object> param) {
		int count = userMapper.insert(param);
		if(count > 0){
			String orgCode = userMapper.getOrgCode(param);
			if(orgCode != "" && orgCode != null){
				param.put("orgCode", orgCode);
				count = userMapper.insertRelation(param);
			}			
		}
		return count;
	}

	@Override
	public int update(Map<String, Object> param) {
		int count = userMapper.update(param);
		if(count > 0){
			String orgCode = userMapper.getOrgCode(param);
			if(null!=orgCode && ""!= orgCode){
				param.put("orgCode", orgCode);
				count = userMapper.updateRelation(param);
			}
		}
		return count;
	}

	@Override
	public int resetPassWord(Map<String,Object> param) {
		// TODO Auto-generated method stub
		return userMapper.resetPassWord(param);
	}

	@Override
	public List<Map<String, Object>> queryStation(String orgCode) {
		// TODO Auto-generated method stub
		return userMapper.queryStation(orgCode);
	}

	@Override
	public int checks(String userCode) {
		// TODO Auto-generated method stub
		return userMapper.checks(userCode);
	}

	@Override
	public List<Map<String, Object>> queryStations() {
		// TODO Auto-generated method stub
		return userMapper.queryStations();
	}

	@Override
	public User selectUserInfo(String userName, String password) {
		return userMapper.selectUserInfo(userName, password);
	}

	@Override
	public List<com.cdsoft.platform.entity.Resource> selectResourceByUserCode(String userCode) {
		return userMapper.selectResourceByUserCode(userCode);
	}

	@Override
	public int selectUserIsAdminOrCompany(String userCode) {
		return userMapper.selectUserIsAdminOrCompany(userCode);
	}

	@Override
	public String selectUserNameByUserCode(String useCode) {
		return userMapper.selectUserNameByUserCode(useCode);
	}

	@Override
	public Map<String, Object> importExel(File source, String isRepeat) throws Exception{
		// 先上传exel 文件 然后再解析插入数据库并格式化数据
		FileInputStream fin = new FileInputStream(source);
		@SuppressWarnings("resource")
		HSSFWorkbook workbook = new HSSFWorkbook(fin);// 创建工作薄
		HSSFSheet sheet = workbook.getSheetAt(0);// 得到工作表
		HSSFRow row = null;// 对应excel的行
		HSSFCell cell = null;// 对应excel的列
		int totalRow = sheet.getLastRowNum();// 得到excel的总记录条数
		Map<String, Object> map = new HashMap<String,Object>();
		// 判断本次导入的模板是否已存在在数据库中，若存在则给出提示，若不存在则直接导入
		for (int i = 1; i <= totalRow; i++) {
			HSSFRow isRepeatRow = sheet.getRow(i);
			HSSFCell userCodeCell = isRepeatRow.getCell(0);
			String userCode = userCodeCell.getRichStringCellValue().toString();
			User user = selectUserByUserCode(userCode);
			if (user != null) {
				map.put("status", -1);
				map.put("message", "人员账号"+userCode+"已存在，请重新输入一个账号名称.");
				return map;
			}else
			{
				continue;
			}
		}

		for (int i = 1; i <= totalRow; i++) {
			Map<String,Object> user = new HashMap<String,Object>();
			row = sheet.getRow(i);
			cell = row.getCell(0);
			if (cell.getRichStringCellValue().toString() == null) {
				break;
			}
			if(cell!=null){
		          cell.setCellType(cell.CELL_TYPE_STRING);
		          user.put("userCode", cell.getRichStringCellValue().toString());
		          //user.put("userCode", cell.getRichStringCellValue().toString());
		     }
			cell = row.getCell(1);
			if(cell!=null){
		          cell.setCellType(cell.CELL_TYPE_STRING);
		          //user.put("userCode", cell.getRichStringCellValue().toString());
		          user.put("userName", cell.getRichStringCellValue().toString());
		    }
			//cell = row.getCell(2);
			//user.put("password", MD5Util.MD5(cell.getRichStringCellValue().toString()));
			if(row.getCell(2)!=null){
		          row.getCell(2).setCellType(cell.CELL_TYPE_STRING);
		          user.put("password", MD5Util.MD5(row.getCell(2).getRichStringCellValue().toString()));
		     }
			if(row.getCell(3)!=null){
		          row.getCell(3).setCellType(cell.CELL_TYPE_STRING);
		          user.put("jobNum", row.getCell(3).getRichStringCellValue().toString());
		     }
			if(row.getCell(4)!=null){
		          row.getCell(4).setCellType(cell.CELL_TYPE_STRING);
		          user.put("cellPhone", row.getCell(4).getRichStringCellValue().toString());
		     }
			//user.put("password", cell.getRichStringCellValue().toString());
			/*cell = row.getCell(3);
			user.put("jobNum", cell.getRichStringCellValue().toString());
			cell = row.getCell(4);
			user.put("cellPhone", cell.getRichStringCellValue().toString());*/
			cell = row.getCell(5);
			if(cell!=null){
		          cell.setCellType(cell.CELL_TYPE_STRING);
		          user.put("orgName", cell.getRichStringCellValue().toString());
		    }
			user.put("createUser", SecurityUtils.getSubject().getPrincipal().toString());
			insert(user);
		}
		map.put("status", 0);
		map.put("message", "导入成功");
		return map;
}

	@Override
	public List<User> list() {
		
		return userMapper.list();
	}

}
