package com.sda.thread;

public class Demo {

    public static void main(String[] args) {

        Task task =  new Task();

        Thread first = new Thread(task,"Joe");
        Thread second = new Thread(task,"Bill");

        first.start();
        second.start();

        System.out.println("Main thread "+Thread.currentThread().getName());
    }
}