/*
 * Copyright (C), 2002-2016, �������Ͷ���������޹�˾
 * FileName: GetChannel.java
 * Author: DD240
 * Date: 2016-1-6 ����2:25:29
 * Description: //ģ��Ŀ�ġ���������
 * History: //�޸ļ�¼
 * <author> sunlj <time> <version> <desc>
 * �޸������� �޸����� �汾�� ����
 */
package com.javase.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

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
public class GetChannel {

    private Logger logger = Logger.getLogger("GetChannel");
    public static final int BUFFER_SIZE = 1024;

    /*
     * public static void main(String[] args) {
     * }
     */

    /*
     * @Test
     * public void write() {
     * // write to a file
     * try {
     * FileChannel fc = new FileOutputStream("readme.txt").getChannel();
     * fc.write(ByteBuffer.wrap("you must read me".getBytes()));
     * fc.close();
     * } catch (FileNotFoundException e) {
     * // TODO Auto-generated catch block
     * e.printStackTrace();
     * } catch (IOException e) {
     * // TODO Auto-generated catch block
     * e.printStackTrace();
     * }
     * }
     */

    /**
     * 
     * ��������: <br>
     * add text to the end of file
     * 
     * @see
     * @since
     */
    @Test
    public void appendToFile() {
        try {
            FileChannel fc = new RandomAccessFile("readme.txt", "rw")
                    .getChannel();
            logger.debug("fc size :" + fc.size());
            fc.position(fc.size());
            fc.write(ByteBuffer.wrap(" you must".getBytes()));
            fc.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /*
     * Read the file
     */
    @Test
    public void readFromFile() {
        try {
            FileChannel fc = new FileInputStream("readme.txt").getChannel();
            ByteBuffer buff = ByteBuffer.allocate(BUFFER_SIZE);
            fc.read(buff);

            /*
             * ��ת�˻����������Ƚ���������Ϊ��ǰλ�ã�Ȼ��λ������Ϊ 0������Ѷ����˱�ǣ������ñ�ǡ�
             * ��һϵ��ͨ����ȡ����� ����֮�󣬵��ô˷���Ϊһϵ��ͨ��д�����Ի�ȡ ��������׼�������磺
             * buf.put(magic); // Prepend header
             * in.read(buf); // Read data into rest of buffer
             * buf.flip(); // Flip buffer
             * out.write(buf); // Write header + data to
             * channel�������ݴ�һ���ط����䵽��һ���ط�ʱ���������˷����� compact ����һ��ʹ�á�
             */
            buff.flip();
            while(buff.hasRemaining()) {
                logger.debug((char)buff.get());
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
