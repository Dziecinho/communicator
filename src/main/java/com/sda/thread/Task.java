package com.sda.thread;

public class Task implements Runnable {

    @Override
    public void run() {
        System.out.printf("Hello from %s\n", Thread.currentThread()
                .getName());
    }
}