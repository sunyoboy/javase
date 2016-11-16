/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: MyException.java
 * Author:   DD240
 * Date:     2015-12-30 ����10:17:59
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.javase.lang;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
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