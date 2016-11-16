/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: SampleRunable.java
 * Author:   DD240
 * Date:     2015-12-23 下午3:05:20
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.javase.util.concurrent;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class SampleRunable implements Runnable {

    private String name;
    
    SampleRunable(String name) {
        this.name = name;
    }
    
    
    
    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        System.out.println("threadId \t" + Thread.currentThread().getId() + "\t threadName \t" + Thread.currentThread().getName() + " \t" + name);
        System.out.println(this.getClass().getSimpleName() + "\trun() !\t" + "threadStatus\t" + Thread.currentThread().getState());
        // System.out.println("==================================================================================================");
    }

}
