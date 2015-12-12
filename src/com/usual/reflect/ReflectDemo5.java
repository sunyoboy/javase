/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: ReflectDemo5.java
 * Author:   DD240
 * Date:     2015-11-30 ����10:41:16
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.usual.reflect;

import java.lang.reflect.Field;

/**
 * ��ȡ��Ա����
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class ReflectDemo5 {
    public static void main(String[] args) {
        Class<?> c1 = null;
        try {
            c1 = Class.forName("java.lang.String"); // ����ʱ������
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        Field fields[] = c1.getDeclaredFields();
        System.out.println("===============��������================");
        for(int i=0; i<fields.length; i++) {
            System.out.println(fields[i].getName());
        }
        
        Field fields1[] = c1.getFields();
        System.out.println("===============�̳нӿڻ��������================");
        for(int i=0; i<fields1.length; i++) {
            System.out.println(fields1[i].getName());
        }
        
    }
}
