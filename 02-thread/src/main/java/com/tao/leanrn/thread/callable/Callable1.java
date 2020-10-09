package com.tao.leanrn.thread.callable;

import java.util.concurrent.*;

/**
 * @ClassName Callable1
 * @Descriiption 使用Callable+FutureTask获取执行结果
 * @Author yanjiantao
 * @Date 2019/8/23 15:00
 **/
public class Callable1 {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        fun1();

        fun2();
    }

    /**
     * 通过创建线程
     */
    private static void fun1() throws ExecutionException, InterruptedException{
        System.out.println(Thread.currentThread().getName() + "------>主线程开始");

        // 创建线程
        Task1 task = new Task1();

        // 创建FutureTask
        FutureTask<Integer> futureTask = new FutureTask<>(task);

        // 开启线程
        new Thread(futureTask, "子线程").start();

        // 得到异步处理结果
        Integer result = futureTask.get();

        System.out.println(Thread.currentThread().getName() + "------>主线程得到结果" + result);
        System.out.println(Thread.currentThread().getName() + "------>主线程结束");
    }

    /**
     * 通过线程池
     */
    private static void fun2() throws ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread().getName() + "------>主线程开始");

        // 创建线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // 创建线程
        Task2 task2 = new Task2();

        // 创建FutureTask
        FutureTask<Integer> futureTask = new FutureTask<>(task2);

        // 提交线程至线程池
        executorService.submit(futureTask);

        // 关闭线程池
        executorService.shutdown();

        // 得到异步处理结果
        Integer result = futureTask.get();

        System.out.println(Thread.currentThread().getName() + "------>主线程得到结果" + result);
        System.out.println(Thread.currentThread().getName() + "------>主线程结束");
    }


}

class Task1 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "------>子线程开始");
        Thread.sleep(3000);
        Integer result = 0;
        for (Integer i = 0; i < 10; i++) {
            result++;
        }

        System.out.println(Thread.currentThread().getName() + "------>子线程结束");
        return result;
    }
}
