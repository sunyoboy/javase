/*
 * Copyright (C), 2002-2016, 北京世纪鼎点软件有限公司
 * FileName: FileLocking.java
 * Author:   DD240
 * Date:     2016-1-6 下午7:16:54
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.javase.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

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
public class FileLocking {
    
    private Logger logger = Logger.getLogger(FileLocking.class);
    
    @Test
    public void getLock() {
        try {
            FileOutputStream fos = new FileOutputStream("read.txt");
            FileLock fLock = fos.getChannel().tryLock();
            if(fLock != null) {
                logger.debug("Locked File ");
                TimeUnit.SECONDS.sleep(10);
                fLock.release();
                logger.debug("Release Lock ");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
