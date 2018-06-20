package com.hfz.userservice.util;


import com.hfz.userservice.exception.MessageException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author youjin
 * @description
 * @since 2018/06/20
 */
public class DateUtil {
    public static final String YYYY = "yyyy";

    public static final String YYYYMM = "yyyyMM";

    public static final String YYYYMMDD = "yyyyMMdd";

    public static final String YYYYMMDD_ = "yyyy-MM-dd";

    public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";

    public static final String yyyyMMddHHmmss_ = "yyyy-MM-dd HH:mm:ss";

    public static final String yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";

    public static final String yyyyMdHms_ = "yyyy-M-d H:m:s";

    public static final String yyMdHms = "yy-M-d H:m:s";

    public static final String yyMM = "yyMM";

    public static final String yyyyMMddHHmm_ = "yyyy-MM-dd HH:mm";

    public static final String HHmm = "HH:mm";

    private static final int DAY = 86400000;

    private static final int HOURS = 3600000;

    private static final int MINUTES = 60000;

    private static final int SECONDS = 1000;

    public static Date stringToDate(String pattern, String date) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            return format.parse(date);
        } catch (ParseException e) {
            throw new MessageException("");
        }
    }

    /**
     * 日期转换为字符串
     *
     * @param pattern
     * @param date
     * @return
     */
    public static String dateToString(String pattern, Date date) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * 计算两个时间相差几小时
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static Double timeDiff(Date beginDate, Date endDate) {
        double hours = (double) (endDate.getTime() - beginDate.getTime()) / 3600 / 1000;
        return hours;
    }

    /**
     * 计算两个时间相差几分钟
     *
     * @param beginDate
     * @param endDate
     * @return
     */

    public static int timeDiff(String beginDate, Date endDate) throws Exception {
        Date bDate = DateUtil.stringToDate(yyyyMMddHHmmss_, beginDate);
        int minutes = (int) ((endDate.getTime() - bDate.getTime()) / 60 / 1000);
        return minutes;
    }

    /**
     * 计算两个时间相差秒钟数
     *
     * @param beginDate
     * @param endDate
     * @return
     */

    public static int timeDiffBySecond(String beginDate, String endDate) throws Exception {
        Date aDate = DateUtil.stringToDate(yyyyMMddHHmmss_, endDate);
        Date bDate = DateUtil.stringToDate(yyyyMMddHHmmss_, beginDate);
        int totalSecond = (int) ((aDate.getTime() - bDate.getTime()) / 1000);
        return totalSecond;
    }

    public static int timeDiffBySecond(Date beginDate, Date endDate) throws Exception {
        int totalSecond = (int) ((endDate.getTime() - beginDate.getTime()) / 1000);
        return totalSecond;
    }

    public static String time2Str(long time) {
        StringBuilder buff = new StringBuilder(32);
        long leftTime = time;
        long count = 0;
        if (leftTime > DAY) {
            count = leftTime / DAY;
            leftTime = leftTime - (count * DAY);
            buff.append(count + "天");
        }
        if (leftTime > HOURS) {
            count = leftTime / HOURS;
            leftTime = leftTime - (count * HOURS);
            buff.append(count + "小时");
        }
        if (leftTime > MINUTES) {
            count = leftTime / MINUTES;
            leftTime = leftTime - (count * MINUTES);
            buff.append(count + "分");
        }
        if (leftTime > SECONDS) {
            count = leftTime / SECONDS;
            buff.append(count + "秒");
        }
        return buff.toString();
    }

    public static String minute2DHS(Long minute) {
        StringBuffer buff = new StringBuffer(32);
        long leftTime = minute;
        long count = 0;
        if (leftTime > 60 * 24) {
            count = leftTime / (60 * 24);
            leftTime = leftTime - (count * (60 * 24));
            buff.append(count + "天");
        }
        if (leftTime > 60) {
            count = leftTime / 60;
            leftTime = leftTime - (count * 60);
            buff.append(count + "小时");
        }
        if (leftTime >= 0) {
            buff.append(leftTime + "分钟");
        }
        return buff.toString();
    }

    /**
     * 两个日期相差天数，严格按照时分秒计算
     *
     * @param fDate 开始日期
     * @param oDate 结束日期
     * @return
     */
    public static int getIntervalDays(Date fDate, Date oDate) {
        if (null == fDate || null == oDate) {
            return -1;
        }
        long intervalMilli = oDate.getTime() - fDate.getTime();
        return (int) (intervalMilli / (24 * 60 * 60 * 1000));
    }

    /**
     * 两个日期相差天数，仅按照日期计算
     *
     * @param fDate 开始日期
     * @param oDate 结束日期
     * @return
     */
    public static int daysOfTwo(Date fDate, Date oDate) {
        Calendar aCalendar = Calendar.getInstance();
        aCalendar.setTime(fDate);
        int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
        aCalendar.setTime(oDate);
        int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
        return day2 - day1;
    }

    /**
     * 获取一个时间的第二天零点零分零秒
     *
     * @param date
     * @return
     */
    public static Date nextWeeHours(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    /**
     * 获取当前时间的零点零分零秒
     *
     * @param date
     * @return
     */
    public static Date currentWeeHours(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取前一天的23点59分59秒
     *
     * @param date
     * @return
     */
    public static Date preDayLastHours(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, -1);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 根据某个日期 获取该日期所在周的所有日期
     *
     * @param date yyyy-MM-dd
     * @return 从星期一开始到星期天
     * @author By lwq
     */
    public static List<String> getDatesForWeek(String date) {
        List<String> list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        if (date != null && !date.isEmpty()) {
            Date time = null;
            try {
                time = sdf.parse(date);
            } catch (ParseException e) {
                time = null;
            }
            cal.setTime(time);
        }
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 从星期天开始为1~周六7
        if (dayWeek == 1) {
            cal.add(Calendar.DATE, -7);
            for (int i = 1; i <= 7; i++) {
                cal.add(Calendar.DATE, 1);
                list.add(sdf.format(cal.getTime()));
            }
        } else {
            cal.add(Calendar.DATE, -(6 - (7 - dayWeek)));
            for (int i = 1; i <= 7; i++) {
                cal.add(Calendar.DATE, 1);
                list.add(sdf.format(cal.getTime()));
            }
        }
        return list;
    }

    /**
     * 获取一周日期（默认当前日期的一周日期）
     *
     * @return
     */
    public static List<String> getDatesForWeek() {
        List<String> list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 从星期天开始为1~周六7
        if (dayWeek == 1) {
            cal.add(Calendar.DATE, -7);
            for (int i = 1; i <= 7; i++) {
                cal.add(Calendar.DATE, 1);
                list.add(sdf.format(cal.getTime()));
            }
        } else {
            cal.add(Calendar.DATE, -(6 - (7 - dayWeek)));
            for (int i = 1; i <= 7; i++) {
                cal.add(Calendar.DATE, 1);
                list.add(sdf.format(cal.getTime()));
            }
        }
        return list;
    }

    /**
     * 根据日期获取该日期属于星期几
     *
     * @param date 日期
     * @return
     */
    public static int getDayOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * 根据传入的日期段 获取该日期段内的所有日期
     *
     * @param startDate endDate
     *                  yyyy-MM-dd
     * @return 从起始日期开始到终止日期
     * @author
     */
    public static List<String> getDatesForDays(String startDate, String endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<String> list = new ArrayList<String>(); //保存日期集合
        try {
            Date date_start = sdf.parse(startDate);
            Date date_end = sdf.parse(endDate);
            Date date = date_start;
            Calendar cd = Calendar.getInstance();//用Calendar 进行日期比较判断
            while (date.getTime() <= date_end.getTime()) {
                list.add(sdf.format(date));
                cd.setTime(date);
                cd.add(Calendar.DATE, 1);//增加一天 放入集合
                date = cd.getTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }

    //出生日期字符串转化成Date对象
    public Date parse(String strDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(strDate);
    }

    /**
     * @Description:由出生日期获得年龄
     * @Param:[birthDay, nowDate] 出生日期 现在的日期
     * @return:int
     */
    public static int getAge(Date birthDay, Date nowDate) {
        int age = 0;
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(nowDate);
            if (cal.before(birthDay)) {
                throw new IllegalArgumentException(
                        "The birthDay is before Now.It's unbelievable!");
            }
            int yearNow = cal.get(Calendar.YEAR);
            int monthNow = cal.get(Calendar.MONTH);
            int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
            cal.setTime(birthDay);

            int yearBirth = cal.get(Calendar.YEAR);
            int monthBirth = cal.get(Calendar.MONTH);
            int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

            age = yearNow - yearBirth;

            if (monthNow <= monthBirth) {
                if (monthNow == monthBirth) {
                    if (dayOfMonthNow < dayOfMonthBirth){
                        age--;
                    }
                } else {
                    age--;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return age;
    }
}
