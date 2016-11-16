/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: ExceptionTest.java
 * Author:   DD240
 * Date:     2015-12-29 ����11:01:55
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.javase.lang;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class ExceptionTest {
    private Logger logger = Logger.getLogger(ExceptionTest.class);
    
    @Test
    public void test() {
        BufferedReader br = null;
        try {
            logger.debug("load file a.txt");
            br = new BufferedReader(new InputStreamReader(new FileInputStream("a.txt")));
            
        } catch (FileNotFoundException e1) {
            // logger.debug(e1.fillInStackTrace());
            System.out.println("msg :" + e1);
            logger.debug("message1 : ", e1.getCause());
            logger.debug("message : " + e1.getMessage(), e1.getCause());
            logger.debug("FileNotFoundException ", e1);
            e1.printStackTrace();
        }
        String inputLine = null;
        try {
            br.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Read:" + inputLine);        
    }
}
