package com.example.demo1;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;



public class login {


        public static void main(String[] args){
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setCorePoolSize(5);
            executor.setMaxPoolSize(50);
            executor.setQueueCapacity(20);
            for(int i=0;i<10;i++)
            {
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        Thread.currentThread().getName();
                    }
                });
            }
        }


    }

