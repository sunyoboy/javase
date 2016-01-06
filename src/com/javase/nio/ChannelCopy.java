/*
 * Copyright (C), 2002-2016, �������Ͷ���������޹�˾
 * FileName: ChannelCopy.java
 * Author:   DD240
 * Date:     2016-1-6 ����3:03:38
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.javase.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class ChannelCopy {
    
    @Test
    public void copy() {
        try {
            FileChannel fcIn = new FileInputStream("readme.txt").getChannel();
            FileChannel fcOut = new FileOutputStream("read.txt").getChannel();
            
            ByteBuffer buffer = ByteBuffer.allocate(GetChannel.BUFFER_SIZE);
            while(fcIn.read(buffer) != -1) {
                buffer.flip(); // prepare to writing
                fcOut.write(buffer);
                buffer.clear(); // prepare to reading
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
