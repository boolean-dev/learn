package com.tao.leanrn.thread.product.consumer1;

/**
 * @ClassName PC1 生产者消费者
 * @Descriiption 实现方式一：wait()和notify()方法的实现
 * @Author yanjiantao
 * @Date 2019/8/22 9:53
 **/
public class PC1 {



    public static void main(String[] args) {
        Stock stock = new Stock();
        for (int i = 0; i < 100; i++) {
            new Thread(new Producer(stock)).start();
            new Thread(new Consumer(stock)).start();
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

/**
 * 生产者
 */
class Producer implements Runnable{
    private Stock stock;

    public Producer(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long)(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (stock) {
            while (stock.getCount() == stock.getFull()) {
                try {
                    stock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            stock.increase();
            System.out.println(Thread.currentThread().getName() + "-->生产者生产--->" + stock.getCount());
            stock.notifyAll();
        }
    }
}

/**
 * 消费者
 */
class Consumer implements Runnable{

    private Stock stock;

    public Consumer(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void run() {

        try {
            Thread.sleep((long)(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (stock) {
            while (stock.getCount() == 0) {
                try {
                    stock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            stock.reduce();
            System.out.println(Thread.currentThread().getName() + "-->消费者消费--->" + stock.getCount());
            stock.notifyAll();
        }
    }
}
