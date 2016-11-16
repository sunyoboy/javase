/*
 * Copyright (C), 2002-2016, �������Ͷ���������޹�˾
 * FileName: LargeMappedFiles.java
 * Author: DD240
 * Date: 2016-1-6 ����3:52:21
 * Description: //ģ��Ŀ�ġ���������
 * History: //�޸ļ�¼
 * <author> sunlj <time> <version> <desc>
 * �޸������� �޸����� �汾�� ����
 */
package com.javase.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

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
public class LargeMappedFiles {

    private Logger logger = Logger.getLogger(LargeMappedFiles.class);

    private static List<Integer> list = new ArrayList<Integer>();
    
    @Test
    public void map() {
        try {
            FileChannel fc = new RandomAccessFile("read.txt", "rw")
                    .getChannel();
            MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0,
                    fc.size());
            for (int i = 0; i < fc.size(); i++) {
                out.put((byte) 'x');
            }

            logger.debug("Finished Writing ");
            for (int i = (int) fc.size() / 2; i < fc.size() / 2 + 6; i++) {
                logger.debug((char) out.get(i));
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    public void changeFile() {
        try {
            FileChannel fc = new RandomAccessFile("channel.ini", "rw").getChannel();
            MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0,
                    fc.size());
            for(int i=0; i< fc.size(); i++) {
                if('#' == (char)out.get(i)) {
                    list.add(i);
                }
                System.out.print((char)out.get(i));
            }
            
            out.put((byte)'\0');
           
            System.out.println(list);
            System.out.println();
/*            for (int i = 0; i < fc.size(); i++) {
                out.put((byte) 'x');
            }*/
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
/*    @Test
    public void changeFile() {
        try {
            FileChannel fc = new RandomAccessFile("channel.ini", "rw").getChannel();
            MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0,
                    fc.size());
            for(int i=0; i< fc.size(); i++) {
                if((byte)'\0'== out.get(i) || '#' == out.get(i) ) {
                    list.add(i);
                }
                System.out.print((char)out.get(i));
            }
            
            out.put((byte)'#');
           
            System.out.println(list);
            System.out.println();
            for (int i = 0; i < fc.size(); i++) {
                out.put((byte) 'x');
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }    */
    
}
