/*
 * Copyright (C), 2002-2016, �������Ͷ���������޹�˾
 * FileName: TransferTo.java
 * Author:   DD240
 * Date:     2016-1-6 ����3:09:31
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
import java.nio.channels.FileChannel;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class TransferTo {
    
    public static void main(String[] args) {
        try {
            FileChannel fcIn = new FileInputStream("readme.txt").getChannel();
            FileChannel fcOut = new FileOutputStream("me.txt").getChannel();
            fcIn.transferTo(0, fcIn.size(), fcOut);
            
            // or :
            // fcOut.transferFrom(fcIn, 0, fcIn.size());
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
