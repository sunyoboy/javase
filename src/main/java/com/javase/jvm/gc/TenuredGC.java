/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: TenuredGC.java
 * Author:   DD240
 * Date:     2015-12-30 上午11:28:03
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.javase.jvm.gc;

/**
 * VM Args -XX:PretenureSizeThreshold = 3145728
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class TenuredGC {
    private static final int _MB = 1024 * 1024;

    public static void  testPretenureSizeThreshold() {
        byte[]  allocation;
        allocation = new byte[4 * _MB]; // 直接分配到老年代中
    }
    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }
}
