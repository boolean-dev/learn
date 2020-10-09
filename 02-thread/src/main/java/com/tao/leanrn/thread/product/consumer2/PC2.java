package com.tao.leanrn.thread.product.consumer2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName PC1 生产者消费者
 * @Descriiption 实现方式一：可重入锁ReentrantLock的实现
 * @Author yanjiantao
 * @Date 2019/8/22 9:53
 **/
public class PC2 {


    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        // 写条件
        final Condition notFull = lock.newCondition();
        // 读条件
        final Condition notEmpty = lock.newCondition();

        Stock stock = new Stock();
        for (int i = 0; i < 10; i++) {
            new Thread(new Producer(stock, lock, notFull, notEmpty)).start();
            new Thread(new Consumer(stock, lock, notFull, notEmpty)).start();
        }
    }

}


/**
 * 生产者
 */
class Producer implements Runnable {
    private Stock stock;
    private Lock lock;

    private Condition notFull;
    private Condition notEmpty;

    public Producer(Stock stock, Lock lock, Condition notFull, Condition notEmpty) {
        this.stock = stock;
        this.lock = lock;
        this.notFull = notFull;
        this.notEmpty = notEmpty;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep((long) (Math.random() * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            lock.lock();
            try {
                while (stock.getCount() == stock.getFull()) {
                    try {
                        // 队列已满，生产者等待
                        notFull.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                stock.increase();
                System.out.println(Thread.currentThread().getName() + "-->生产者生产--->" + stock.getCount());
                // 已生产，通知消费者消费
                notEmpty.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}

/**
 * 消费者
 */
class Consumer implements Runnable {

    private Stock stock;
    private Lock lock;

    private Condition notFull;
    private Condition notEmpty;

    public Consumer(Stock stock, Lock lock, Condition notFull, Condition notEmpty) {
        this.stock = stock;
        this.lock = lock;
        this.notFull = notFull;
        this.notEmpty = notEmpty;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep((long) (Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lock.lock();
            try {
                while (stock.getCount() == 0) {
                    try {
                        // 队列已经为空，消费者线程等待
                        notEmpty.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                stock.reduce();
                System.out.println(Thread.currentThread().getName() + "-->消费者消费--->" + stock.getCount());
                // 已消费，通知生产者生产
                notFull.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }


    }
}


class Stock {

    private int count;
    private int full = 10;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getFull() {
        return full;
    }

    public void setFull(int full) {
        this.full = full;
    }

    public void increase() {
        count++;
    }

    public void reduce() {
        count--;
    }
}

