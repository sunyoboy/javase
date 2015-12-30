/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: SampleRunable.java
 * Author:   DD240
 * Date:     2015-12-23 ����3:05:20
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.javase.util.concurrent;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
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
