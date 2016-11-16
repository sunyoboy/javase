/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: DateUtil.java
 * Author:   DD240
 * Date:     2015-12-10 ����3:55:23
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.javase.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ��ָ��������ת��ΪCron���ʽ
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class DateUtil {
    
    private final static SimpleDateFormat format = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
    
    public static String getCronExpression(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("s m H dd M ? yyyy");
        return sdf.format(date);
    }
    
    public static Date parse(String dateStr){
        try {
            return format.parse(dateStr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static String formatDate(Date date) {
        return format.format(date);
    }
    
}
