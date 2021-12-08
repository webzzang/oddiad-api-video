package com.exflyer.oddi.app.api.util;

import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class StringUtil {


    /**
     * 초기 스트링 셋팅 값 설정
     * @param str       비교값
     * @param value     기본값
     * @return
     */
    public static String defaultValue(String str, String value) {
    	String rtnStr = str;
        if (rtnStr == null || "".equals(rtnStr) || "null".equals(rtnStr)) {    
        	rtnStr = value;
        }
        return rtnStr;
    }
    
    /**
     * 초기 스트링 셋팅 값 설정 ("")
     * @param str       비교값
     * @param value     기본값
     * @return
     */
    public static String defaultValue(String str) {
    	String rtnStr = str;
        if (rtnStr == null || "".equals(rtnStr) || "null".equals(rtnStr)) {
        	rtnStr = "";
        }
        return rtnStr;
    }
  
    /**
     * 핸드폰번호 포멧으로 반환함
     * @param number
     * @return xxx-xxx-xxx, xxx-xxxx-xxxx
     */
    public static String getHpNumber(String number){
    	String regExp = "(\\d{3})(\\d{3,4})(\\d{4})";
        return number.replaceAll("[^0-9]","").replaceAll(regExp, "$1-$2-$3");
    }
    
    /**
     * 핸드폰번호 체크
     * @param number
     * @return boolean
     */
    public static boolean getHpNumberChk(String number){
    	String regExp = "^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$";
        return number.matches(regExp);
    }
    
    /**
     * 날짜를 -,. 로 포멧 변경
     * @param String
     * @return xxxx-xx-xx, xxxx.xx.xx
     * getDateFormat("2020-10-10",".")
     */
    public static String getDateFormat(String str, String type ){
    	String regExp = "(\\d{4})(\\d{2})(\\d{2})";
        return str.replaceAll("[^0-9]","").replaceAll(regExp, "$1" + type +  "$2" + type + "$3");
    }
    
    /**
     * 시분초 포멧 변경
     * @param String
     * @return 00:00:00
     * getDateTimeFormat("000000")
     */
    public static String getDateTimeFormat(String str){
    	String regExp = "(\\d{2})(\\d{2})(\\d{2})";
        return str.replaceAll("[^0-9]","").replaceAll(regExp, "$1" + ":" +  "$2" + ":" + "$3");
    }
    
    /**
     * 휴대폰 번호 마스킹
     * @param String
     * @return 010-****-1234 
     */
    public static String getMaskedPhoneNum(String phoneNum) {
    	String rtnStr = getHpNumber(phoneNum);
        //String regex = "(\\d{2,3})(\\d{3,4})(\\d{4})$";
        String regex = "(\\d{2,3})-?(\\d{3,4})-?(\\d{4})$";		//휴대폰번호 '-' 포함
        Matcher matcher = Pattern.compile(regex).matcher(rtnStr);
        if (matcher.find()) {
            String replaceTarget = matcher.group(2);
            char[] c = new char[replaceTarget.length()];
            Arrays.fill(c, '*');

            return rtnStr.replace(replaceTarget, String.valueOf(c));
        }
        
        return rtnStr;
    }
    
    /**
     * 휴대폰 번호 마스킹
     * @param String
     * @return @return 010-1***-*234 
     */
    public static String getMaskedPhoneNum2(String phoneNum) {
    	String[] hp = getHpNumber(phoneNum).split("-");
		
		String num1 = hp[0];
		String num2 = hp[1];
		String num3 = hp[2];
		
		if(hp[1].length() == 3) {
			StringBuilder builder = new StringBuilder(num2);
			builder.setCharAt(1, '*');
			builder.setCharAt(2, '*');
			num2 = builder.toString();
		}else if(hp[1].length() == 4) {
			StringBuilder builder = new StringBuilder(num2);
			builder.setCharAt(1, '*');
			builder.setCharAt(2, '*');
			builder.setCharAt(3, '*');
			num2 = builder.toString();
		}
		
		StringBuilder builder = new StringBuilder(num3);
		builder.setCharAt(0, '*');
		num3 = builder.toString();
        
        return num1 + "-" + num2 + "-" + num3;
    }

    /**
     * 이름 마스킹
     * @param String
     * @return 
     */
    public static String getMaskedName(String name) {
        String maskedName = "";     // 마스킹 이름
        String firstName = "";      // 성
        String middleName = "";     // 이름 중간
        String lastName = "";       //이름 끝
        int lastNameStartPoint;     // 이름 시작 포인터
        
        if(!name.equals("") || name != null){
            if(name.length() > 1){
                firstName = name.substring(0, 1);
                lastNameStartPoint = name.indexOf(firstName);
                
                if(name.trim().length() > 2){
                    middleName = name.substring(lastNameStartPoint + 1, name.trim().length()-1);
                    lastName = name.substring(lastNameStartPoint + (name.trim().length() - 1), name.trim().length());
                }else{
                    middleName = name.substring(lastNameStartPoint + 1, name.trim().length());
                }
                
                StringBuffer makers = new StringBuffer();
                for(int i = 0; i < middleName.length(); i++){
                    makers.append("*");
                }
                
                lastName = middleName.replace(middleName, makers) + lastName;
                maskedName = firstName + lastName;
            }else{
                maskedName = name;
            }
        }
        
        return maskedName;
    }
    
    /**
     * 도메인 IP 추출
     * @param String
     * @return 
     */
    public static String extractUrlParts(String url, int pos) {
    	
    	String str="";
    	Pattern urlPattern = Pattern.compile("^(https?):\\/\\/([^:\\/\\s]+)(:([^\\/]*))?((\\/[^\\s/\\/]+)*)?\\/([^#\\s\\?]*)(\\?([^#\\s]*))?(#(\\w*))?$");
    	Matcher mc = urlPattern.matcher(url);
    	if(mc.matches()){
    		str = mc.group(pos);
    	}
    	return str;
    }
    
    
    /**
     * 난수 발생 (숫자,영문)
     * @param String
     * @param int
     * @return String
     */
    public static String RandomGen(String type, int length) {
    	String ENGLISH_LOWER = "abcdefghijklmnopqrstuvwxyz";
        String ENGLISH_UPPER = ENGLISH_LOWER.toUpperCase();
        String NUMBER = "0123456789";
        int len = length;
    	String DATA = "";
    	if(len < 1) { len = 4; }
    	
    	switch (type) {
			case "1":  DATA = ENGLISH_LOWER; break;	//소문자
			case "2":  DATA = ENGLISH_LOWER + ENGLISH_UPPER; break; //대소문자
			case "3":  DATA = ENGLISH_LOWER + NUMBER; break; //소문자+숫자
			case "4":  DATA = ENGLISH_LOWER + ENGLISH_UPPER + NUMBER; break; //대소문자+숫자
			case "5":  DATA = NUMBER; break; //숫자
			default: DATA = NUMBER; break;
		}
    	
    	SecureRandom random = new SecureRandom();
    	random.setSeed(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append( DATA.charAt(random.nextInt(DATA.length())));
        }
        return sb.toString();
    }
    
    /**
     * 날짜
     * @param String
     * @return String
     */
    public static String getToDay(String format) {
    	String rtnStr = format;
    	if(rtnStr == null || rtnStr.equals("")) {
    		rtnStr = "yyyyMMdd";
    	}
    	Date d = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat(rtnStr);
    	return sdf.format(d);
    }
    
    /**
     * 날짜
     * @param String
     * @param addDay
     * @return String
     * @throws ParseException 
     */
    public static String getToAddDay(String format, String addDay) throws ParseException {
    	String rtnStr = format;
    	if(rtnStr == null || rtnStr.equals("")) {
    		rtnStr = "yyyyMMdd";
    	}
    	
    	Calendar cal = Calendar.getInstance();
    	
    	cal.add(cal.DATE, Integer.parseInt(addDay) );
    	String thisDay = cal.get(cal.YEAR) + "-"+ (cal.get(cal.MONTH)+1) +"-"+ cal.get(cal.DATE) +"";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(thisDay);
		
    	return new java.text.SimpleDateFormat("yyyyMMdd").format(date);
    }
    
    /**
     * 숫자 컴마
     * @param String
     * @return String
     */
    public static String getComma(String amount) {
    	
    	String rtnStr = amount;
    	
    	if(rtnStr == null){
    		return rtnStr;
    	}else if(rtnStr.equals("")) {
    		return rtnStr;
    	}
    	
    	rtnStr = rtnStr.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
    	
        return rtnStr;
    	
    }
    
    public static String getClientIp(HttpServletRequest req) {
    	String ip = req.getHeader("X-Forwarded-For");
    	
    	if(ip == null) {
    		ip = req.getRemoteAddr();
    	}
    	
    	return ip;
    }
    
    
}
