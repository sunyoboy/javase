/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: DateUtil.java
 * Author:   DD240
 * Date:     2015-12-10 下午3:55:23
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.javase.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将指定的日期转换为Cron表达式
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class DateUtil {
    
    private final static SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
    
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
