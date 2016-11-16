/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: MyException.java
 * Author:   DD240
 * Date:     2015-12-30 上午10:17:59
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.javase.lang;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class FullConstructors {
    
    public static void f() throws MyException {
        System.out.println(" Throwing MyException from f() ");
        throw new MyException();
    }
    
    public static void g() throws MyException {
        System.out.println(" Throwing MyException from g() ");
        throw new MyException("Originated in g()");
    }
    
    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e1) {
            e1.printStackTrace(System.out);
        }
        
        try {
            g();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
    }
}

class MyException extends Exception {
    
    public MyException() {
        
    }
    
    public MyException(String message) {
        super(message);
    }    
}