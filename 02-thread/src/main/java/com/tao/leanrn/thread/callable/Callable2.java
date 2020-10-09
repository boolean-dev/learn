package com.tao.leanrn.thread.callable;

import java.util.concurrent.*;

/**
 * @ClassName Callable2
 * @Descriiption 使用Callable+Future获取执行结果
 * @Author yanjiantao
 * @Date 2019/8/23 17:06
 **/
public class Callable2 {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread().getName() + "------>主线程开始");
        // 创建线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // 创建线程
        Task2 task2 = new Task2();

        // 开启线程池
        Future<Integer> future = executorService.submit(task2);

        // 关闭线程池
        executorService.shutdown();

        // 得到callable处理后的结果
        Integer result = future.get();
        System.out.println(Thread.currentThread().getName() + "------>主线程得到结果,result=" + result);
        System.out.println(Thread.currentThread().getName() + "------>主线程结束");
    }

}


class Task2 implements Callable<Integer> {

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
