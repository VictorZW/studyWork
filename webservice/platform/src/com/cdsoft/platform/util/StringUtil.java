package com.cdsoft.platform.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/* 
 * 所属模块: 工具包 
 * 说明：常用字符串及数组操作 
 */
public class StringUtil { 
	
	private final static String dateFormat = "yyyy-MM-dd HH:mm:ss";

	 /** 
     * 格式化小数保持最少和最多小数点.
     * 
     *  @param  num
     *  @param  minFractionDigits
     *  @param  maxFractionDigits
     *  @return 
      */ 
     public   static  String formatFraction( double  num,  int  minFractionDigits,  int  maxFractionDigits) {
         //  输出固定小数点位数 
        java.text.NumberFormat nb  =  java.text.NumberFormat.getInstance();
        nb.setMaximumFractionDigits(maxFractionDigits);
        nb.setMinimumFractionDigits(minFractionDigits);
        nb.setGroupingUsed( false );
        String rate  =  nb.format(num);
         return  rate;
    }
     
     /**
     * 得到当前日期前后的日期
     * @return 返回日期字符串
     */
     public static String getBefDateString(int day_i){
	     Calendar day=Calendar.getInstance();
	     day.add(Calendar.DATE,day_i);
	     return new SimpleDateFormat(dateFormat).format(day.getTime());
     }
     
     /**
      * 获取当前日期的字符串长度
      * @return
      */
     public static int getDateTimeLen(){
    	 return dateFormat.length();
     }
    
     /**
      * 获取当前日期
      * @return
      */
     public static String getDateTime(){
    	 return new   SimpleDateFormat(dateFormat).format(Calendar.getInstance().getTime());
     }

     /**
      * 获取当前日期
      * @return
      */
     public static String getDate(){
    	 return new   SimpleDateFormat( "yyyy-MM-dd").format(Calendar.getInstance().getTime());
     }
     
     /**
      * 获取当前时间
      * @return
      */
     public static String getTime(){
    	 return new   SimpleDateFormat( "HH:mm:ss").format(Calendar.getInstance().getTime());
     }
     
     /**
      * 字符串转换为毫秒
      * @return
      */
     public static long parseLongDate(String str){
    		 try {
				return new SimpleDateFormat(dateFormat).parse(str).getTime();
			} catch (ParseException e) {
				return 0;
			}
     }
     /**
 	 * 将当前毫秒数转为php的11位字串
 	 * @return
 	 */
 	public static String time(){
 		long time = System.currentTimeMillis();
 		String t = String.valueOf(time);
 		return t.substring(0, 10);
 	}
     /**
      * 计算两个字符串转换为日期后相减得到的分钟
      * @param str1
      * @param str2
      * @return
      */
     public static int getSubTime(String str1,String str2){
    	 return (int)(parseLongDate(str2) - parseLongDate(str1))/(1000*60);
     }

     /** 
     * Change the null string value to "", if not null, then return it self, use
     * this to avoid display a null string to "null".
     *
     *  @param  input
     *            the string to clear
     *  @return  the result
      */ 
     public   static  String clearNull(String input) {
         return  isEmpty(input)  ?   ""  : input;
    }

     /** 
     * 转换由表单读取的数据的内码(从 ISO8859 转换到 gb2312).
     *
     *  @param  input
     *            输入的字符串
     *  @return  转换结果, 如果有错误发生, 则返回原来的值
      */ 
     public   static  String toChi(String input) {
         try  {
             byte [] bytes  =  input.getBytes( " ISO8859-1 " );
             return   new  String(bytes,  " GBK " );
        }  catch  (Exception ex) {
        }
         return  input;
    }

     /** 
     * 转换由表单读取的数据的内码到 ISO(从 GBK 转换到ISO8859-1).
     *
     *  @param  input
     *            输入的字符串
     *  @return  转换结果, 如果有错误发生, 则返回原来的值
      */ 
     public   static  String toISO(String input) {
         return  changeEncoding(input,  " GBK " ,  " ISO8859-1 " );
    }

     /** 
     * 转换字符串的内码.
     *
     *  @param  input
     *            输入的字符串
     *  @param  sourceEncoding
     *            源字符集名称
     *  @param  targetEncoding
     *            目标字符集名称
     *  @return  转换结果, 如果有错误发生, 则返回原来的值
      */ 
     public   static  String changeEncoding(String input, String sourceEncoding,
            String targetEncoding) {
         if  (input  ==   null   ||  input.equals( "" )) {
             return  input;
        }

         try  {
             byte [] bytes  =  input.getBytes(sourceEncoding);
             return   new  String(bytes, targetEncoding);
        }  catch  (Exception ex) {
        }
         return  input;
    }


     /** 
     * 对给定字符进行 URL 编码
      */ 
     public   static  String encode(String value) {
         if  (isEmpty(value)) {
             return   "" ;
        }

         try  {
            value  =  java.net.URLEncoder.encode(value,  " GB2312 " );
        }  catch  (Exception ex) {
            ex.printStackTrace();
        }

         return  value;
    }

     /** 
     * 对给定字符进行 URL 解码
     *
     *  @param  value
     *            解码前的字符串
     *  @return  解码后的字符串
      */ 
     public   static  String decode(String value) {
         if  (isEmpty(value)) {
             return   "" ;
        }

         try  {
             return  java.net.URLDecoder.decode(value,  " GB2312 " );
        }  catch  (Exception ex) {
            ex.printStackTrace();
        }

         return  value;
    }
     
     /** 
      * 判断list是否未空, 如果不为 null 或者长度大于0, 均返回 true.
       */ 
      public   static   boolean  isNotEmptyList(List<?> input) {
          return  (input  !=   null   &&  input.size()  >   0 );
     }
     
     /** 
      * 判断字符串数组是否未空, 如果不为 null 或者长度大于0, 均返回 .
       */ 
      public   static   boolean  isNotEmptyArray(String[] input) {
          return  (input  !=   null   &&  input.length  >   0 );
     }
     /**
      * 判断map是否为空，如果不为null 或者长度大于0，均返回true
      */
      public static boolean isNotEmptyMap(Map<?,?> input){
    	  return (input != null && input.size() > 0);
      }
     /** 
     * 判断字符串是否未空, 如果为 null 或者长度为0, 均返回 true.
      */ 
     public   static   boolean  isEmpty(String input) {
         return  (input  ==   null   ||  input.length()  ==   0 );
    }
     
     /** 
      * 判断字符串是否未空, 如果为 null 或者长度为0, 均返回 true.
       */ 
      public   static   boolean  isNotEmpty(String input) {
          return  !isEmpty(input);
     }
      
      /**
       * 将字符串转换为整型数字
       * @param str
       * @return
       */
      public static int parseInt(String str){
    	  if(isNotEmpty(str)){
    		  return Integer.parseInt(str);
    	  }else{
    		  return 0;
    	  }
      }
      
  	/**
  	 * 调用该方法不抛错
  	 */
  	public static Integer parseInteger(Object obj){
  		if(obj == null)
  			return 0;
  		if(obj instanceof Integer)
  			return (Integer)obj;
  		Integer ret = 0;
  		try{
  			ret = Integer.valueOf(obj.toString());
  		}catch (Exception e) {
  		}
  		return ret;
  	}
  	
     
     /** 
     * 获得输入字符串的字节长度(即二进制字节数), 用于发送短信时判断是否超出长度.
     *
     *  @param  input
     *            输入字符串
     *  @return  字符串的字节长度(不是 Unicode 长度)
      */ 
     public   static   int  getBytesLength(String input) {
         if  (input  ==   null ) {
             return   0 ;
        }
         int  bytesLength  =  input.getBytes().length;
         return  bytesLength;
    }
 	/**
 	 * 取得取得今天0时0分0秒距历元（格林威治标准时间 1970年1月1日 0:00:00）的秒数
 	 * @return
 	 */
     public static long getTodayStartTime(){
 		Calendar cc = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
         cc.set(Calendar.HOUR_OF_DAY, 0); 
         cc.set(Calendar.MINUTE, 0);
         cc.set(Calendar.SECOND, 0);
         cc.set(Calendar.MILLISECOND, 0);
         long t = cc.getTimeInMillis();
         t = t/1000;//去除毫秒
         return t;
 	}

     /** 
     * 删除指定的 Web 应用程序目录下所上传的文件
     *
     *  @param  application
     *            JSP/Servlet 的 ServletContext
     *  @param  filePath
     *            相对文件路径
      */ 
     public   static   void  deleteFile(ServletContext application, String filePath) {
         if  ( ! isEmpty(filePath)) {
            String physicalFilePath  =  application.getRealPath(filePath);
             if  ( ! isEmpty(physicalFilePath)) {
                java.io.File file  =   new  java.io.File(physicalFilePath);
                file.delete();
            }
        }
    }

     /** 
     * 在指定的 Web 应用程序目录下以指定路径创建文件
     *
     *  @param  application
     *            JSP/Servlet 的 ServletContext
     *  @param  filePath
     *            相对文件路径
      */ 
     public   static   boolean  createFile(ServletContext application, String filePath) {
         if  ( ! isEmpty(filePath)) {
            String physicalFilePath  =  application.getRealPath(filePath);
             if  ( ! isEmpty(physicalFilePath)) {
                java.io.File file  =   new  java.io.File(physicalFilePath);

                 try  {
                     //  创建文件 
                     return  file.createNewFile();
                }  catch  (IOException e) {
                    System.err.println( " Unable to create file  "   +  filePath);
                }
            }
        }

         return   false ;
    }

     /** 
     * 在指定的 Web 应用程序目录下以指定路径创建目录.
     *
     *  @param  application
     *            JSP/Servlet 的 ServletContext
     *  @param  filePath
     *            相对文件路径
      */ 
     public   static   boolean  createDir(ServletContext application, String filePath) {
         if  ( ! isEmpty(filePath)) {
            String physicalFilePath  =  application.getRealPath(filePath);
             if  ( ! isEmpty(physicalFilePath)) {
                 try  {
                     //  创建目录 
                    java.io.File dir  =   new  java.io.File(application
                            .getRealPath(filePath));
                     return  dir.mkdirs();
                }  catch  (Exception e) {
                    System.err
                            .println( " Unable to create directory  "   +  filePath);
                }
            }
        }

         return   false ;
    }

     /** 
     * 检查指定的 Web 应用程序目录下的文件是否存在.
     *
     *  @param  application
     *            JSP/Servlet 的 ServletContext
     *  @param  filePath
     *            相对文件路径
     *  @return  boolean - 文件是否存在
      */ 
     public   static   boolean  checkFileExists(ServletContext application,
            String filePath) {
         if  ( ! isEmpty(filePath)) {
            String physicalFilePath  =  application.getRealPath(filePath);
             if  ( ! isEmpty(physicalFilePath)) {
                java.io.File file  =   new  java.io.File(physicalFilePath);
                 return  file.exists();
            }
        }

         return   false ;
    }

     /** 
     * 将日期转换为中文表示方式的字符串(格式为 yyyy年MM月dd日 HH:mm:ss).
      */ 
     public   static  String dateToChineseString(Date date) {
         if  (date  ==   null ) {
             return   "" ;
        }

        java.text.SimpleDateFormat dateFormat  =   new  java.text.SimpleDateFormat(
                 " yyyy年MM月dd日 HH:mm:ss " );

         return  dateFormat.format(date);
    }

     /** 
     * 将日期转换为 14 位的字符串(格式为yyyyMMddHHmmss).
      */ 
     public   static  String dateTo14String(Date date) {
         if  (date  ==   null ) {
             return   null ;
        }

        java.text.SimpleDateFormat dateFormat  =   new  java.text.SimpleDateFormat(
                 " yyyyMMddHHmmss " );

         return  dateFormat.format(date);
    }

     /** 
     * 将 14 位的字符串(格式为yyyyMMddHHmmss)转换为日期.
      */ 
     public   static  Date string14ToDate(String input) {
         if  (isEmpty(input)) {
             return   null ;
        }

         if  (input.length()  !=   14 ) {
             return   null ;
        }

        java.text.SimpleDateFormat dateFormat  =   new  java.text.SimpleDateFormat(
                 " yyyyMMddHHmmss " );

         try  {
             return  dateFormat.parse(input);
        }  catch  (Exception ex) {
            ex.printStackTrace();
        }

         return   null ;
    }
    
     /** 
     * 获取 boolean 参数从ServletRequest中.
     *  @param  request
     *  @param  name
     *  @return 
      */ 
     public   static   boolean  getBoolean(HttpServletRequest request, String name) {
         return  Boolean.valueOf(request.getParameter(name));
    }

     public   static  String replaceChar(String s,  char  c,  char  c1) {
         if  (s  ==   null ) {
             return   "" ;
        }
         return  s.replace(c, c1);
    }

     public   static  String replaceString(String s, String s1, String s2) {
         if  (s  ==   null   ||  s1  ==   null   ||  s2  ==   null ) {
             return   "" ;
        }
         return  s.replaceAll(s1, s2);
    }

     public   static  String toHtml(String s) {
        s  =  replaceString(s,  " < " ,  " &#60; " );
        s  =  replaceString(s,  " > " ,  " &#62; " );
         return  s;
    }

     public   static  String toBR(String s) {
        s  =  replaceString(s,  " \n " ,  " <br>\n " );
        s  =  replaceString(s,  " \t " ,  " &nbsp;&nbsp;&nbsp;&nbsp; " );
        s  =  replaceString(s,  "    " ,  " &nbsp;&nbsp; " );
         return  s;
    }

     public   static  String toSQL(String s) {
        s  =  replaceString(s,  " \r\n " ,  " \n " );
         return  s;
    }

     public   static  String replaceEnter(String s)  throws  NullPointerException {
         return  s.replaceAll( " \n " ,  " <br> " );
    }

     public   static  String replacebr(String s)  throws  NullPointerException {
         return  s.replaceAll( " <br> " ,  " \n " );
    }

     public   static  String replaceQuote(String s)  throws  NullPointerException {
         return  s.replaceAll( " ' " ,  " '' " );
    }
     
     public static String getDayDate(Date date){
 		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
 		return sdf.format(date);
 	}
 	public static String getDay(Date date){
 		SimpleDateFormat sdf = new SimpleDateFormat("dd");
 		return sdf.format(date);
 	}
 	public static String getMonth(Date date){
 		SimpleDateFormat sdf = new SimpleDateFormat("MM");
 		return sdf.format(date);
 	}
 	public static String getYear(Date date){
 		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
 		return sdf.format(date);
 	}
 	public static String getHour(Date date){
 		SimpleDateFormat sdf = new SimpleDateFormat("HH");
 		return sdf.format(date);
 	}
 	public static String getMinute(Date date){
 		SimpleDateFormat sdf = new SimpleDateFormat("mm");
 		return sdf.format(date);
 	}
 	public static String getSecond(Date date){
 		SimpleDateFormat sdf = new SimpleDateFormat("ss");
 		return sdf.format(date);
 	}
 	
	/**
	 * 判断是否为纯数字
	 * @param str
	 * @return boolean
	 */
	public static boolean isNumeric(String value){
		if(value == null || "".equals(value)){
			return false;
		}
		return value.matches("^[0-9]+$");
	}
	/**
	 * 判断字符串是否为汉字
	 * @param str
	 * @return boolean
	 */
	 public static final boolean isChinese(String strName) {  
	        char[] ch = strName.toCharArray();  
	        for (int i = 0; i < ch.length; i++) {  
	            char c = ch[i];  
	            if (isChinese(c)) {  
	                return true;  
	            }  
	        }  
	        return false;  
	    } 
	  private static final boolean isChinese(char c) {  
	        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);  
	        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS  
	                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS  
	                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A  
	                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION  
	                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION  
	                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {  
	            return true;  
	        }  
	        return false;  
	    }
	  
	/**
	 * 解析文件大小字符串,将文件大小字符串中的K(千字节)、M(兆字节)、G转化成相应整数
	 * 
	 * @param sizeString
	 *            文件大小字符串
	 * @param defaultSize
	 *            默认
	 * @return
	 */
	public static long convertSizeToBytes(String sizeString, long defaultSize) {
		if(sizeString == null || "".equals(sizeString))return defaultSize;
		int multiplier = 1;
		if (sizeString.endsWith("K")) {
			multiplier = 1024;
		} else if (sizeString.endsWith("M")) {
			multiplier = 1024 * 1024;
		} else if (sizeString.endsWith("G")) {
			multiplier = 1024 * 1024 * 1024;
		}else if (sizeString.endsWith("T")) {
			multiplier = 1024 * 1024 * 1024* 1024;
		}
		if (multiplier != 1) {
			sizeString = sizeString.substring(0, sizeString.length() - 1);
		}

		long size = 0;
		try {
			size = Long.parseLong(sizeString);
		} catch (NumberFormatException nfe) {
			throw new RuntimeException(nfe);
		}

		return (size * multiplier);
	}
	/**
	 * 规范化路径，所有的路径风格符都使用"/"
	 * @param name
	 * @return
	 */
	public static String normalizePathName(String name) {
        if (name == null) {
            return null;
        }
        return name.trim().replaceAll("[/\\\\]+", "/");
    }
	 
	public static String formatDateBySeconds(String seconds,String formatStr) {
		if(formatStr == null || formatStr.isEmpty()) formatStr = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat dateFormatter = new SimpleDateFormat(formatStr);
		return dateFormatter.format(new Date(Long.valueOf(seconds+"000")));
	}

	public static String getRandomString(int length) { // length表示生成字符串的长度
		String base = "abcdefghijklmnopqrstuvwxyzQAZWSXEDCRFVTGBYHNUJMIKLOP0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	public static String valueOf(Object obj) {
        return (obj == null) ? "" : obj.toString();
    }
	/**
	 * 友好的时间显示
	 *
	 * @param int    $sTime 待显示的时间
	 * @param string $type  类型. normal | mohu | full | ymd | other
	 * @param string $alt   已失效
	 * @return string
	 */
	/*public static String friendlyDate(long sTime,String type) {
		//sTime=源时间，cTime=当前时间，dTime=时间差
		long cTime = System.currentTimeMillis();
		long dTime = cTime - sTime;
		
		Calendar cd = Calendar.getInstance();  
		cd.setTimeInMillis(cTime);
		int curDay = cd.get(Calendar.DAY_OF_YEAR);
		int curYear = cd.get(Calendar.YEAR);
		cd.setTimeInMillis(sTime);
		int Year = cd.get(Calendar.YEAR);
		int Day =  cd.get(Calendar.DAY_OF_YEAR);
		
		int dDay =	curDay - Day;
		int dYear =	curYear -Year;
		//normal：n秒前，n分钟前，n小时前，日期
		if("normal".equals(type)){
			if(dTime <= 10){
				return "刚刚";
			}else if(dTime <= 60){
				return dTime + "秒前";
			}else if(dTime <= 3600){
				return dTime/60 + "分钟前";
			}else if(dYear == 0 && dDay == 0){
				return "今天"+ formatDateBySeconds(Long.toString(sTime), "HH:mm");
			}else if(dYear == 0){
				return formatDateBySeconds(Long.toString(sTime), "m月d日 HH:mm");
			}else {
				return formatDateBySeconds(Long.toString(sTime), "yyyy-MM-dd HH:mm");
			}
		}else if("mohu".equals(type)){
			if(dTime <= 60){
				return dTime + "秒前";
			}else if(dTime <= 3600){
				return dTime/60 + "分钟前";
			}else if( dTime >= 3600 && dDay == 0 ){
				return  dTime/3600 + "小时前";
			}else if(dDay > 0 && dDay<=7 ){
				return dDay+"天前";
			}else if(dDay > 30){
				return dDay/30+"月前";
			}
		}else if(type.equals("full")){
			return formatDateBySeconds(Long.toString(sTime), "Y-m-d H:i:s");
		}else if(type.equals("ymd")){
			return formatDateBySeconds(Long.toString(sTime), "Y-m-d");
		}else {
			if(dTime < 60){
				return dTime + "秒前";
			}else if(dTime <= 3600){
				return dTime/60 + "分钟前";
			}else if( dTime >= 3600 && dDay == 0 ){
				return  dTime/3600 + "小时前";
			}else{
				return formatDateBySeconds(Long.toString(sTime), "Y-m-d H:i:s");
			}
		}
		return formatDateBySeconds(Long.toString(sTime), "Y-m-d H:i:s");
	}*/
	public static void main(String[] args) {
//		String time = (System.currentTimeMillis()+"").substring(0,10);
//		long time = System.currentTimeMillis();
		//System.out.println(StringUtil.friendlyDate(time, "normal"));
	}
}
