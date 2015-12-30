/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: OOMObject.java
 * Author:   DD240
 * Date:     2015-12-29 下午4:57:06
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.javase.jvm.mem;

/**
 * VM Args : -Xss128k
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class JavaVMStackSOF {
    
    private int stackLength = 1;
    
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }
    
    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom  = new JavaVMStackSOF();
            try {
                oom.stackLeak();
            } catch (Throwable e) {
                System.out.println("stack length : " + oom.stackLength);
                throw e;
            }
    }
}
