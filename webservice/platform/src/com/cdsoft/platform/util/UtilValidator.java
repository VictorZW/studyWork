package com.cdsoft.platform.util;

import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * @SystemName 运行优化
 * @ModuleName 校验
 * @ClassName UtilValidator
 * @author DUXIAN
 * @Date 2014-3-26 下午2:55:40
 * @version V1.0
 * @Description 校验工具类
 */
public class UtilValidator {

	/**
	 * @Title isEmpty
	 * @Date 2014-9-3 上午11:42:55
	 * @author DUXIAN
	 * @Description 判断对象是否为空
	 * @param obj
	 * @return boolean 为空返回真，否则返回假
	 */
	public static boolean isEmpty(Object obj) {
		return obj == null ? true : false;
	}

	/**
	 * @Title isEmpty
	 * @Date 2014-3-27 下午2:55:35
	 * @author DUXIAN
	 * @Description 字符串是否为null或空
	 * @param str
	 * @return 为空返回真，否则返回假
	 */
	public static boolean isEmpty(String str) {
		return (str == null || str.trim().isEmpty()) ? true : false;
	}

	/**
	 * @Title isEmpty
	 * @Date 2014-3-27 下午2:55:57
	 * @author DUXIAN
	 * @Description 判断数组是否为空
	 * @param array
	 * @return 为空返回真，否则返回假
	 */
	public static boolean isEmpty(Object[] array) {
		return (array == null || array.length == 0) ? true : false;
	}

	/**
	 * @Title isEmpty
	 * @Date 2014-4-9 上午11:28:51
	 * @author DUXIAN
	 * @Description 判断list是否为空
	 * @param list
	 * @return 为空返回真，否则返回假
	 */
	public static boolean isEmpty(List<?> list) {
		return (list == null || list.isEmpty()) ? true : false;
	}

	/**
	 * @Title isEmpty
	 * @Date 2014-4-9 上午11:30:16
	 * @author DUXIAN
	 * @Description 判断map是否为空
	 * @param map
	 * @return 为空返回真，否则返回假
	 */
	public static boolean isEmpty(Map<?, ?> map) {
		return (map == null || map.isEmpty()) ? true : false;
	}

	/**
	 * @Title isEmpty
	 * @Date 2014-4-9 上午11:30:57
	 * @author DUXIAN
	 * @Description 判断参数是否是空或者NAN
	 * @param dvalue
	 * @return 为空返回真，否则返回假
	 */
	public static boolean isEmpty(Double dvalue) {
		return (dvalue == null || dvalue.isNaN() || dvalue.isInfinite()) ? true : false;
	}

	/**
	 * @Title isEmpty
	 * @Date 2014-7-4 上午11:02:33
	 * @author DUXIAN
	 * @Description 判断参数是否是空或者NAN
	 * @param bvalue
	 * @return 为空返回真，否则返回假
	 */
	public static boolean isEmpty(BigDecimal bvalue) {
		return (bvalue == null || UtilValidator.isEmpty(bvalue.doubleValue())) ? true : false;
	}

	/**
	 * @Title isExistFileInClassPath
	 * @Date 2014-4-9 上午11:31:17
	 * @author DUXIAN
	 * @Description 判断ClassPath中是否存在该文件
	 * @param fileName
	 * @return 为空返回真，否则返回假
	 */
	public static boolean isExistFileInClassPath(String fileName) {
		URL uri = UtilValidator.class.getClassLoader().getResource(fileName);
		return uri == null ? false : true;
	}

}
