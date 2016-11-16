/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: LoggingExceptions.java
 * Author:   DD240
 * Date:     2015-12-30 上午10:25:28
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.javase.lang;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;


/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
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
