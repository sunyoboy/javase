/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: ReflectTest.java
 * Author:   DD240
 * Date:     2015-11-30 ����9:04:04
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.usual.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class ReflectTest {
    /**
     * ��������: <br>
     * ��������ϸ������
     *
     * @param args
     * @see 
     * @since 
     */
    /**
     * ��������: <br>
     * ��������ϸ������
     *
     * @param args
     * @see 
     * @since 
     */
    /**
     * ��������: <br>
     * ��������ϸ������
     *
     * @param args
     * @see 
     * @since 
     */
    public static void main(String[] args) {
        String d1 = Demo.class.getName();
        System.out.println(d1);
        
        Demo demo = new Demo();
        String d2 = demo.getClass().getName();
        
        System.out.println(d2);
        
        System.out.print("Demo.class == demo.getClass() : " + Demo.class + " :");
        System.out.println(Demo.class == demo.getClass());
        
        System.out.println(Demo.class.toString());
        
        InputStream is = demo.getClass().getResourceAsStream("config.properties");
        Properties prop = new Properties();
        try {
            prop.load(is);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println(prop.getProperty("age"));
        
    }
}

class Demo {
    
}
