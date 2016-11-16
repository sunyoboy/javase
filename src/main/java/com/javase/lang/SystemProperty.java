/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: SystemProperty.java
 * Author:   DD240
 * Date:     2015-12-23 ����6:34:52
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.javase.lang;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class SystemProperty {

    public static void main(String[] args) {
        String separator = System.getProperty("line.separator");
        if(separator.indexOf("\r") > 0) {
            System.out.print("\r");
        }
        
        if(separator.indexOf("\n") > 0) {
            System.out.print("\n");
        }
        
        System.out.println(separator.indexOf("\r"));
        System.out.println(separator.indexOf("\n"));
        System.out.println("line.separator�ĳ���: " + separator.length());
        
        
        if(separator.equals("\r\n")) {
            System.out.println("line.separator : \\r\\n");
        }
        
        try {
            System.out.println(URLDecoder.decode("java%E7%BD%91%E7%BB%9C%E7%BC%96%E7%A8%8B%E7%B2%BE%E8%A7%A3%E3%80%80%E6%BA%90%E4%BB%A3%E7%A0%81", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
