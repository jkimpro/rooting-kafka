package com.gsshop.kafka.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Tuple;
import javax.persistence.TupleElement;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogUtil {

	@SuppressWarnings("rawtypes")
	public static void printMap(String title, Map map) {

		Object key = null;
		int    idx = 0;

		if ( !StringUtils.isEmpty(title) ) {
			log.debug("*************************************************************************");
			log.debug("* "+title);
		}
		log.debug("*************************************************************************");

		if (map == null) {
			log.debug("NOTHING TO PRINT");
			return;
		} 

//		for ( Iterator it = map.keySet().iterator(); it.hasNext(); ) {
//			key = it.next();
//			
//			if ( key.toString().startsWith("session") ) {
//				
//				if ( key.toString().endsWith("ChanlCd") ) {
//					log.debug("["+idx+"] "+key+" = "+map.get(key));
//				}
//				
//			} else {
//				log.debug("["+idx+"] "+key+" = "+map.get(key));
//			}
//			idx++;
//		}

		List<String> strList = new ArrayList<String>();
		
		for ( Iterator it = map.keySet().iterator(); it.hasNext(); ) {
			
			key = it.next();
			
			if ( key.toString().startsWith("session") ) {
				
				if ( key.toString().endsWith("ChanlCd") ) {
					strList.add(key+" = "+map.get(key));
				}
				
			} else {
				strList.add(key+" = "+map.get(key));
			}
			idx++;
		}
		
		strList.sort((p1, p2) -> (p1).compareTo(p2));
		
		for ( int i = 0; i < strList.size(); i++ ) {
			log.debug("["+i+"] "+strList.get(i));
		}
		
		log.debug("*************************************************************************");

	}
	
	@SuppressWarnings("rawtypes")
	public static void printTuple(String title, Tuple tuple) {
		
		if ( !StringUtils.isEmpty(title) ) {
			log.debug("*************************************************************************");
			log.debug("* "+title);
		}
		log.debug("*************************************************************************");

		List<TupleElement<?>> list = tuple.getElements();
		
		for ( TupleElement element : list ) {
			
			log.debug(element.getAlias());
		}
		
		log.debug("*************************************************************************");		
	}
	
	@SuppressWarnings("rawtypes")
	public static void printList(String title, List list) {

		log.debug("*************************************************************************");
		log.debug("* "+title);
		log.debug("*************************************************************************");

		if (list == null) {
			log.debug("NOTHING TO PRINT");
			return;
		} 
		
		int maxPrint = 5;
		
		for ( int i = 0 ; i < list.size(); i++ ) {

			if ( i == maxPrint ) break;
			
			Object obj = list.get(i);
			
			if ( obj instanceof Map ) {
				printMap("", (Map)obj);
			} else {
				log.debug(obj.toString());
			}
		}

		log.debug("*************************************************************************");
	}
	
	@SuppressWarnings("rawtypes")
	public static void printSet(String title, Set set) {
		
		printHead(title);
		
		for ( Iterator it = set.iterator(); it.hasNext(); ) {
			log.debug(it.next().toString());
		}
		
		log.debug("*************************************************************************");
	}
	
	public static void printObjList(List<?> objList) {
		
		for ( Object obj : objList ) {
			printObj(obj);
		}
	}
	
	public static void printObj(Object obj) {
		
		printObj("printObject", obj);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void printObj(String title, Object obj) {

		printHead(title);
		
		if ( obj == null ) return;

		log.debug("*************************************************************************");
		log.debug("* "+obj);
		log.debug("*************************************************************************");

        Class clazz = obj.getClass();
        
        Field[] fields = clazz.getDeclaredFields();
        
        String fieldName  = null;
        String methodName = null;
        Method method     = null;
        Object val        = null;
        
        for ( Field field : fields ) {
        	
        	fieldName  = field.getName();

        	if ( "serialVersionUID".equals(fieldName) ) continue;

        	methodName = "get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);

            try {
            	
            	method = clazz.getDeclaredMethod(methodName, null);
            	
            	val = method.invoke(obj, null);
            	
        		log.debug(fieldName + " : " + val);
            	
            } catch ( Exception e ) {
                e.printStackTrace();
            }
        }        
        
		log.debug("*************************************************************************");

	}	
	
	private static SimpleDateFormat sdf14 = new SimpleDateFormat("yyyyMMddHHmmss");

	public static void printSql(String sql, Map<String, Object> pParamMap) {
		
		Set<String> keySet = pParamMap.keySet();
		
		for ( String key : keySet ) {
			
			if ( sql.indexOf(":"+key) == -1 ) continue;
			
			Object obj = pParamMap.get(key);
			
			String val = null;

			if ( obj == null ) 
				
				if ( !key.endsWith("1") && pParamMap.containsKey(key+"1") ) {
					continue;
				}
				
				val = "null";
			if ( obj instanceof String ) {
				val = "'"+obj+"'";
			} else if ( obj instanceof BigDecimal ) {
				val = ""+obj;
			} else if ( obj instanceof Date ) {
				val = "TO_DATE('"+sdf14.format((Date)obj)+"', 'YYYYMMDDHH24MISS')";
			} else {
				
				if ( !key.endsWith("1") && pParamMap.containsKey(key+"1") ) {
					continue;
				}
				
				val = "null";
			}
			
			val += " /* " + key + " */";

//			log.debug(key+" -> "+val);

//			sql = sql.replaceAll("(:"+key + ")$", val);
			sql = sql.replaceAll(":"+key, val);
		}
		
		log.debug("\n"+sql);
	}
	
	private static void printHead(String title) {
		
		log.debug("*************************************************************************");
		log.debug("* "+title);
		log.debug("*************************************************************************");
	}

	private static void printTail() {
		
		log.debug("*************************************************************************");
	}
}
