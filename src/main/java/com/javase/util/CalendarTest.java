/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: CalendarTest.java
 * Author:   DD240
 * Date:     2015-12-11 下午3:23:08
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.javase.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class CalendarTest {
    
    @Test
    public void setCalendar() {
        Calendar calendar = new GregorianCalendar();
        System.out.println(" " + calendar.getTime().getTime());
        System.out.println("date : " + DateUtil.formatDate(calendar.getTime()));
    }
    
    /**
     * 由long转换为Date类型
     * 1449818459000 毫秒数
     * @see 
     * @since
     */
    @Test
    public void setDate() {
        /*在Java代码中直接书写的数字是int类型的，数字的范围在 -2^31 到 2^31 - 1 这个范围之中，超出报错
        Long.ParseLong(String)方法，将 string 参数解析为有符号十进制 long型，字符串中的字符必须都是十进制数字。*/
        Date d = new Date(Long.parseLong("1449818459000"));
        System.out.println("date : " + DateUtil.formatDate(d));
        
     // 设置此 Date 对象，以表示 1970 年 1 月 1 日 00:00:00 GMT 以后 time 毫秒的时间点。
        d.setTime(Long.parseLong("1449820209000")); 
        System.out.println("date : " + DateUtil.formatDate(d));
        
     //
        d.setTime(Long.parseLong("1449818459000")); 
        System.out.println("date : " + DateUtil.formatDate(d));
    }
}
