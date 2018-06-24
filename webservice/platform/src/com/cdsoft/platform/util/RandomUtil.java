package com.cdsoft.platform.util;

import java.util.UUID;

public class RandomUtil {

	public  static  String UUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
