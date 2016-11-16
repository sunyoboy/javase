/*
 * Copyright (C), 2002-2016, 北京世纪鼎点软件有限公司
 * FileName: IntBufferDemo.java
 * Author:   DD240
 * Date:     2016-1-6 下午3:16:20
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.javase.nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

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
public class IntBufferDemo {
    
    private Logger logger = Logger.getLogger(IntBufferDemo.class);
    
    @Test
    public void put() {
        ByteBuffer bb = ByteBuffer.allocate(GetChannel.BUFFER_SIZE);
        IntBuffer intBuff = bb.asIntBuffer();
        
        // store an array of int 
        intBuff.put(new int[] {11, 42, 27, 99, 143, 811, 1016 });
        
        // Absolute location read and write
        logger.debug("intBuff.get(3) " + intBuff.get(3));
        intBuff.put(3, 1811);
        
        // Setting a new limit before rewinding the buffer
        intBuff.flip();
        while(intBuff.hasRemaining()) {
            int i = intBuff.get();
            logger.debug("int " + i);
        }
    }
}
