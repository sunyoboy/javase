/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: TimerTest.java
 * Author:   DD240
 * Date:     2015-12-8 ����10:10:42
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.common.schedule;

import java.util.Timer;
import java.util.TimerTask;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class TimerTest extends TimerTask {

    private String jobNames;
    
    /**
     * @param jobNames
     */
    public TimerTest(String jobNames) {
        super();
        this.jobNames = jobNames;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("execute : " + jobNames);
    }
    
    public static void main(String[] args) {
        Timer timer = new Timer();
        long delay = 1000;
        long period = 1000;
        timer.schedule(new TimerTest("job1"), delay, period);
        
        Timer timerTwo = new Timer();
        
        long delayTwo = 2000;
        long periodTwo = 2000;
        timerTwo.schedule(new TimerTest("job2"), delayTwo, periodTwo);
        
    }
   
}
