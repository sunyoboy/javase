/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: ReferenceCountingGC.java
 * Author:   DD240
 * Date:     2015-12-30 上午10:54:16
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.javase.jvm.gc;


/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class ReferenceCountingGC {
   private Object instance = null;
   
   private static final int _MB = 1024 * 1024;
   
   /**
    * 占点内存，以便能在GC日志中看清楚是否被回收过
    */
   
   private byte[] bigSize = new byte[2 * _MB];
   
   public static void testGC() {
       ReferenceCountingGC objA = new ReferenceCountingGC();
       ReferenceCountingGC objB = new ReferenceCountingGC();
       objA.instance = objB;
       objB.instance = objA;
       
       objA = null;
       objB = null;
       
       // objA和objB是否在发生GC能被回收
       System.gc();
   }
   
   public static void main(String[] args) {
       testGC();
   }
}
