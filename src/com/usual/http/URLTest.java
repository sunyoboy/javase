/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: URLTest.java
 * Author:   DD240
 * Date:     2015-12-9 ����6:51:56
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.usual.http;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class URLTest {
    
    public static final int BUF_LEN = 1024;
    
    public static void main(String[] args) throws IOException {
        // testTwo();
        // testThree();
        // testFour();
        testFive();
    }
    
    public static void testOne() {
        try {
            URL url = new URL("http://www.baidu.com");
            System.out.println(url.getContent().getClass().getName());
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
    }
    
    /* ��ȡURLָ������Դ */
    public static void testTwo() throws IOException {
        InputStream is = null;
        try {
            URL url = new URL("http://localhost:8080/message/form.jsp");
            URLConnection conn = url.openConnection();
            is = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            char[] cbuf = new char[BUF_LEN];
            while(reader.read(cbuf) > 0) {
                String str = new String(cbuf);
                System.out.println(str);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            is.close();
        }
        
    }
    
    /* ��һ�ַ�ʽ��ȡURLָ�������� */
    public static void testThree() {
        try {
            URL url = new URL("http://localhost:8080/message/form.jsp");
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            int c;
            while((c = is.read()) != -1) {
                // System.out.print((char)c); // ��������
                System.out.print(c);
            }
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }
    
    public static void testFour() {
        try {
            URL url = new URL("http://localhost:8080/message/form.jsp");
            long startTime = System.currentTimeMillis();
            Reader reader = new InputStreamReader(new BufferedInputStream(url.openStream()));
            // Reader reader = new InputStreamReader(url.openStream());
            
            int c;
            while((c = reader.read()) != -1) {
                System.out.print((char)c);
            }
            long endTime = System.currentTimeMillis();
            System.out.println(" cost time : " + (endTime - startTime) + "ms");
            
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }
    
    public static void testFive() {
        try {
            URL url = new URL("http://localhost:8080/message/form.jsp");
            long startTime = System.currentTimeMillis();
            InputStream is = url.openStream();
            // Reader reader = new InputStreamReader(url.openStream());
            
            int c;
            while((c = is.read()) != -1) {
                System.out.print((char)c);
            }
            is.close();
            long endTime = System.currentTimeMillis();
            System.out.println(" cost time : " + (endTime - startTime) + "ms");
            
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }    
}
