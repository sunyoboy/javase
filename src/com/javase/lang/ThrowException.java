/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: ThrowException.java
 * Author:   DD240
 * Date:     2015-12-30 ����9:36:18
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.javase.lang;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * implements the chapter12 of Thinking in Java
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class ThrowException {
    
    private Logger logger = Logger.getLogger(ThrowException.class);
    
    /**
     * execrise 1st
     * ֤��finally�Ӿ䱻ִ��
     *
     * @see 
     * @since
     */
    @Test
    public void throwExceptionTest() {
        
        try {
            throw new Exception("Unable to initial ");
        } catch (Exception e) {
            logger.debug("catch Exception ", e);
            e.printStackTrace();
        } finally {
            logger.debug("execute finally block");
        }
        
    }
}
