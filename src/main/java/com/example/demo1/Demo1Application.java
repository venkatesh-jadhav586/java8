package com.example.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication()
public class Demo1Application {

    public static void main(String[] args) {
        try {
            SpringApplication.run(Demo1Application.class, args);
            System.out.println("venkatesh");
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setCorePoolSize(5);
            executor.setMaxPoolSize(10);
            executor.setQueueCapacity(20);
            executor.initialize();
            Demo1Application wai = new Demo1Application();
            for (int i = 0; i < 50; i++) {
                if (executor.getActiveCount() <=executor.getMaxPoolSize()) {
                    executor.execute(new Runnable() {
                        @Override
                        public void run() {
                            synchronized (this) {
                                try {
                                    System.out.println(Thread.currentThread().getName());

                                } catch (IllegalMonitorStateException e) {
                                    e.printStackTrace();
                                }
                                this.notifyAll();
                            }
                        }
                    });
                } else {
                    System.out.println("pool has reached max size wait for some time then retry again");
                    wai.waity(60000);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waity(long a) {
        synchronized (this) {
            try {
                this.wait(a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}