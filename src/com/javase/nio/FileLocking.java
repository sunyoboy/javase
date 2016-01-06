/*
 * Copyright (C), 2002-2016, �������Ͷ���������޹�˾
 * FileName: FileLocking.java
 * Author:   DD240
 * Date:     2016-1-6 ����7:16:54
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.javase.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

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
