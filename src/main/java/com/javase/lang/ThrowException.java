/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: ThrowException.java
 * Author:   DD240
 * Date:     2015-12-30 上午9:36:18
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
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
     * 证明finally子句被执行
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
