/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: InheritingExceptions.java
 * Author:   DD240
 * Date:     2015-12-30 上午10:11:57
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
public class InheritingExceptions {
    
    public void f() throws SimpleException {
        System.out.println(" Throw SimpleException from f() ");
        throw new SimpleException();
    }
    
    public static void main(String[] args) {
        InheritingExceptions sed = new InheritingExceptions();
        
        try {
            sed.f();
        } catch (SimpleException e) {
            System.out.println("catch it");
            e.printStackTrace();
        }
    }
}

class SimpleException extends Exception {
    
}