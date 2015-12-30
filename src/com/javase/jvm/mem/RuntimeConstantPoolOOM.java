/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: RuntimeConstantPoolOOM.java
 * Author:   DD240
 * Date:     2015-12-29 下午5:47:56
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.javase.jvm.mem;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class RuntimeConstantPoolOOM {

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param args
     * @see 
     * @since 
     */
    public static void main(String[] args) {
        // 使用List保持着常量池的引用，避免Full GC回收常量池行为
        List<String> list = new ArrayList<String>();
        // 10M 的PermSize在Integer范围内足够产生OOM了
        int i = 0;
        while(true) {
            
            list.add(("abccef" + i++ ).intern());
            System.out.println(" " + ("abccef" + i++ ));
        }
    }

}
/* jdk1.7.0_75
abccef7561171
abccef7561173
abccef7561175
Exception in thread "RMI TCP Connection(idle)" java.lang.OutOfMemoryError: Java heap space
Exception in thread "RMI TCP Connection(idle)" java.lang.OutOfMemoryError: Java heap space*/

/*  jdk1.6.0_45     abccef470309
Exception in thread "main" java.lang.OutOfMemoryError: PermGen space
   at java.lang.String.intern(Native Method)
   at com.javase.jvm.RuntimeConstantPoolOOM.main(RuntimeConstantPoolOOM.java:39)*/