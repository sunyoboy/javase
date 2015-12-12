/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: QurartzCronTriggerTest.java
 * Author:   DD240
 * Date:     2015-12-8 ����4:10:06
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.common.schedule;

import java.util.Date;

import org.apache.log4j.BasicConfigurator;
import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class QurartzCronTriggerTest implements Job {

    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        System.out.println(" Genrerating report " + context.getJobDetail().getKey().getName() + " " +
                context.getJobDetail().getKey().getGroup() + " " +
                context.getJobDetail().getJobDataMap().getString("type"));

        System.out.println(new Date().toString());        
    }
    
    public static void main(String[] args) {
        SchedulerFactory shedFactory = new StdSchedulerFactory();
        try {
            BasicConfigurator.configure();
            Scheduler sched = shedFactory.getScheduler();
            sched.start();

            //
            JobDetail jobDetail = JobBuilder.newJob(QuartzTestOne.class)
                    .withIdentity("myJob", "group").build();

            CronScheduleBuilder cronSchedule = CronScheduleBuilder.cronSchedule("5 0/1 8-17 * * ?");
            
            jobDetail.getJobDataMap().put("type", "full");
            Trigger trigger = TriggerBuilder
                    .newTrigger()
                    .withIdentity("trigger", "triggerGroup")
                    .withSchedule(cronSchedule)
                    .forJob("myJob", "group")
                    .build();

            sched.scheduleJob(jobDetail, trigger);

        } catch (SchedulerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
