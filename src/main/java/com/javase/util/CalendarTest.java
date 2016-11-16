/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: CalendarTest.java
 * Author:   DD240
 * Date:     2015-12-11 ����3:23:08
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.javase.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
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
     * ��longת��ΪDate����
     * 1449818459000 ������
     * @see 
     * @since
     */
    @Test
    public void setDate() {
        /*��Java������ֱ����д��������int���͵ģ����ֵķ�Χ�� -2^31 �� 2^31 - 1 �����Χ֮�У���������
        Long.ParseLong(String)�������� string ��������Ϊ�з���ʮ���� long�ͣ��ַ����е��ַ����붼��ʮ�������֡�*/
        Date d = new Date(Long.parseLong("1449818459000"));
        System.out.println("date : " + DateUtil.formatDate(d));
        
     // ���ô� Date �����Ա�ʾ 1970 �� 1 �� 1 �� 00:00:00 GMT �Ժ� time �����ʱ��㡣
        d.setTime(Long.parseLong("1449820209000")); 
        System.out.println("date : " + DateUtil.formatDate(d));
        
     //
        d.setTime(Long.parseLong("1449818459000")); 
        System.out.println("date : " + DateUtil.formatDate(d));
    }
}
