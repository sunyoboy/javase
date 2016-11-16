/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: InheritingExceptions.java
 * Author:   DD240
 * Date:     2015-12-30 ����10:11:57
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