package com.zgq.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * java中常用的三中线程池的解析
 *  在平常的开发中，按照阿里开发规约，是不允许显式创建线程和用下面的三种方法
 *  创建线程池的，否则容易出现OOM
 *  实际开发中要根据自己的业务手写线程池
 *
 * @author zgq
 * @date 2020/10/21
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        //System.out.println(Runtime.getRuntime().availableProcessors());

        //核心线程数等于最大线程数，值为自定义，空闲时间为0，工作队列是LinkedBlockingQueue，
        // 容量是Integer.MAX_VALUE；适合执行长期的任务
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        // 核心线程数等于最大线程数,值为1，空闲时间为0，工作队列是LinkedBlockingQueue，
        // 容量是Integer.MAX_VALUE；实现任务的逐个执行
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();

        //核心线程数是0，最大线程数时Integer.MAX_VALUE,空闲时间是60s，工作队列是SynchronousQueue,容量是0，
        //默认是非公平策略，底层数据结构栈；公平策略是队列；采用CAS;适合执行大量短期异步的任务
        //ExecutorService threadPool = Executors.newCachedThreadPool();

        try {
            for(int i=0;i<10;i++){
                threadPool.submit(()->{
                    System.out.println(Thread.currentThread().getName()+"/n");
                });
                TimeUnit.MINUTES.sleep(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

    }
}
