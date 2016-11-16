/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: AtomicVariableTest.java
 * Author: DD240
 * Date: 2015-12-23 下午4:32:06
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author> sunlj <time> <version> <desc>
 * 修改人姓名 修改日期 版本号 描述
 */
package com.javase.util.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author sunlj
 * @see
 * @since 1.0
 */
public class AtomicVariableTest {
    public static void main(String[] args) {
        /*
         * Three Test
         */
        int poolSize = 5;
        int maxPoolSize = 10;
        long aliveTime = 3;
        BlockingQueue queue = new LinkedBlockingQueue(2);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                poolSize, maxPoolSize, aliveTime, TimeUnit.MILLISECONDS, queue);
        System.out.println("len of blockQueue \t : " + queue.size());

/*      C counter = new Counter();
        CounterOne one = new CounterOne(counter);
        CounterTwo two = new CounterTwo(counter);        
        threadPoolExecutor.execute(one);
        threadPoolExecutor.execute(two); 
        */
        C c = new AtomicCounter();
        CounterOne three = new CounterOne(c);        
        threadPoolExecutor.execute(three);
        CounterTwo four = new CounterTwo(c);        
        threadPoolExecutor.execute(four);        
        
        
    }
}

class CounterOne implements Runnable {
    private C counter;
    private int times = 30;

    CounterOne(C counter) {
        this.counter = counter;
    }

    public void run() {
        for(int i=0 ; i<times; i++) {
            synchronized(counter) {
                counter.increment();
                System.out.println("increment\t : " + counter.value());
            }
        }
    }

}

class CounterTwo implements Runnable {
    private C counter;
    private int times = 30;

    CounterTwo(C counter) {
        this.counter = counter;
    }

    public void run() {
        for(int i=0 ; i<times; i++) {
            synchronized(counter) {
                counter.decrement();
                System.out.println("decrement\t : " + counter.value());
            }
        }
    }

}

class Counter implements C {
    private int c = 0;

    public void increment() {
        c++;
    }

    public void decrement() {
        c--;
    }

    public int value() {
        return c;
    }

}

class SynchronizedCounter implements C {
    
    private int c = 0;
    
    public synchronized void increment() {
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }
    
}


class AtomicCounter implements C {
    private AtomicInteger c = new AtomicInteger(0);

    public void increment() {
        c.incrementAndGet();
    }

    public void decrement() {
        c.decrementAndGet();
    }

    public int value() {
        return c.get();
    }

}

