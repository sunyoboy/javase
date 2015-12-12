/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: ScheduledExecutorTest.java
 * Author: DD240
 * Date: 2015-12-8 ����10:36:32
 * Description: //ģ��Ŀ�ġ���������
 * History: //�޸ļ�¼
 * <author> sunlj <time> <version> <desc>
 * �޸������� �޸����� �汾�� ����
 */
package com.common.schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ��һ�仰���ܼ�����<br>
 * ��������ϸ������
 * 
 * @author sunlj
 * @see
 * @since 1.0
 */
public class ScheduledExecutorTest implements Runnable {

    private String jobName;

    /**
     * @param jobName
     */
    public ScheduledExecutorTest(String jobName) {
        super();
        this.jobName = jobName;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("execute : " + jobName);
    }

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

        long initialDelay = 1;
        long period = 1;
        service.scheduleAtFixedRate(new ScheduledExecutorTest("jobOne"),
                initialDelay, period, TimeUnit.SECONDS);
        
        long initialDelayTwo = 2;
        long periodTwo = 2;
        service.scheduleWithFixedDelay(new ScheduledExecutorTest("jobTwo"),
                initialDelayTwo, periodTwo, TimeUnit.SECONDS);        
    }
}
