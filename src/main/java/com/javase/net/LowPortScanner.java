/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: LowPortScanner.java
 * Author:   DD240
 * Date:     2015-12-23 ����11:01:51
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.javase.net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class LowPortScanner {
    public static void main(String[] args) {
        String host = "192.168.8.83";
        
        if(args.length > 0) {
            host = args[0];
        }
        Socket s = null;
        for (int i = 1; i < 1024; i++) {
            try {
                s = new Socket(host, i);
                System.out.println("There is a server on port " + i + " "+ host);
            } catch (UnknownHostException ex) {
                System.err.println(ex);
                break;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
