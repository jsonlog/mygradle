package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Created by jsonlog on 18/8/2018.
 */

public class staticClass {
    /** 
    * 从字符串文本中获得数字  
    *@param text  
    *@return  
    */  
    public static List<Long> getDigit(String text) {  

        List<Long> digitList =new ArrayList<Long>();  
        Pattern p= Pattern.compile("(\\d+)");  
        Matcher m= p.matcher(text);  
        while (m.find()) {  
        String find= m.group(1).toString();  
        digitList.add(Long.valueOf(find));  
        }
        return digitList;  
    }
    // 判断一个字符串是否都为数字  
    public static boolean isDigit(String strNum) {  
        return strNum.matches("[0-9]{1,}");  
    }  
    
    // 判断一个字符串是否都为数字  
    public static boolean isAllDigit(String strNum) {  
        Pattern pattern = Pattern.compile("[0-9]{1,}");  
        Matcher matcher = pattern.matcher((CharSequence) strNum);  
        return matcher.matches();  
    }  
    
    //截取数字  
    public static String getNumbers(String content) {  
        Pattern pattern = Pattern.compile("\\d+");  
        Matcher matcher = pattern.matcher(content);  
        while (matcher.find()) {  
            return matcher.group(0);  
        }  
        return "";  
    }  
    
    // 截取非数字  
    public static String splitNotNumber(String content) {
        Pattern pattern = Pattern.compile("\\D+");  
        Matcher matcher = pattern.matcher(content);  
        while (matcher.find()) {  
            return matcher.group(0);  
        }  
        return "";  
    }  

    public static String format(long time){
        return format("yyyy-MM-dd HH:mm",time);
    }///
    public static String format(String format, long time) {
        String result = "";
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        try {
            Date date = new Date(time);
            SimpleDateFormat df1 = new SimpleDateFormat(format);
            result = df1.format(date);
        } catch (Exception e){
        }
        return result;
    }
    public static long format(String time) {
        long result = 0;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date date = df.parse(time);
            result = date.getTime();
        } catch (Exception e){
        }
        return result;
    }

    /**
     * 系统时间转换为年月日
     * @param timestamp
     * @return
     */

    public static String timestamp2y(long timestamp){
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        return format.format(timestamp*1000);
    }

    public static String timestamp2ymd(long timestamp){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(timestamp*1000);
    }

    public static String toymdhms(long timestamp){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(timestamp*1000);
    }

    /**
     * 将long类型的时间转为01:22:38形式
     * @param duration
     * @return
     */
    public static String formathour(long duration) {
        //定义常量
        long HOUR = 1000*60*60;//1小时
        long MINUTE = 1000*60;//1分钟
        long SECOND = 1000;//1秒钟

        //1.先计算小时
        long hour = duration / HOUR;//得到多少小时
        //再拿算完小时后的余数去算分钟
        long remain = duration % HOUR;
        //2.计算分钟
        long minute = remain / MINUTE;//得到了多少分钟
        remain = remain%MINUTE;
        //3.计算秒
        long second = remain / SECOND;

        if(hour==0){
            //说明不足一个小时，那么就不要显示小时了
            return String.format("%02d:%02d",minute,second);
        }else {
            return String.format("%02d:%02d:%02d",hour,minute,second);
        }
    }
    public static long getTime(){
        return new Date().getTime();
    }

    //ForestBlog 获得物理ip
	public static String getIpAddr(HttpServletRequest request){
		String ipAddress = request.getHeader("x-forwarded-for");
		if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			//这个地方会有5s延迟
//			if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){
//				//根据网卡取本机配置的IP
//				InetAddress inet=null;
//				try {
//					inet = InetAddress.getLocalHost();
//				} catch (UnknownHostException e) {
//					e.printStackTrace();
//				}
//				ipAddress= inet.getHostAddress();
//			}
		}
		//对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15
			if(ipAddress.indexOf(",")>0){
				ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}


	//将字符串转为MD5
	public static String strToMd5(String str) {
		String md5Str = null;
		if (str != null && str.length() != 0) {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(str.getBytes());
				byte b[] = md.digest();

				int i;
				StringBuffer buf = new StringBuffer("");
				for (int offset = 0; offset < b.length; offset++) {
					i = b[offset];
					if (i < 0)
						i += 256;
					if (i < 16)
						buf.append("0");
					buf.append(Integer.toHexString(i));
				}
				//32位
				md5Str = buf.toString();
				//16位
				//  md5Str = buf.toString().substring(8, 24);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		return md5Str;
	}

	//根据email获取gravatar头像
	public static String getGravatar(String email) {
		String emailMd5 = strToMd5(email);
		//设置图片大小32px
		String avatar = "http://cn.gravatar.com/avatar/"+emailMd5+"?s=128&d=identicon&r=PG";
		return avatar;
	}
    
}