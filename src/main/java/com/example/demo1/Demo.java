package com.example.demo1;

public class Demo implements Runnable{
    @Override
    public void run() {
        synchronized(this) {
            try {
                System.out.println(Thread.currentThread().getName());

            }catch(IllegalMonitorStateException e){
                System.out.println(e);
            }
            notifyAll();
        }
    }
}
