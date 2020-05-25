package com.gsshop.kafka.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

public class MapUtil {

	// tgtMap에 srcMap의 동일키로 복사
	public static void copyVal(Map<String, Object> tgtMap, Map<String, Object> srcMap, String key){
		
		copyVal(tgtMap, srcMap, key, key, null);
	}

	// tgtMap에 srcMap의 srcKey을 tgtKey로 복사
	public static void copyVal(Map<String, Object> tgtMap, Map<String, Object> srcMap, String tgtKey, String srcKey){
		
		copyVal(tgtMap, srcMap, tgtKey, srcKey, null);
	}
	
	// tgtMap에 srcMap의 srcKey을 tgtKey로 복사
	public static void copyVal(Map<String, Object> tgtMap, Map<String, Object> srcMap, String tgtKey, String srcKey, Object defaultVal){
		
		Object val = srcMap.get(srcKey); 
		
		if ( val instanceof String && val != null ) {
			if ( StringUtils.isEmpty(val.toString().trim()) ) {
				val = null;
			}
		}
		
		if ( val != null ) {
			tgtMap.put(tgtKey, srcMap.get(srcKey));
		} else if ( defaultVal != null ) {
			tgtMap.put(tgtKey, defaultVal);
		}
	}

	// tgtMap에 srcMap의 값을 복사
	public static void addMap(Map<String, Object> tgtMap, Map<String, Object> srcMap, String[] keys){
		
		for ( int i = 0; i < keys.length; i++ ) {
			tgtMap.put(keys[i], srcMap.get(keys[i]));
		}
	}

	// tgtMap에 srcMap의 값을 다른키로 복사
	public static void addMap(Map<String, Object> tgtMap, Map<String, Object> srcMap, String[][] keys){
		
		for ( int i = 0; i < keys.length; i++ ) {
			tgtMap.put(keys[i][0], srcMap.get(keys[i][1]));
		}
	}

	public static Map<String, Object> copyMap(Map<String, Object> map){
		
		Map<String, Object> newMap = new HashMap<String, Object>();
		newMap.putAll(map);
		
		return newMap;
	}

	// map의 값을 새로운 맵으로 봇사
	public static Map<String, Object> copyMap(Map<String, Object> map, String[] keys){
		
		Map<String, Object> newMap = new HashMap<String, Object>();
		
		for ( int i = 0; i < keys.length; i++ ) {
			newMap.put(keys[i], map.get(keys[i]));
		}
		
		return newMap;
	}

	// map의 값을 새로운 맵의 다른키로 봇사
	public static Map<String, Object> copyMap(Map<String, Object> map, String[][] keys){
		
		Map<String, Object> newMap = new HashMap<String, Object>();
		
		for ( int i = 0; i < keys.length; i++ ) {
			newMap.put(keys[i][0], map.get(keys[i][1]));
		}
		
		return newMap;
	}

	// map에서 문자값 추출
	public static String getString(Map<String, Object> map, String key) {
		
		return getString(map, key, null);
	}
	
	// map에서 문자값 추출하고 없을시 디폴트 값으로 대체
	public static String getString(Map<String, Object> map, String key, String defaultVal) {
		
		String str = null;

		Object obj = map.get(key);
		
		if ( obj == null ) return defaultVal;
		
		if ( obj instanceof String ) {
			str = ((String)obj).trim();
		} else if ( obj instanceof BigDecimal ) {
			str = ((BigDecimal)obj).toString();
		}

		if ( StringUtils.isEmpty(str) ) {
			return defaultVal;
		}
		
		return str;
	}

	// map에서 숫자값 추출
	public static BigDecimal getNumber(Map<String, Object> map, String key) {
		
		return getNumber(map, key, null);
	}

	// map에서 숫자값을 추출하고 없을시 디폴트 값으로 대체
	public static BigDecimal getNumber(Map<String, Object> map, String key, BigDecimal defaultVal) {
		
		BigDecimal num = null;
		
		Object obj = map.get(key);
		
		if ( obj == null ) return defaultVal;

		if ( obj instanceof String ) {
			if ( obj.toString().trim().length() > 0 ) {
				num = new BigDecimal(obj.toString().trim());
			}
		} else if ( obj instanceof BigDecimal ) {
			num = (BigDecimal)obj;
		}
		
		if ( num == null ) {
			return defaultVal;
		}
		
		return num;
	}

	// map에서 일시값 추출
	public static Date getDate(Map<String, Object> map, String key) {
		
		return getDate(map, key, null);
	}

	// map에서 일시값을 추출하고 없을시 디펄트 값으로 대체
	public static Date getDate(Map<String, Object> map, String key, String defaultVal) {
		
		Date date = null;

		Object obj = map.get(key);
		
		if ( obj == null ) return (Date)map.get(defaultVal);

		if ( obj instanceof String ) {
			date = DateUtil.getDate(obj.toString().trim());
		} else if ( obj instanceof Date ) {
			date = (Date)obj;
		}
		
		if ( date == null ) {
			return (Date)map.get(defaultVal);
		}
		
		return date;
	}
	
	public static void removeRegKey(Map<String, Object> map) {
		
		map.remove("regDtm");
		map.remove("regrId");
	}
	
//	// map�궡�쓽 媛믪씠 �뾾�뒗 �궎瑜� �젣嫄�(bRemoveRegr�뒗 �뀒�씠釉� update�떆 true濡� �궗�슜)
//	public static void removeNull(Map<String, Object> map, boolean bRemoveRegr) {
//
////		String key = null;
////		Object obj = null;
////		
////		List<String> keyList = new ArrayList<String>();
////
////		for (Iterator<String> it = map.keySet().iterator(); it.hasNext(); ) {
////			
////			key = it.next();
////			obj = map.get(key);
////
////			if ( obj == null ) {
////				keyList.add(key);
//////				map.remove(key);
////			} else {
////				
////				if ( obj instanceof String ) {
////					if ( StringUtils.isEmpty(((String)obj).trim()) ) {
////						keyList.add(key);
//////						map.remove(key);
////					}
////				}
////			}
////		}
////
////		for (String rKey : keyList) {
////			map.remove(rKey);
////		}
//		
//		if ( bRemoveRegr ) {
//			map.remove("regDtm");
//			map.remove("regrId");
//		}
//	}
	
	public static List<Map<String, Object>> makeMipOutput(Map<String, Object> pMap) {
		
    	List<Map<String, Object>> outputList = new ArrayList<Map<String, Object>>();
    	Map<String, Object> map = new HashMap<String, Object>();
    	
    	String key = null;
    	Object val = null;
    	
    	for ( Iterator<String> it = pMap.keySet().iterator(); it.hasNext(); ) {
    		
    		key = (String)it.next();
    		val = pMap.get(key);

    		map.put(key, val);
    	}

		outputList.add(map);
		
		return outputList;
	}
	
	@SuppressWarnings("rawtypes")
	public static boolean isNull(Collection list) {
		
		if ( list == null || list.size() == 0 ) {
			return true;
		}
		
		return false;
	}

//    @SuppressWarnings({ "unchecked", "rawtypes" })
//	public static Map<String, Object> objectToMap(Object obj){
//		
//        Map<String, Object> map = new HashMap<String, Object>();
//        
//        Class clazz = obj.getClass();
//        
//        Field[] fields = clazz.getDeclaredFields();
//        
//        String fieldName  = null;
//        String methodName = null;
//        Method method     = null;
//        Object val        = null;
//        
//        for ( Field field : fields ) {
//        	
//        	fieldName  = field.getName();
//        	
//        	if ( "serialVersionUID".equals(fieldName) ) continue;
//        	
//        	methodName = "get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
//        	
//            try {
//            	
//            	method = clazz.getDeclaredMethod(methodName, null);
//            	
//            	val = method.invoke(obj, null);
//            	
//            	if ( val != null ) {
//                    map.put(fieldName, val);
//            	} 
//                
//            } catch ( Exception e ) {
//                e.printStackTrace();
//            }
//        }        
//        
//        return map;
//    }
// 
//    @SuppressWarnings({ "unchecked", "rawtypes" })
//    public static <T extends Object> T mapToObject(Map<String, Object> map, Class clazz) {
//    	
//    	
//    	Object obj = null;
//	        
//        Field[] fields = clazz.getDeclaredFields();
//        
//        String fieldName  = null;
//        String fieldType  = null;
//        String methodName = null;
//        Method method     = null;
//        
//        Class[] stringParam = new Class[] { String.class };
//        Class[] numberParam = new Class[] { BigDecimal.class };
//        Class[] dateParam   = new Class[] { Date.class };
//        
//        Object value = null;
//        
//        try {
//        	
//	        obj = clazz.newInstance();
//        
//	        for ( Field field : fields ) {
//	
//	        	fieldType = field.getType().getSimpleName();
//	        	fieldName = field.getName();
//	
//	        	if ( map.get(fieldName) == null ) {
//	        		continue;
//	        	}
//	        	
//	        	methodName = "set"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
//
//            	if ( "String".equals(fieldType) ) {
//	        		value = getString(map, fieldName);
//	            	method = clazz.getDeclaredMethod(methodName, stringParam);
//	        	} else if ( "BigDecimal".equals(fieldType) ) {
//	        		value = getNumber(map, fieldName);
//	            	method = clazz.getDeclaredMethod(methodName, numberParam);
//	        	} else if ( "Date".equals(fieldType) ) {
//	        		value = getDate(map, fieldName);
//	            	method = clazz.getDeclaredMethod(methodName, dateParam);
//	        	} else {
//	        		continue;
//	        	}
//            	
//            	if ( value != null) {
//                	method.invoke(obj, value);
//            	}
//	        }
//                
//        } catch ( Exception e ) {
//            e.printStackTrace();
//        }
//        
//        return (T) obj;
//    }
//
//    @SuppressWarnings({ "unchecked", "rawtypes" })
//    public static void mapToObject(Map<String, Object> map, Object obj) {
//    	
//    	Class clazz = obj.getClass();
//	        
//        Field[] fields = clazz.getDeclaredFields();
//        
//        String fieldName  = null;
//        String fieldType  = null;
//        String methodName = null;
//        Method method     = null;
//        
//        Class[] stringParam = new Class[] { String.class };
//        Class[] numberParam = new Class[] { BigDecimal.class };
//        Class[] dateParam   = new Class[] { Date.class };
//        
//        Object value = null;
//        
//        try {
//        
//	        for ( Field field : fields ) {
//	
//	        	fieldType = field.getType().getSimpleName();
//	        	fieldName = field.getName();
//	
//	        	if ( !map.containsKey(fieldName) ) {
//	        		continue;
//	        	}
//	        	
//	        	methodName = "set"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
//
//	        	if ( "String".equals(fieldType) ) {
//	            	method = clazz.getDeclaredMethod(methodName, stringParam);
//	        		value = getString(map, fieldName);
//	        	} else if ( "BigDecimal".equals(fieldType) ) {
//	            	method = clazz.getDeclaredMethod(methodName, numberParam);
//	        		value = getNumber(map, fieldName);
//	        	} else if ( "Date".equals(fieldType) ) {
//	            	method = clazz.getDeclaredMethod(methodName, dateParam);
//	        		value = getDate(map, fieldName);
//	        	} else {
//	        		continue;
//	        	}
//
//            	method.invoke(obj, value);
//
////            	if ( value != null) {
////                	method.invoke(obj, value);
////            	}
//	        }
//                
//        } catch ( Exception e ) {
//            e.printStackTrace();
//        }
//    }
    
	// map에 키값이 없는 경우 디폴트값으로 설정
	public static void setDefault(Map<String, Object> map, String key, Object defaultVal) {
		
		Object val = map.get(key);
		
		if ( val instanceof String ) {
			
			if ( StringUtils.isEmpty((String)val) ) {
				
				map.put(key, defaultVal);
			}
			
		} else {
			
			if ( val == null ) {
				map.put(key, defaultVal);
			}
		}
	}

	// map에 키값이 없는 경우 map안의 다른 키로 복사
	public static void setDefaultKey(Map<String, Object> map, String key, String defaultKey) {
		
		Object val = map.get(key);

		if ( val != null ) {
			
			if ( val instanceof String ) {
				
				if ( StringUtils.isEmpty((String)val) ) {
					
					map.put(key, map.get(defaultKey));
				}
				
			}
			
		} else {
			map.put(key, map.get(defaultKey));
		}

	}
	
	// list의 첫번째 객체만 리턴
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T extends Object> T getFirstObj(List list ) {
		
		if ( list == null || list.size() == 0 ) {
			return null;
		}
		
		return (T) list.get(0);
	}
	
	// Optional이 존재시 객체를 리턴
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T extends Object> T getOptObj(Optional optObj) {
		
		if ( optObj.isPresent() ) {
			return (T) optObj.get();
		}
		
		return null;
	}
	
//	// �꽭�뀡�젙蹂� 異붽�
//	public static void addSession(Map<String, Object> newMap, Map<String, Object> sessionMap) {
//		
//		Date   now            = DateUtil.getDate("now");
//		String sessionUserId  = getString(sessionMap, "sessionUserId");
//		String sessionUserIp  = getString(sessionMap, "sessionUserIp");
//		String sessionChanlCd = getString(sessionMap, "sessionChanlCd");
//		
//		newMap.put("now"            , now);
//		newMap.put("sessionUserId"  , sessionUserId);
//		newMap.put("sessionUserIp"  , sessionUserIp);
//		newMap.put("sessionChanlCd" , sessionChanlCd);
//	}

	public static void transMap(Map<String, Object> map, String[] aTgtKey) {
		
		String  key;
		Object  val;
		boolean isExist;
		
		for ( Iterator it = map.keySet().iterator(); it.hasNext(); ) {
			
			key = (String)it.next();
			
			if ( aTgtKey != null ) {
				
				isExist = false;
				
				for ( String tgtKey : aTgtKey ) {
					if ( key.equals(tgtKey) ) {
						isExist = true;
						break;
					}
				}
			} else {
				isExist = true;
			}
			
			if ( !isExist ) {
				continue;
			}

			val = map.get(key);
			
			if ( val instanceof String &&
				 !StringUtils.isEmpty((String)val) &&
				 !key.startsWith("session") ) {
				
				if ( key.endsWith("Dtm") ) {
					val = DateUtil.getDate((String)val);
					map.put(key, val);
				} 
				// jewelLee 二쇱꽍泥섎━. String�삎�깭�뒗 泥댄겕�븞�븿
//				  else if ( key.endsWith("No") ) {
//					if (!key.endsWith("DiNo") && !key.endsWith("CiNo") &&!key.endsWith("TnsNo") &&
//							!key.endsWith("srNo") && !key.endsWith("sndNo") && !key.endsWith("rcvNo")  		
//						) { //jewellee 18.10.25
//						val = new BigDecimal((String)val);
//						map.put(key, val);
//					}
//				}
			}
		}
	}
}
