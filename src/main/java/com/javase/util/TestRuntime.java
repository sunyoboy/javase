/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: TestRuntime.java
 * Author:   DD240
 * Date:     2015-10-30 下午5:09:26
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.javase.util;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */

public class TestRuntime {

    public static void main(String[] args) {
        List l;
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.availableProcessors());
        System.out.println(TestRuntime.getMemByMB(runtime.totalMemory()));
        System.out.println(TestRuntime.getMemByMB(runtime.maxMemory()));
    }
    
    public static long getMemByMB(long aByte) {
        return (aByte / 1024L) / 1024L;
    }
}
