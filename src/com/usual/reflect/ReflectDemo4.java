/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: ReflectDemo4.java
 * Author:   DD240
 * Date:     2015-11-30 ����10:22:51
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.usual.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ��ȡ��ķ���ֵ���� �ͷ����б�
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class ReflectDemo4 {
    public static void main(String[] args) {
        Class<?> c1 = null;
        try {
            c1 = Class.forName("java.lang.String"); // ����ʱ������
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println("c1 simple name -> " + c1.getSimpleName());
        
        
        Method methods[] = c1.getMethods();
        
        for(int j=0; j<methods.length; j++) {
            System.out.print("Method[" + j + "]-> " + methods[j]); // ��ȡString��ķ����б�
            System.out.print(" returnType -> " + methods[j].getReturnType());
            System.out.println(" parameterType -> " + methods[j].getParameterTypes().toString());
            
            // System.out.println();
            
            
        }
        
        String substr = null;
        try {
                substr = (String)methods[49].invoke("String", new Object[]{1});
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println(substr);
        
        
    }
}
