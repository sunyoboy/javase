/*
 * Copyright (C), 2002-2016, 北京世纪鼎点软件有限公司
 * FileName: GetChannel.java
 * Author: DD240
 * Date: 2016-1-6 下午2:25:29
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author> sunlj <time> <version> <desc>
 * 修改人姓名 修改日期 版本号 描述
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
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
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
     * 功能描述: <br>
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
             * 反转此缓冲区。首先将限制设置为当前位置，然后将位置设置为 0。如果已定义了标记，则丢弃该标记。
             * 在一系列通道读取或放置 操作之后，调用此方法为一系列通道写入或相对获取 操作做好准备。例如：
             * buf.put(magic); // Prepend header
             * in.read(buf); // Read data into rest of buffer
             * buf.flip(); // Flip buffer
             * out.write(buf); // Write header + data to
             * channel当将数据从一个地方传输到另一个地方时，经常将此方法与 compact 方法一起使用。
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
