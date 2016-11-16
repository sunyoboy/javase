/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: ExecutorsTest.java
 * Author: DD240
 * Date: 2015-12-23 下午3:02:59
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author> sunlj <time> <version> <desc>
 * 修改人姓名 修改日期 版本号 描述
 */
package com.javase.util.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author sunlj
 * @see
 * @since 1.0
 */
public class ExecutorsTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        SampleRunable run = new SampleRunable("run");
        SampleRunable r = new SampleRunable("R");

        /*
         * replace
         * **************************************
         * Thread t = new Thread(run);
         * t.start();
         * **************************************
         * with
         * service.execute(run);
         */

        service.execute(run);
        service.execute(r);

        /*
         * Second Test
         */

        service = Executors.newFixedThreadPool(10);
        SampleRunable run1 = new SampleRunable("run1");
        SampleRunable run2 = new SampleRunable("run2");
        service.execute(run1);
        service.execute(run2);

        /*
         * Test Four
         */
        BlockingQueue q = new LinkedBlockingQueue(10);
        Producer p = new Producer(q);
        Producer p1 = new Producer(q);
        Consumer c1 = new Consumer(q);
        Consumer c2 = new Consumer(q);
        new Thread(p).start();
        new Thread(p1).start();
        new Thread(c1).start();
        new Thread(c2).start();
    }
}

class Producer implements Runnable {
    private final BlockingQueue queue;

    Producer(BlockingQueue q) {
        queue = q;
    }

    public void run() {
        try {
            while (true) {
                if (queue.size() >= 10) {
                    System.out.println("producer sleep !");
                    Thread.sleep(1000);
                } else {
                    System.out.println("len of queue :" + queue.size());
                    queue.put(produce());
                }
            }
        } catch (InterruptedException ex) {
        }
    }

    Object produce() {
        System.out.println("cook a humberg ");
        return new Humberg();
    }
}

class Consumer implements Runnable {
    private final BlockingQueue queue;

    Consumer(BlockingQueue q) {
        queue = q;
    }

    public void run() {
        try {
            while (true) {

                if (queue.size() < 1) {
                    System.out.println("len of queue :" + queue.size()
                            + ", consumer sleep !");
                    Thread.sleep(3000);
                } else {
                    Thread.sleep(2000);
                    System.out.println("len of queue :" + queue.size());
                    consume(queue.take());
                }
            }
        } catch (InterruptedException ex) {
        }
    }

    void consume(Object x) {
        System.out.println("eat a humberg ");
    }
}

class Humberg {

    private String name;

    private float weight;

    private double price;

    public Humberg() {
        this.name = "Classic";
        this.weight = 100.0F;
        this.price = 10.0;
    }

    /**
     * @param name
     * @param weight
     * @param price
     */
    public Humberg(String name, float weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class Setup {
    void main() {
        /*
         * BlockingQueue q = new LinkedBlockingQueue();
         * Producer p = new Producer(q);
         * Consumer c1 = new Consumer(q);
         * Consumer c2 = new Consumer(q);
         * new Thread(p).start();
         * new Thread(c1).start();
         * new Thread(c2).start();
         */
    }
}
