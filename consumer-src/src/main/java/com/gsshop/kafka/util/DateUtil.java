package com.gsshop.kafka.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	private static SimpleDateFormat sdfEAI = new SimpleDateFormat("yyyyMMdd HH:mm:ss");

	private static SimpleDateFormat sdfFull = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private static SimpleDateFormat sdf14 = new SimpleDateFormat("yyyyMMddHHmmss");

	private static SimpleDateFormat sdf10 = new SimpleDateFormat("yyyy-MM-dd");

	private static SimpleDateFormat sdf8 = new SimpleDateFormat("yyyyMMdd");
	
	private static SimpleDateFormat sdf6 = new SimpleDateFormat("yyyyMM");

	private static SimpleDateFormat sdf5 = new SimpleDateFormat("MM/dd");
	
	private static SimpleDateFormat sdf4 = new SimpleDateFormat("yyMM");
	
	private static SimpleDateFormat sdfTime = new SimpleDateFormat("HHmmss");

	public static Calendar getCalendar() {
        return Calendar.getInstance(java.util.Locale.KOREA);
    }

    /**
     * 입력된 일자를 Calendar 객체로 반환한다.
     *
     * @param year 년
     * @param month  월
     * @param date 일
     * @return 해당일자에 해당하는 Calendar
     */
    public static Calendar getCalendar(int year, int month, int date) {
        return getCalendar(year, month, date, 0, 0, 0);
    }

    /**
     * 입력된 정보를 Calendar 객체로 반환한다.
     *
     * @param year 년
     * @param month 월
     * @param date 일
     * @param hour 시
     * @param minute 분
     * @return 해당일자에 해당하는 Calendar
     */
    public static Calendar getCalendar(int year, int month, int date, int hour, int minute) {
        return getCalendar(year, month, date, hour, minute, 0);
    }

    /**
     * 입력된 정보를 Calendar 객체로 반환한다.
     *
     * @param year 년
     * @param month 월
     * @param date 일
     * @param hour 시
     * @param minute 분
     * @param second 초
     * @return 해당일자에 해당하는 Calendar
     */
    public static Calendar getCalendar(int year, int month, int date, int hour, int minute, int second) {
        Calendar calendar = getCalendar();
        calendar.set(year, month - 1, date, hour, minute, second);
        return calendar;
    }
    
    /**
     * 현재 일자를 Date 객체로 반환한다.
     *
     * @return 현재 일자에 해당하는 Date
     */
    public static Date getDate() {
        return getCalendar().getTime();
    }
    
	public static Date getDate(String val) {
		
		if ( "now".equals(val) ) {
			return Calendar.getInstance().getTime();
		}
		
		try {
			if ( val.trim().length() == 14 ) {
				return new Date(sdf14.parse(val).getTime());
			} else if ( val.trim().length() == 8 ) {
				return new Date(sdf8.parse(val).getTime());
			} else if ( val.trim().length() == 10 && val.indexOf("-") > -1 ) {
				return new Date(sdf10.parse(val).getTime());
			} else if ( val.trim().length() == 19 ) {
				return new Date(sdfFull.parse(val).getTime());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
	
	public static String getYYYYMMDD_HH24_MI_SS(Date date) {
		
		if ( date == null ) return "";
		
		return sdfEAI.format(date);
	}
	
	public static String getYYYYMMDDHH24MISS(Date date) {
		
		if ( date == null ) return "";
		
		return sdf14.format(date);
	}

	public static String getYYYYMMDD(Date date) {
		
		if ( date == null ) return "";
		
		return sdf8.format(date);
	}

	public static String getYYYY_MM_DD(Date date) {
		
		if ( date == null ) return "";
		
		return sdf10.format(date);
	}
	
	public static String getMM_DD(Date date) {
		
		if ( date == null ) return "";
		
		return sdf5.format(date);
	}
	
	public static String getYYYYMM(Date date) {
		if ( date == null ) return "";
		
		return sdf6.format(date);
	}
	
	public static String getYYYY_MM_DD_HH24_MI_SS(Date date) {
		
		if ( date == null ) return "";
		
		return sdfFull.format(date);
	}
	
	public static String getHH24MISS(Date date) {
		if ( date == null ) return "";
		
		return sdfTime.format(date);
	}
	
	public static String getYYMM(Date date) {
		if ( date == null ) return "";
		
		return sdf4.format(date);
	}
	

//	public static Date getAddDayDate(String val, int day) {
//		
//		Date date = getDate(val);
//		
//		Calendar cal = Calendar.getInstance();
//		
//		cal.setTime(date);
//
//		cal.add(Calendar.DATE, day);
//		
//		return cal.getTime();
//	}	
	
	public static Date getAddMonthDate(String val, int month) {
		
		Date date = getDate(val);
		
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(date);

		cal.add(Calendar.MONTH, month);
		
		return cal.getTime();
	}	

	public static Date getAddYearDate(String val, int year) {
		
		Date date = getDate(val);

		String yyyymmdd = sdf8.format(date);
		
		try {
			date = (Date)sdf8.parse(yyyymmdd);
		} catch (Exception e) {}
		
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(date);

		cal.add(Calendar.YEAR, year);
		
		return cal.getTime();
	}	
	
	public static Date[] getValidDtm() {

		long now = System.currentTimeMillis();
		
		Date[] validDate = new Date[2];
		
		validDate[0] = new Date(now-1); // validStrDtm
		validDate[1] = new Date(now+1); // validEndDtm

		return validDate;
	}
	
	public static Date getTomorrow() {

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, 1);
		
		try {
			return sdf8.parse(sdf8.format(cal.getTime()));
		} catch (Exception e) {}
		
		return null;
	}

	public static Date getToday() {

		Calendar cal = Calendar.getInstance();
		
		try {
			return sdf8.parse(sdf8.format(cal.getTime()));
		} catch (Exception e) {}
		
		return null;
	}
	
	public static Date getMaxDate() {
		try {
			return sdf8.parse("99991231");
		} catch (Exception e) {}
		
		return null;
	}
	
	public static boolean isBetween(Date stdDate, Date strDate, Date endDate) {

		if ( stdDate == null ) {
			return false;
		}
		
		if ( stdDate.compareTo(strDate) >= 0 && stdDate.compareTo(endDate) <= 0 ) {
			return true;
		}
		
		return false;
	}
	
	public static Date pushDate(Date date, long millisec) {
		
		return new Date(date.getTime() + millisec);
	}
	
	/**
     * 두 날짜 사이 차이를 반환한다.
     *
     * @param Date
     *            date1 //과거
     * @param Date
     *            date2 //미래
     * @return int
     */
    public static int dateDiff(Date date1, Date date2) {
        return (int) ((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24));
    }

	public static String getWeekOfYear(Date date) {
		
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(date);
		
		int dayOfWeek  = cal.get(Calendar.DAY_OF_WEEK); // 1 : 일요일
		int weekOfYear = cal.get(Calendar.WEEK_OF_YEAR);
		
		if ( dayOfWeek == 1 ) weekOfYear--;
		
		if ( weekOfYear == 0 ) weekOfYear = 52;
		
		String week = Integer.toString(weekOfYear);
		
		if ( week.length() == 1 ) {
			week = "0"+week;
		}
		
		return week;
	}
	
	public static Date getSunday(Date date) {
		
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(date);
		
		int dayOfWeek  = cal.get(Calendar.DAY_OF_WEEK); // 1 : 일요일

		int minusDay = 0;
		
		if ( dayOfWeek == 1 ) {
			minusDay = 6;
		} else {
			minusDay = dayOfWeek - 2;
		}

		cal.add(Calendar.DATE, -1 * minusDay);
		
		return cal.getTime();
	}
	
	public static Date getSaturday(Date date) {
	
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(getSunday(date));

		cal.add(Calendar.DATE, +6);

		return cal.getTime();
	}	
	
	public static Date getTruncDay(Date date) {
		
		if ( date == null ) return null;
		
		String date8 = getYYYYMMDD(date);
		
		return getDate(date8);
	}
	
	public static boolean isChanged(Date srcDate, Date tgtDate) {
		
		if ( srcDate == null && tgtDate == null ) return false; 

		if ( srcDate == null || tgtDate == null ) return true; 

		String srcStr = getYYYYMMDDHH24MISS(srcDate);
		String tgtStr = getYYYYMMDDHH24MISS(tgtDate);
		
		if ( srcStr.equals(tgtStr) ) {
			return false;
		}
		
		return true;
	}
	
	public static int getDayOfWeek(Date date) {
		Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	     
	    int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1 : 일요일
	    
	    return dayOfWeek;
	}
	
}
