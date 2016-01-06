/*
 * Copyright (C), 2002-2016, �������Ͷ���������޹�˾
 * FileName: ViewBuffer.java
 * Author:   DD240
 * Date:     2016-1-6 ����3:25:56
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.javase.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

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
public class ViewBuffer {
    
    private Logger logger = Logger.getLogger(ViewBuffer.class);
    
    @Test
    public void buffer() {
        ByteBuffer byteBuff = ByteBuffer.wrap(new byte[] {0, 0, 0, 0, 'a'});
        byteBuff.rewind();
        logger.debug("ByteBuffer ");
        while(byteBuff.hasRemaining()) {
            logger.debug(byteBuff.position() + " -> " + byteBuff.get() + ", ");
        }
        logger.debug(" \r\n");
        
        CharBuffer cb = ((ByteBuffer)byteBuff.rewind()).asCharBuffer();
        logger.debug("Char Buffer ");
        while(cb.hasRemaining()) {
            logger.debug(cb.position() + " -> " + cb.get());
        }
        logger.debug(" \r\n");
        
        FloatBuffer fb = ((ByteBuffer)byteBuff.rewind()).asFloatBuffer();
        logger.debug("Char Buffer ");
        while(fb.hasRemaining()) {
            logger.debug(fb.position() + " -> " + fb.get());
        }
        logger.debug(" \r\n");
        
        IntBuffer ib = ((ByteBuffer)byteBuff.rewind()).asIntBuffer();
        logger.debug("Char Buffer ");
        while(ib.hasRemaining()) {
            logger.debug(ib.position() + " -> " + ib.get());
        }
        logger.debug(" \r\n");        
    }
}
