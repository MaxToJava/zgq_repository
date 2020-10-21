package com.zgq.threadpool;

import java.util.concurrent.*;

/**
 * TODO
 *
 * @author zgq
 * @date 2020/10/21
 */
public class ThreadPoolDefination {

    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(2, 4, 3, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(2),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardOldestPolicy());

        try {
            for (int i = 1; i <= 10; i++) {
                int N = i;
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"/t 任务"+N+"执行完成");
                    try {
                        TimeUnit.MILLISECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

    }
}
