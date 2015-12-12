/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: ReflectDemo3.java
 * Author:   DD240
 * Date:     2015-11-30 ����10:10:16
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.usual.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * ȡ���캯�������η�<br> 
 * ��������ϸ������
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class ReflectDemo3 {
    public static void main(String[] args) {
        Class<?> c1 = null;
        try {
            c1 = Class.forName("com.usual.reflect.Person");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        Constructor<?> cons[] = c1.getConstructors();
        
        for(int i=0; i<cons.length; i++) {
            Class<?> parameter[] = cons[i].getParameterTypes();
            
            System.out.println(cons[i].getModifiers());
            System.out.println("���캯�����η� �� " + Modifier.toString(cons[i].getModifiers()));
            
            System.out.println(cons[i].getName()); // ���캯����
            System.out.println(cons[i].toString()); // ���캯��"����"
            System.out.println(cons[i].DECLARED); //
            System.out.println(cons[i].PUBLIC); // 
            System.out.println();            
        }
        
        
    }
}
