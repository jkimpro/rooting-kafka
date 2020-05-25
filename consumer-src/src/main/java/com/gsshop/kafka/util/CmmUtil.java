package com.gsshop.kafka.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import javax.persistence.Tuple;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CmmUtil {

//	protected final static String ZEROSOCIALNUMBER = "000000-0000000";

	private static DecimalFormat df = new DecimalFormat("#,###");
	
	/**
	 * 각 번호의 포맷 체크
	 * 
	 * @since 2010.02.08
	 * @param String
	 *            번호의 문자열
	 * @param String
	 *            번호 타입 ( so:주민번호, cr:신용카드, ac:계좌번호 )
	 * @return boolean 포맷 적절성 여부.
	 */
	protected static boolean checkFormat(String numberFormat, String numberType) {

		String pattern = "";

		if ( numberFormat == null ) {
			return false;
		}

		// 정규식 패턴 문자열 정의
		if ("so".equals(numberType)) {
			// 주민등록번호. 6자리의 정수 + [1, 2, 3, 4 중 택 1] + 6자리의 정수
			// 2014.09.23 오류 수정  6자리의 정수 + [1, 2, 3, 4 , 5, 6, 7 ,8  중 택 1] + 6자리의 정수
			pattern = "[0-9]{6}-{0,1}[1-8][0-9]{6}";
		} else if ("cr".equals(numberType)) {
			// 신용카드번호. 4자리 정수 + 4자리 정수 + 4자리 정수 + 4 or 3 자리 정수.
			pattern = "[0-9]{4}-{0,1}[0-9]{4}-{0,1}[0-9]{4}-{0,1}[0-9]{3,4}";
		} else if ("ac".equals(numberType)) {
			// 계좌번호. 정수로 시작 + 정수 or '-' + 정수
			// '-' 두번 연속 나오는 경우는 못 잡아낸다.
			pattern = "[0-9]{1,}[0-9-]{0,}[0-9]";
		}

		return Pattern.matches(pattern, numberFormat);
	}

//	protected static String getSocialNumberWithHyphen(String entCivilNo) {
//
//		StringBuffer sb = new StringBuffer();
//
//		if ( entCivilNo == null ) {
//			return ZEROSOCIALNUMBER;
//		} else if (entCivilNo.getBytes().length == 13) {
//			sb.append(entCivilNo.substring(0, 6));
//			sb.append("-");
//			sb.append(entCivilNo.substring(6, 13));
//
//			return sb.toString();
//		} else {
//			return processWrongFormattedNumber(entCivilNo, "so");
//		}
//	}

	public static String processWrongFormattedNumber(String number, String numberType) {

		if ( StringUtils.isEmpty(number) ) {
			return "";
		}
		
		 StringBuffer sb = new StringBuffer();

		 byte[] ba = number.getBytes();

		 try {
			 
			 if ( "so".equals(numberType) ) {  // 주민등록번호 
//				 logger.debug("[" + number + "] is wrong social number format.");
				 sb.append(number.substring(0, ba.length - 6));
				 sb.append("******");
			 } else if ( "cr".equals(numberType) ) { // 신용카드 번호 
//				 logger.debug("[" + number + "] is wrong credit card number format.");			
				 sb.append(number.substring(0, ba.length - 7));
				 sb.append("****");
				 sb.append(number.substring(ba.length - 3)); 	            
			 } else if ("ac".equals(numberType)) { // 계좌번호 	
				 sb.append(number.substring(0, ba.length - 5));
				 sb.append("*****");
			 } else {
//				 logger.debug("[" + number + "] is wrong number format.");
				 sb.append(number.substring(0, ba.length - 5));
				 sb.append("*****");
			 }
		 } catch (Exception e) {
			 sb.append("*****");
		 }

		 return sb.toString();
	}

	// map안의 전화번호에서 '-' 제거
	public static void unformatTelno(Map<String, Object> map, String key) {
		
		String telno = (String)map.get(key);
		
		if ( !StringUtils.isEmpty(telno) && telno.indexOf("-") > 0 ) {
			map.put(key, telno.replaceAll("-", ""));
		}
	}
	

	
	

	// 두개의 문자값 동일 여부 비교
	public static boolean isStringChg(String pPrvStr, String pNewStr) {
		
		String prvStr = ( pPrvStr == null ) ? "":pPrvStr.trim();
		String newStr = ( pNewStr == null ) ? "":pNewStr.trim();
		
		if ( prvStr.equals(newStr) ) {
			return false;
		}
		
		return true;
	}
	
	// 두개의 일시값 동일여부 비교
	public static boolean isDateChg(Date pPrvDate, Date pNewDate) {
				
		if ( pPrvDate == null && pNewDate == null ) {
			return false;
		}
		
		if ( (pPrvDate != null && pPrvDate.compareTo(pNewDate) == 0) || 
			 (pNewDate != null && pNewDate.compareTo(pPrvDate) == 0) ) {
			
			return false;
		}
		
		return true;
	}
	
	// 두개의 숫자값 동일여부 비교
	public static boolean isNumberChg(BigDecimal pPrvNum, BigDecimal pNewNum) {

		if ( pPrvNum == null && pNewNum == null ) {
			return false;
		}
		
		if ( (pPrvNum != null && pPrvNum.equals(pNewNum)) || 
			 (pNewNum != null && pNewNum.equals(pPrvNum)) ) {
				
			return false;
		}
		
		return true;
	}
	
	// list내의 Vo에서 해당 필드명을 추출하여 Set으로 리턴
	public static <T extends Object> Set<T> makeFilterSet(List list, String fieldName) {
		
		Set<T> set = new HashSet<T>();

		if ( list == null || list.size() == 0 ) {
			return set;	
		}
		
		try {

			Method method = list.get(0).getClass().getDeclaredMethod("get"+fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1), null);
			
			for ( int i = 0; i< list.size(); i++ ) {
				Object obj = method.invoke(list.get(i), null);
				if( obj != null ) {
					set.add((T)obj);
				}
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return set;
	}	

	// list내의 Vo.pk에서 해당 필드명을 추출하여 Set으로 리턴
	public static <T extends Object> Set<T> makeFilterSetPk(List list, String fieldName) {

		Set<T> set = new HashSet<T>();

		if ( list == null || list.size() == 0 ) {
			return set;	
		}
		
		try {

//			Method[] aMethod = list.get(0).getClass().getDeclaredMethods();
			
			Method mthdPk = list.get(0).getClass().getDeclaredMethod("getPk", null);
			Method mthdFd = null;

			Object pk = null;
			
			for ( int i = 0; i< list.size(); i++ ) {
				
				pk = mthdPk.invoke(list.get(i), null);
				
				if ( i == 0 ) {
					mthdFd = pk.getClass().getDeclaredMethod("get"+fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1), null);
				} 

				set.add((T)mthdFd.invoke(pk, null));
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return set;
	}	

	// 배열을 Set으로 변환
	@SuppressWarnings("unchecked")
	public static <T extends Object> Set<T> makeSet(Object[] list) {
		
		Set<T> set = new HashSet<T>();
		
		for ( Object obj : list ) {
			set.add((T) obj);
		}
		
		return set;
	}
	
	// 오라클 NVL과 동일, 문자 값이 없을시 디폴트값으로 리턴
	public static String nvl(String str, String defaultVal) {
		
		if ( StringUtils.isEmpty(str) ) {
			return defaultVal;
		}
		
		return str;
	}
	
	public static String nvl(String str) {
		
		if ( StringUtils.isEmpty(str) ) {
			return "";
		}
		
		return str;
	}

	public static String nvl(BigDecimal str) {
		return nvl(str, "");
	}
	
	public static String nvl(BigDecimal str, String defaultVal) {
		
		if ( str == null ) {
			return defaultVal;
		}
		
		return str.toString();
	}

	// 오라클 NVL과 동일, 문자 값이 없을시 디폴트값으로 리턴
	public static String nvl2(String str, String sucVal, String nullVal ) {
		
		if ( StringUtils.isEmpty(str) ) {
			return nullVal;
		}
		
		return sucVal;
	}

	// 오라클 NVL과 동일, 숫자 값이 없을시 디폴트값으로 리턴
	public static BigDecimal nvl(BigDecimal num, BigDecimal defaultVal) {
		
		if ( num == null  ) {
			return defaultVal;
		}
		
		return num;
	}

	// 오라클 NVL과 동일, 일시 값이 없을시 디폴트값으로 리턴
	public static Date nvl(Date date, Date defaultVal) {
		
		if ( date == null  ) {
			return defaultVal;
		}
		
		return date;
	}	
	
//	public static boolean hasKoreanChar(String txt) {
//		
//		if ( txt.matches(CstConstants.KOREAN_MATCH_CHAR) ) {
//			return true;
//		}
//		
//		return false;
//	}
	

	public static String getYn(String code) {
		
		if ( StringUtils.isEmpty(code) ) {
			return "N";
		} else if ( "1".equals(code) ) {
			return "Y";
		} else if ( "0".equals(code) ) {
			return "N";
		} else {
			return code;
		}
	}
	
	public static Object getMethod(Object obj, String fieldName) {
		
		if( StringUtils.isEmpty(fieldName) ) {
			return null;
		}
		
		Object returnObj = null;
		
		try {
			Method method = obj.getClass().getDeclaredMethod("get"+fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1), null);
			returnObj = method.invoke(obj);
			
		} catch (Exception e) {
			e.printStackTrace();
		}			
		
		return returnObj;
	}

	public static String lpad(String str, int len, String chr) {
		
		String tmp = "";
		
		for ( int i = str.length(); i < len; i++ ) {
			tmp += chr;
		}
		
		return tmp + str;
	}

	public static String substr(String str, int strIdx, int len) {
		
		if ( StringUtils.isEmpty(str) ) {
			return "";
		}
		
		if ( strIdx + len > str.length() ) {
			return str.substring(strIdx);
		}
		
		return str.substring(strIdx, strIdx+len);
	}	
	
	public static String map2HttpString(Map<String, Object> paramMap) {
		
		StringBuffer sb = new StringBuffer();
		
		Set<String> keys = paramMap.keySet();
		
		Iterator<String> iterator = keys.iterator();
		
		while ( iterator.hasNext() ) {
			
			String key   = iterator.next();
			Object value = paramMap.get(key);
			
			if ( value == null || !(value instanceof String) ) {
				continue;
			}
			
			try {
				sb.append("&").append(key).append("=").append(URLEncoder.encode(value.toString(), "utf-8"));
			} catch (Exception e) {
				throw new RuntimeException();
			}
		}
		
		String rtnStr = sb.toString();
		
		if ( rtnStr.length() > 0 ) rtnStr = rtnStr.substring(1);
		
		log.debug("*************************************************************");
		log.debug("map2HttpString : " + rtnStr);
		log.debug("*************************************************************");
		
		return rtnStr;
	}
	
	/** return 기본 결과값 셋팅 */
	public static Map<String, Object> setReturnMap(Map<String, Object> returnMap, String retCd, String retMsg) {
		
		if( returnMap == null ) {
			returnMap = new HashMap<>();
		}
		returnMap.put("retCd" , retCd);
		returnMap.put("retMsg", retMsg);
		
		return returnMap;
	}
	
	public static String getMinor14Yn(String birthDay) {
		
		String today   = DateUtil.getYYYYMMDD(DateUtil.getToday());
        String ageYear = birthDay.substring(0,4);

        int age = Integer.parseInt(today.substring(0, 4)) - Integer.parseInt(ageYear);
        int std = Integer.parseInt(today.substring(4, 8));
        int sbd = Integer.parseInt(birthDay.substring(0, 4));

        if ( sbd > std ) {
            age = age - 1;
        }

        if (age < 14) {
        	return "Y";
        } else {
        	return "N";
        }
	}

	public static String getSsnoMinor14Yn(String ssno) {
		
    	String mfFlag   = ssno.substring(6, 7);
    	String birthday = "";
    	
    	if ( "1,2,5,6".indexOf(mfFlag) > -1) {
    		birthday = "19" + ssno.substring(0, 6);       		
    	} else if ("3,4,7,8".indexOf(mfFlag) > -1) {
    		birthday = "20" + ssno.substring(0, 6);
        }
    	
    	return getMinor14Yn(birthday);
	}
	
	/*
     * 바이트로 문자 짜르기
     */
    public static String cutFirstStrInByte(String str, int endIndex) throws UnsupportedEncodingException {
        StringBuffer sbStr = new StringBuffer(endIndex);
        int iTotal = 0;
        for (char c : str.toCharArray()) {
            iTotal += String.valueOf(c).getBytes("euc-kr").length;
            if (iTotal > endIndex) {
                break;
            }

            switch (c) {
            case ' ':
                sbStr.append("^");
                break;
            default:
                sbStr.append(c);
            }

        }
        return sbStr.toString();
    }
    
    /**
     * 문자채우기
     * @param str
     * @param nLength
     * @return
     */
    public static String gsnpntString(String str, int nLength) {
        String strReturn = "";

        for (int i = 0; i < nLength; i++) {
            strReturn = strReturn + str;
        }

        return strReturn;
    }
    
    public static String getString(Tuple tpl, String key) {
    	
    	return getString(tpl, key, null);
    }
    
    public static String getString(Tuple tpl, String key, String defaultVal) {

    	Object obj = tpl.get(key);
    	
    	if ( obj == null ) {
    		return defaultVal;
    	}
    	
		return obj.toString();
    }

    public static Date getDate(Tuple tpl, String key) {
    	
    	return getDate(tpl, key, null);
    }

    public static Date getDate(Tuple tpl, String key, Date defaultVal) {

    	Object obj = tpl.get(key);

    	if ( obj == null ) {
    		return defaultVal;
    	}

    	if ( obj instanceof Date ) {
    		
    		return (Date)obj;

    	} else if ( obj instanceof String ) {
        		
    		return DateUtil.getDate(obj.toString());
    	}
    	
    	return null;
    }
    
    public static BigDecimal getNumber(Tuple tpl, String key) {
    	
    	return getNumber(tpl, key, null);
    }

    public static BigDecimal getNumber(Tuple tpl, String key, BigDecimal defaultVal) {
    
    	Object obj = tpl.get(key);

    	if ( obj == null ) {
    		
    		return defaultVal;
    	}
    	
		if ( obj instanceof BigDecimal ) {
			
			return (BigDecimal) obj;

    	} else if ( obj instanceof String ) {

    		String str = obj.toString();
    		
    		if ( !StringUtils.isEmpty(str) ) {
    			
    			return new BigDecimal(str);
    		}
		}
    	
		return null;
    }    
    
    //***********************************************************************
    // 삭제 대상
    //***********************************************************************

//
//	// tgtMap에 srcMap의 값을 복사
//	public static void addMap(Map<String, Object> tgtMap, Map<String, Object> srcMap, String[] keys){
//		
//		for ( int i = 0; i < keys.length; i++ ) {
//			tgtMap.put(keys[i], srcMap.get(keys[i]));
//		}
//	}
//
//	// tgtMap에 srcMap의 값을 다른키로 복사
//	public static void addMap(Map<String, Object> tgtMap, Map<String, Object> srcMap, String[][] keys){
//		
//		for ( int i = 0; i < keys.length; i++ ) {
//			tgtMap.put(keys[i][0], srcMap.get(keys[i][1]));
//		}
//	}
//
//	// map의 값을 새로운 맵으로 봇사
//	public static Map<String, Object> copyMap(Map<String, Object> map, String[] keys){
//		
//		Map<String, Object> newMap = new HashMap<String, Object>();
//		
//		for ( int i = 0; i < keys.length; i++ ) {
//			newMap.put(keys[i], map.get(keys[i]));
//		}
//		
//		return newMap;
//	}
//
//	// map의 값을 새로운 맵의 다른키로 봇사
//	public static Map<String, Object> copyMap(Map<String, Object> map, String[][] keys){
//		
//		Map<String, Object> newMap = new HashMap<String, Object>();
//		
//		for ( int i = 0; i < keys.length; i++ ) {
//			newMap.put(keys[i][0], map.get(keys[i][1]));
//		}
//		
//		return newMap;
//	}
//
//	// map의 값을 새로운 맵으로 봇사(세션정보 추가)
//	public static Map<String, Object> copyMapWithSession(Map<String, Object> map, String[] keys){
//		
//		Map<String, Object> newMap = copyMap(map, keys);
//	
//		copySession(newMap, map);
//		
//		return newMap;
//	}
//
//	// map의 값을 새로운 맵의 다른키로 봇사(세션정보 추가)
//	public static Map<String, Object> copyMapWithSession(Map<String, Object> map, String[][] keys){
//		
//		Map<String, Object> newMap = copyMap(map, keys);
//
//		copySession(newMap, map);
//		
//		return newMap;
//	}
//    
//	// 세션정보 복사
//	private static void copySession(Map<String, Object> newMap, Map<String, Object> map) {
//		
//		newMap.put("now"   , map.get("now"));
//		newMap.put("userId", map.get("userId"));
//		newMap.put("userIp", map.get("userIp"));
//	
//		if ( map.get("regDtm") != null ) {
//			newMap.put("regDtm", map.get("regDtm"));
//			newMap.put("regrId", map.get("regrId"));
//		} else {
//			newMap.put("regDtm", map.get("now"));
//			newMap.put("regrId", map.get("userId"));
//		}
//		
//		if ( map.get("modDtm") != null ) {
//			newMap.put("modDtm", map.get("modDtm"));
//			newMap.put("modrId", map.get("modrId"));		
//		} else {
//			newMap.put("modDtm", map.get("now"));
//			newMap.put("modrId", map.get("userId"));		
//		}
//	}
//
//	// map에서 문자값 추출
//	public static String getString(Map<String, Object> map, String key) {
//		
//		return getString(map, key, null);
//	}
//	
//	// map에서 문자값 추출하고 없을시 디폴트 값으로 대체
//	public static String getString(Map<String, Object> map, String key, String defaultVal) {
//		
//		String str = null;
//
//		Object obj = map.get(key);
//		
//		if ( obj instanceof String ) {
//			str = (String)obj;
//		} else if ( obj instanceof BigDecimal ) {
//			str = ((BigDecimal)obj).toString();
//		}
//
//		if ( StringUtils.isEmpty(str) ) {
//			return defaultVal;
//		}
//		
//		return str;
//	}
//
//	// map에서 숫자값 추출
//	public static BigDecimal getNumber(Map<String, Object> map, String key) {
//		
//		return getNumber(map, key, null);
//	}
//
//	// map에서 숫자값을 추출하고 없을시 디폴트 값으로 대체
//	public static BigDecimal getNumber(Map<String, Object> map, String key, BigDecimal defaultVal) {
//		
//		BigDecimal num = null;
//		
//		Object obj = map.get(key);
//		
//		if ( obj instanceof String ) {
//			num = new BigDecimal(obj.toString());
//		} else if ( obj instanceof BigDecimal ) {
//			num = (BigDecimal)obj;
//		}
//		
//		if ( num == null ) {
//			return defaultVal;
//		}
//		
//		return num;
//	}
//
//	// map에서 일시값 추출
//	public static Date getDate(Map<String, Object> map, String key) {
//		
//		return getDate(map, key, null);
//	}
//
//	// map에서 일시값을 추출하고 없을시 디펄트 값으로 대체
//	public static Date getDate(Map<String, Object> map, String key, String defaultVal) {
//		
//		Date date = null;
//
//		Object obj = map.get(key);
//		
//		if ( obj instanceof String ) {
//			date = DateUtil.getDate(obj.toString());
//		} else if ( obj instanceof Date ) {
//			date = (Date)obj;
//		}
//		
//		if ( date == null ) {
//			return (Date)map.get(defaultVal);
//		}
//		
//		return date;
//	}
//	
//	// map내의 값이 없는 키를 제거(bRemoveRegr는 테이블 update시 true로 사용)
//	public static void removeNull(Map<String, Object> map, boolean bRemoveRegr) {
//
//		String key = null;
//		Object obj = null;
//		
//		List<String> keyList = new ArrayList<String>();
//
//		for (Iterator<String> it = map.keySet().iterator(); it.hasNext(); ) {
//			
//			key = it.next();
//			obj = map.get(key);
//
//			if ( obj == null ) {
//				keyList.add(key);
////				map.remove(key);
//			} else {
//				
//				if ( obj instanceof String ) {
//					if ( StringUtils.isEmpty(((String)obj).trim()) ) {
//						keyList.add(key);
////						map.remove(key);
//					}
//				}
//			}
//		}
//
//		for (String rKey : keyList) {
//			map.remove(rKey);
//		}
//		
//		if ( bRemoveRegr ) {
//			map.remove("regDtm");
//			map.remove("regrId");
//		}
//	}
//
//	// Optional이 존재시 객체를 리턴
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	public static <T extends Object> T getOptObj(Optional optObj) {
//		
//		if ( optObj.isPresent() ) {
//			return (T) optObj.get();
//		}
//		
//		return null;
//	}
//
//	// map에 키값이 없는 경우 디폴트값으로 설정
//	public static void setDefault(Map<String, Object> map, String key, Object defaultVal) {
//		
//		Object val = map.get(key);
//		
//		if ( val instanceof String ) {
//			
//			if ( StringUtils.isEmpty((String)val) ) {
//				
//				map.put(key, defaultVal);
//			}
//			
//		} else {
//			
//			if ( val == null ) {
//				map.put(key, defaultVal);
//			}
//		}
//	}
//
//	// map에 키값이 없는 경우 map안의 다른 키로 복사
//	public static void setDefaultKey(Map<String, Object> map, String key, String defaultKey) {
//		
//		Object val = map.get(key);
//		
//		if ( val instanceof String ) {
//			
//			if ( StringUtils.isEmpty((String)val) ) {
//				
//				map.put(key, map.get(defaultKey));
//			}
//			
//		} else {
//			
//			if ( val == null ) {
//				map.put(key, map.get(defaultKey));
//			}
//		}
//	}
//
//	// map의 해당 키에 현재일시 설정
//	public static void setNow(Map<String, Object> map, String key) {
//		
//		map.put(key, map.get("now"));
//	}    
//
//	// list의 첫번째 객체만 리턴
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	public static <T extends Object> T getFirstObj(List list ) {
//		
//		if ( list == null || list.size() == 0 ) {
//			return null;
//		}
//		
//		return (T) list.get(0);
//	}
//	
//	// 세션정보 추가
//	public static void addSession(Map<String, Object> newMap, Map<String, Object> sessionMap) {
//		
//		
//    	removeNull(newMap, false);
//
//    	transMap(newMap, null);
//		
//		Date   now    = DateUtil.getDate("now");
//		String userId = getString(sessionMap, "sessionUserId");
//		String userIp = getString(sessionMap, "sessionUserIp");
//		
//		
//		newMap.put("now"   , now);
//		newMap.put("userId", userId);
//		newMap.put("userIp", userIp);
//		newMap.put("regDtm", now);
//		newMap.put("regrId", userId);
//		newMap.put("modDtm", now);
//		newMap.put("modrId", userId);
//		newMap.put("useYn" , "Y");
//		
//		String sessionChanlCd = getString(sessionMap, "sessionChanlCd");
//		
//		newMap.put("sessionChanlCd" , sessionChanlCd);
//	}
//
//	public static void transMap(Map<String, Object> map, String[] aTgtKey) {
//		
//		String  key;
//		Object  val;
//		boolean isExist;
//		
//		for ( Iterator it = map.keySet().iterator(); it.hasNext(); ) {
//			
//			key = (String)it.next();
//			
//			if ( aTgtKey != null ) {
//				
//				isExist = false;
//				
//				for ( String tgtKey : aTgtKey ) {
//					if ( key.equals(tgtKey) ) {
//						isExist = true;
//						break;
//					}
//				}
//			} else {
//				isExist = true;
//			}
//			
//			if ( !isExist ) {
//				continue;
//			}
//
//			val = map.get(key);
//			
//			if ( val instanceof String &&
//				 !StringUtils.isEmpty((String)val) &&
//				 !key.startsWith("session") ) {
//				
//				if ( key.endsWith("Dtm") ) {
//					val = DateUtil.getDate((String)val);
//					map.put(key, val);
//				} 
//				// jewelLee 주석처리. String형태는 체크안함
////				  else if ( key.endsWith("No") ) {
////					if (!key.endsWith("DiNo") && !key.endsWith("CiNo") &&!key.endsWith("TnsNo") &&
////							!key.endsWith("srNo") && !key.endsWith("sndNo") && !key.endsWith("rcvNo")  		
////						) { //jewellee 18.10.25
////						val = new BigDecimal((String)val);
////						map.put(key, val);
////					}
////				}
//			}
//		}
//	}
	
    /**
	 * 
	 * <pre>
	 *
	 * desc : 
	 *  한글 깨짐 없이 byte 로 자르기  
	 * </pre>
	 * @author jeany4u
	 * @date 2012. 1. 16. 오후 3:36:15
	 * @param sourceText
	 * @param cutLength
	 * @return
	 */
	public static String stringCut(String sourceText, int cutLength){
		return stringCut(sourceText,"",cutLength,0,false,false );
	}
	
	/**
	 * 
	 *  sourceText: 입력받는 원본 문자열 
	 *	startKeyword: 시작할 키워드 
	 *	cutLength: 자를 길이 
	 *	startKeywordPreviousLength: 시작할 키워드 이전 포함할 문자의 길이 
	 *	isTag: HTML 태그 제거 여부 
	 *	isDot: 생략 "..." 표시 출력 여부
	 * desc : 
	 *
	 * </pre>
	 * @author jeany4u
	 * @date 2012. 1. 16. 오후 3:31:24
	 * @param sourceText
	 * @param startKeyword
	 * @param cutLength
	 * @param startKewordPreviousLength
	 * @param isTag
	 * @param isDot
	 * @return
	 */
	public static String stringCut(String sourceText, String startKeyword, int cutLength,
			int startKewordPreviousLength, boolean isTag, boolean isDot) {
		String targetText = sourceText;
		int oF = 0;
		int oL = 0;
		int rF = 0;
		int rL = 0;
		int nLengthPrev = 0;
		
		// 태그 제거 패턴
		Pattern p = Pattern
				.compile("<(/?)([^<>]*)?>", Pattern.CASE_INSENSITIVE);

		if (isTag) {
			targetText = p.matcher(targetText).replaceAll("");
		}
		
		// 태그 제거
		targetText = targetText.replaceAll("&amp;", "&");
		
		// 공백제거
		targetText = targetText.replaceAll("(!/|\r|\n|&nbsp;)", "");

		try {
			 // 바이트 보관
			byte[] bytes = targetText.getBytes("UTF-8");
			if (startKeyword != null && !startKeyword.equals("")) {
				nLengthPrev = (targetText.indexOf(startKeyword) == -1) ? 0 : targetText
						.indexOf(startKeyword); // 일단 위치찾고
				// 위치까지길이를  byte로 다시 구한다
				nLengthPrev = targetText.substring(0, nLengthPrev).getBytes("MS949").length;
				// 좀 앞부분부터 가져오도록한다.
				nLengthPrev = (nLengthPrev - startKewordPreviousLength >= 0) ? nLengthPrev - startKewordPreviousLength : 0; 
			}

			// x부터 y길이만큼 잘라낸다. 한글안깨지게.
			int j = 0;

			if (nLengthPrev > 0)
				while (j < bytes.length) {
					if ((bytes[j] & 0x80) != 0) {
						oF += 2;
						rF += 3;
						if (oF + 2 > nLengthPrev) {
							break;
						}
						j += 3;
					} else {
						if (oF + 1 > nLengthPrev) {
							break;
						}
						++oF;
						++rF;
						++j;
					}
				}

			j = rF;

			while (j < bytes.length) {
				if ((bytes[j] & 0x80) != 0) {
					if (oL + 2 > cutLength) {
						break;
					}
					oL += 2;
					rL += 3;
					j += 3;
				} else {
					if (oL + 1 > cutLength) {
						break;
					}
					++oL;
					++rL;
					++j;
				}
			}

			// charset 옵션
			targetText = new String(bytes, rF, rL, "UTF-8");

			 // "..."를 붙일지 말지 옵션
			if (isDot && rF + rL + 3 <= bytes.length) {
				targetText += "...";
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return targetText;
	}
	
	// 입력된 Set을 1000개씩 짤라 List<Set> 형태로 리턴
	public static <T extends Object> List<Set<T>> getSetList(Set<T> inSet) {
		
		List<Set<T>> setList = new ArrayList<Set<T>>();

		if ( inSet == null ) {

			setList.add(new HashSet<T>());			

		} else if ( inSet.size() < 1000 ) {
			
			setList.add(makeFixedSet(inSet));			
			
		} else {
			
			Set<T> tempSet = new HashSet<T>();
			
			int cnt = 0;
			
			for ( T obj : inSet ) {
				
				cnt++;
				
				tempSet.add(obj);
				
				if ( tempSet.size() == 1000 ) {
					setList.add(tempSet);
					tempSet.clear();
					continue;
				} else if ( cnt == inSet.size() ) {
					setList.add(makeFixedSet(tempSet));
					break;
				}
			}
		}

		return setList;
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Object> Set<T> makeFixedSet(Set<T> inSet) {
		
		if ( inSet == null ) return inSet; 
		
		int size = inSet.size();

		if ( size == 0 ) return inSet; 

		boolean isString = false;
		boolean isNumber = false;
		
		for ( Object obj : inSet ) {
			if ( obj instanceof String ) {
				isString = true;
			} else if ( obj instanceof BigDecimal ) {
				isNumber = true;
			}
			break;
		}
		
		int[] arrLen = {1,5,10,50,100,300,500,700,1000};
		
		for ( int len : arrLen ) {
			if ( size <= len ) {
				
				int dummy = len - size;

				if ( isString ) {

					for ( int i = 0; i < dummy; i++  ) {
						inSet.add((T)("#-" + i));
					}

				} else if ( isNumber ) {
					for ( int i = 0; i < dummy; i++  ) {
						inSet.add((T)(new BigDecimal("-" + i)));
					}
				}
				
				break;
			}
		}
		
		return inSet;
	}	
	
	@SuppressWarnings("unchecked")
	public static String makeKtInSql(Map<String, Object> pParamMap, String key, String colName) {
		
		Set<Object> objSet = (Set<Object>) pParamMap.get(key);

		return makeKtInSql(objSet, pParamMap, key, colName);
	}

	public static String makeKtInSql(Set<Object> objSet, Map<String, Object> pParamMap, String key) {
		
		return makeKtInSql(objSet, pParamMap, key, null);
	}

	public static String makeKtInSql(Set<Object> objSet, Map<String, Object> pParamMap, String key, String colName) {

		if ( objSet == null || objSet.size() == 0 ) return ( colName == null ) ? "null" : "";
			
		int idx = 0;
			
		Set<Object> fixObjSet = makeFixedSet(objSet);
			
		String sql = "";
			
		for ( Object obj : fixObjSet ) {
		
			sql += ", :"+ key + (++idx);
				
			if ( obj instanceof String ) {
				
				if ( ((String) obj).startsWith("#") ) {
					pParamMap.put(key + idx, null);						
				} else {
					pParamMap.put(key + idx, obj);
				}
			} else if ( obj instanceof BigDecimal ) {
				if ( ((BigDecimal) obj).compareTo(BigDecimal.ZERO) < 0 ) {	
					pParamMap.put(key + idx, null);						
				} else {
					pParamMap.put(key + idx, obj);
				}
			}
		}
		
		if ( colName != null ) {
			return " AND " + colName + " ( " + sql.substring(2) + " ) ";
		} else {
			return sql.substring(2);
		}
	}	
	
	public static String addComma(BigDecimal num) {
		
		if ( num == null ) return "0"; 
		
		return df.format(num);
	}
	
	public static boolean isNumber(String str){
        boolean result = false;
         
         
        try{
            Double.parseDouble(str) ;
            result = true ;
        }catch(Exception e){}
         
         
        return result ;
    }
     
}
