package com.gsshop.kafka.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjUtil {

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String, Object> createMap(Object obj){
		
        Map<String, Object> map = new HashMap<String, Object>();
        
        Class clazz = obj.getClass();
        
        Field[] fields = null;
        
        String fieldName  = null;
        String methodName = null;
        Method method     = null;
        Object val        = null;
        
        while ( clazz != null ) {
        	
//        	System.out.println("SUPER CLASS : "+clazz.getName());

        	if ( "java.lang.Object".equals(clazz.getName()) ) {
        		break;
        	}

            fields = clazz.getDeclaredFields();

	        for ( Field field : fields ) {
	        	
	        	fieldName  = field.getName();
	
	        	if ( "serialVersionUID".equals(fieldName) ) continue;
	
	        	methodName = "get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
	
	            try {
	            	
	            	method = clazz.getDeclaredMethod(methodName, null);
	            	
	            	val = method.invoke(obj, null);
	            	
	            	if ( val != null ) {
	                    map.put(fieldName, val);
	            	} 
	                
	            } catch ( Exception e ) {
	                e.printStackTrace();
	            }
	        } 
	        
            clazz = clazz.getSuperclass();
        }
        
        return map;
    }
 
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T extends Object> T createObject(Map<String, Object> map, Class pClazz) {
    	
    	Class clazz = pClazz;
    	
    	Object obj = null;
	        
        Field[] fields = null;
        
        String fieldName  = null;
        String fieldType  = null;
        String methodName = null;
        Method method     = null;
        
        Class[] stringParam = new Class[] { String.class };
        Class[] numberParam = new Class[] { BigDecimal.class };
        Class[] dateParam   = new Class[] { Date.class };
        
        Object value = null;
        
        try {
        	
	        while ( clazz != null ) {
	        	
//	        	System.out.println("SUPER CLASS : "+clazz.getName());

	        	if ( "java.lang.Object".equals(clazz.getName()) ) {
	        		break;
	        	}

	            fields = clazz.getDeclaredFields();

	            if( obj == null ) {
	            	obj = clazz.newInstance();
	            }
	            
		        for ( Field field : fields ) {
		
		        	fieldType = field.getType().getSimpleName();
		        	fieldName = field.getName();
		
	//	        	if ( !map.containsKey(fieldName) ) {
	//	        		continue;
	//	        	}
		
		        	if ( map.get(fieldName) == null ) {
		        		continue;
		        	}
		        	
		        	methodName = "set"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
	
	            	if ( "String".equals(fieldType) ) {
		        		value = MapUtil.getString(map, fieldName);
		            	method = clazz.getDeclaredMethod(methodName, stringParam);
		        	} else if ( "BigDecimal".equals(fieldType) ) {
		        		value = MapUtil.getNumber(map, fieldName);
		            	method = clazz.getDeclaredMethod(methodName, numberParam);
		        	} else if ( "Date".equals(fieldType) ) {
		        		value = MapUtil.getDate(map, fieldName);
		            	method = clazz.getDeclaredMethod(methodName, dateParam);
		        	} else {
		        		continue;
		        	}
	            	
	            	if ( value != null) {
	                	method.invoke(obj, value);
	            	}
		        }
		        
	            clazz = clazz.getSuperclass();
	        }
                
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        
        return (T) obj;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void updateObject(Map<String, Object> map, Object obj) {
    	
    	Class clazz = obj.getClass();
	        
        Field[] fields = null;
        
        String fieldName  = null;
        String fieldType  = null;
        String methodName = null;
        Method method     = null;
        
        Class[] stringParam = new Class[] { String.class };
        Class[] numberParam = new Class[] { BigDecimal.class };
        Class[] dateParam   = new Class[] { Date.class };
        
        Object value = null;
        
        try {

            while ( clazz != null ) {
            	
//            	System.out.println("SUPER CLASS : "+clazz.getName());

            	if ( "java.lang.Object".equals(clazz.getName()) ) {
            		break;
            	}
            	
	            fields = clazz.getDeclaredFields();
            
		        for ( Field field : fields ) {
		
		        	fieldType = field.getType().getSimpleName();
		        	fieldName = field.getName();
		
	//	        	if ( !map.containsKey(fieldName) ) {
	//	        		continue;
	//	        	}
		
		        	if ( map.get(fieldName) == null ) {
		        		continue;
		        	}
		        	
		        	methodName = "set"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
	
		        	if ( !map.containsKey(fieldName) ) {
		        		continue;
		        	} else if ( "String".equals(fieldType) ) {
		        		value = MapUtil.getString(map, fieldName);
		            	method = clazz.getDeclaredMethod(methodName, stringParam);
		        	} else if ( "BigDecimal".equals(fieldType) ) {
		        		value = MapUtil.getNumber(map, fieldName);
		            	method = clazz.getDeclaredMethod(methodName, numberParam);
		        	} else if ( "Date".equals(fieldType) ) {
		        		value = MapUtil.getDate(map, fieldName);
		            	method = clazz.getDeclaredMethod(methodName, dateParam);
		        	} else {
		        		continue;
		        	}
	
	            	method.invoke(obj, value);
	
	//            	if ( value != null) {
	//                	method.invoke(obj, value);
	//            	}
		        }
                
	            clazz = clazz.getSuperclass();
	        }

        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }
    
//    @SuppressWarnings({ "unchecked", "rawtypes" })
//    public static void copyObject(Object srcObj, Object tgtObj) {
//    
//    	Class srcClazz = srcObj.getClass();
//    	Class tgtClazz = tgtObj.getClass();
//    	
//        Field[] tgtFields = tgtClazz.getDeclaredFields();
//        Field   srcField  = null;
//        
//        String tgtFieldName  = null;
//        String tgtFieldType  = null;
//        String tgtMethodName = null;
//        
//        Method tgtMethod     = null;
//        Method srcMethod     = null;
//        
//        Class[] stringParam = new Class[] { String.class };
//        Class[] numberParam = new Class[] { BigDecimal.class };
//        Class[] dateParam   = new Class[] { Date.class };
//    	
//        try {
//            
//	        for ( Field tgtField : tgtFields ) {
//	
//	        	tgtFieldType = tgtField.getType().getSimpleName();
//	        	tgtFieldName = tgtField.getName();
//	        	
//	        	try {
//	        		srcField = srcClazz.getDeclaredField(tgtFieldName);
//	        	}catch (NoSuchFieldException e) {
//	        		continue;
//				}
//	        	
//	        	if ( srcField == null ) {
//	        		continue;	
//	        	}
//	        	
//	        	String srcFieldType = srcField.getType().getSimpleName();
//	        	
//	        	if ( !tgtFieldType.equals(srcFieldType) ) {
//	        		continue;
//	        	}
//	        	
//	        	tgtMethodName = tgtFieldName.substring(0, 1).toUpperCase()+tgtFieldName.substring(1);
//
//        		srcMethod = srcClazz.getDeclaredMethod("get"+tgtMethodName, null);
//
//	        	if ( "String".equals(tgtFieldType) ) {
//	        		tgtMethod = tgtClazz.getDeclaredMethod("set"+tgtMethodName, stringParam);
//	        	} else if ( "BigDecimal".equals(tgtFieldType) ) {
//	        		tgtMethod = tgtClazz.getDeclaredMethod("set"+tgtMethodName, numberParam);
//	        	} else if ( "Date".equals(tgtFieldType) ) {
//	        		tgtMethod = tgtClazz.getDeclaredMethod("set"+tgtMethodName, dateParam);
//	        	}
//	        	
//	        	tgtMethod.invoke(tgtObj, srcMethod.invoke(srcObj, null));
//	        }
//	        
//        } catch ( Exception e ) {
//            e.printStackTrace();
//        }
//    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T extends Object> T createObject(Object srcObj, Class clazz) {

		Object tgtObj = null;

    	try {
    		
    		tgtObj = clazz.newInstance();
    		
            copyObject(srcObj, tgtObj);
            
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    	
        return (T) tgtObj;
    }

    @SuppressWarnings("rawtypes")
	public static <T extends Object> List<T> createObjList(List<Map<String, Object>> pList, Class pClazz) {
    	return createObjList(pList, pClazz, false, null);
    }

    @SuppressWarnings("rawtypes")
    public static <T extends Object> List<T> createObjList(List<Map<String, Object>> pList, Class pClazz, boolean pSnakeToCamel) {
    	return createObjList(pList, pClazz, pSnakeToCamel, null);
    }

    @SuppressWarnings("rawtypes")
    public static <T extends Object> List<T> createObjList(List<Map<String, Object>> pList, Class pClazz, Map<String, Object> addMap) {
    	return createObjList(pList, pClazz, false, addMap);
    }

    @SuppressWarnings("rawtypes")
    public static <T extends Object> List<T> createObjList(List<Map<String, Object>> pList, Class pClazz, boolean pSnakeToCamel, Map<String, Object> addMap) {

    	if ( pList == null || pList.size() == 0 ) return null;
    	
    	List<T> returnList = new ArrayList<T>();
    	
    	for ( Map<String, Object> map : pList ) {

    		if ( pSnakeToCamel ) {
    			map = ConvertUtil.snakeMapToCamelMap(map);
    		}

    		if ( addMap != null ) {
    			map.putAll(addMap);
    		}

    		returnList.add(createObject(map, pClazz));
    	}
    	
    	return returnList;
    }
    
    /** list key dictinct */
    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
    
    /** object 복사 - super class 포함 */
    public static <T> T copyObject(Object srcObj, Class<T> clazz) {
    	
    	T obj = null;
    	try {
    		ObjectMapper mapper = new ObjectMapper();
    		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    		
    		obj = mapper.readValue(mapper.writeValueAsString(srcObj), clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return obj;
    }
    
    /** object 복사 list - super class 포함  */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T extends Object> List<T> copyObjList(List<Map<String, Object>> pList, Class pClazz) {
    	if ( pList == null || pList.size() == 0 ) return null;
    	
    	List<T> returnList = new ArrayList<T>();
    	for( Map<String, Object> map : pList ) {
    		returnList.add((T) copyObject(map, pClazz));
    	}
    	return returnList;
    }
    
    @SuppressWarnings("rawtypes")
	public static <T extends Object> List<T> copyObjectList(List srcList, Class clazz) {
    	
    	List<T> returnList = new ArrayList<T>();
    	
    	if ( MapUtil.isNull(srcList) ) return returnList;

    	try {
    		
        	for ( Object srcObj : srcList ) {
        		
        		returnList.add(ObjUtil.copyObject(srcObj, clazz.newInstance()));
        	}

        } catch ( Exception e ) {
            e.printStackTrace();
        }
    	
    	return returnList;
    }	
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T extends Object> T copyObject(Object srcObj, Object tgtObj) {
    
    	Class srcClazz = srcObj.getClass();
    	Class tgtClazz = tgtObj.getClass();
    	
        Field[] tgtFields = tgtClazz.getDeclaredFields();
        Field   srcField  = null;
        
        String tgtFieldName  = null;
        String tgtFieldType  = null;
        String tgtMethodName = null;
        
        Method tgtMethod     = null;
        Method srcMethod     = null;
        
        Class[] stringParam = new Class[] { String.class };
        Class[] numberParam = new Class[] { BigDecimal.class };
        Class[] dateParam   = new Class[] { Date.class };
    	
        try {
            
	        for ( Field tgtField : tgtFields ) {
	
	        	tgtFieldType = tgtField.getType().getSimpleName();
	        	tgtFieldName = tgtField.getName();
	        	
	        	try {
	        		srcField = srcClazz.getDeclaredField(tgtFieldName);
	        	} catch (NoSuchFieldException e) {
	        		continue;
				}
	        	
	        	
	        	if ( srcField == null ) {
	        		continue;	
	        	}
	        	
	        	String srcFieldType = srcField.getType().getSimpleName();
	        	
	        	if ( !tgtFieldType.equals(srcFieldType) ) {
	        		continue;
	        	}
	        	
	        	tgtMethodName = tgtFieldName.substring(0, 1).toUpperCase()+tgtFieldName.substring(1);

        		srcMethod = srcClazz.getDeclaredMethod("get"+tgtMethodName, null);

	        	if ( "String".equals(tgtFieldType) ) {
	        		tgtMethod = tgtClazz.getDeclaredMethod("set"+tgtMethodName, stringParam);
	        	} else if ( "BigDecimal".equals(tgtFieldType) ) {
	        		tgtMethod = tgtClazz.getDeclaredMethod("set"+tgtMethodName, numberParam);
	        	} else if ( "Date".equals(tgtFieldType) ) {
	        		tgtMethod = tgtClazz.getDeclaredMethod("set"+tgtMethodName, dateParam);
	        	}
	        	
	        	tgtMethod.invoke(tgtObj, srcMethod.invoke(srcObj, null));
	        	
	        }
	        
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        
    	return (T) tgtObj;
    }
    
    // Copy bean by the Key as you need
 	@SuppressWarnings("unchecked")
 	public static <T extends Object> T copyObject(Object source, Class returnClazz, String[] keys) {
 		
 		Map<String, Object> sourceMap = new HashMap<>();
 		Map<String, Object> targetMap = new HashMap<>();
 		
 		try {
 			
	 		sourceMap = ObjUtil.copyObject(source, HashMap.class);
	 		targetMap = MapUtil.copyMap(sourceMap, keys);
	 		
	 		
 		} catch(Exception e) {
 			e.printStackTrace();
 		}
 		
 		return (T) ObjUtil.copyObject(targetMap, returnClazz.getClass());
 	};
}
