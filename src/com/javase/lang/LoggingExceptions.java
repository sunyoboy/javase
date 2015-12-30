/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: LoggingExceptions.java
 * Author:   DD240
 * Date:     2015-12-30 ����10:25:28
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.javase.lang;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;


/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class LoggingExceptions {
    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught : " + e);
        }
        
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught : " + e);
        }        
    }
}

class LoggingException extends Exception {
    private static Logger logger = Logger.getLogger("LoggerException");

    /**
     * Constructor of LogginException
     */
    public LoggingException() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
