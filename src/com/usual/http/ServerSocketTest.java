/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: ServerSocketTest.java
 * Author:   DD240
 * Date:     2015-12-9 ����7:48:19
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.usual.http;

import java.io.IOException;
import java.net.ServerSocket;

import org.junit.Test;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class ServerSocketTest {
    
    @Test
    public void testServerSocket() {
        try {
            ServerSocket serverSocket = new ServerSocket(8089);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
