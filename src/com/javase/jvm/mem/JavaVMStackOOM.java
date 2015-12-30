/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: JavaVMStackOOM.java
 * Author:   DD240
 * Date:     2015-12-29 下午5:38:10
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.javase.jvm.mem;

/**
 * VM Args : -Xss2M
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class JavaVMStackOOM {

    private void dontStop() {
        while(true) {
            
        }
    }
    
    public void stackLeakByThread() {
        while(true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }
    
    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }

}

/**
    console :
Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread
    at java.lang.Thread.start0(Native Method)
    at java.lang.Thread.start(Thread.java:714)
    at com.javase.jvm.JavaVMStackOOM.stackLeakByThread(JavaVMStackOOM.java:35)
    at com.javase.jvm.JavaVMStackOOM.main(JavaVMStackOOM.java:41)
*/
