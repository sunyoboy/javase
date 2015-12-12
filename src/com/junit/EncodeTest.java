/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: EncodeTest.java
 * Author:   DD240
 * Date:     2015-11-10 ����2:26:05
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.junit;

import java.io.File;
import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Test;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class EncodeTest {

    @Test
    public void testName() {
        File f = new File("E:/tmp/�廪��Сѡ��������-2M.mp4");
        Assert.assertEquals("�廪��Сѡ��������-2M.mp4", f.getName());
        try {
            System.out.println(new String(f.getName().getBytes("GBK"), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
}
