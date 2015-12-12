/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: InetAddressTest.java
 * Author:   DD240
 * Date:     2015-12-9 ����7:30:47
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.usual.http;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class InetAddressTest {
    
    @Test
    public void testInetAddress() {
        try {
            System.out.println(" address " + InetAddress.getLocalHost());
            System.out.println(InetAddress.getLoopbackAddress());
            
            InetAddress[] addresses = InetAddress.getAllByName("www.baidu.com");
            for(int i=0; i<addresses.length; i++) {
                System.out.println("address\t" + i + "\t" + addresses[i]);
            }
            
            System.out.println(InetAddress.getByAddress(new byte[] {127,0,0,1}));
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
