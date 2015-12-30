/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: BadThread.java
 * Author:   DD240
 * Date:     2015-12-23 下午4:26:12
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.javase.util.concurrent;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class BadThread {

    static String message;

    private static class CorrectorThread
        extends Thread {

        public void run() {
            try {
                sleep(1000); 
            } catch (InterruptedException e) {}
            // Key statement 1:
            message = "Mares do eat oats."; 
        }
    }

    public static void main(String args[])
        throws InterruptedException {

        (new CorrectorThread()).start();
        message = "Mares do not eat oats.";
        Thread.sleep(2000);
        // Key statement 2:
        System.out.println(message);
    }
}
