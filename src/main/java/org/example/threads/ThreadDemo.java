package org.example.threads;

import java.util.Scanner;

public class ThreadDemo {
    public static void main(String[] args) {
        System.out.println("Hello SST, Printed by : " + Thread.currentThread().getName());

        //1. Create a task
        HelloSSTPrinter task = new HelloSSTPrinter();

        //2. Create a thread.
        //3. Assign the task to the thread.
        Thread thread = new Thread(task);

        //4. Start the thread.
        thread.start();

        System.out.println("Hey SST, Printed by " + Thread.currentThread().getName());
    }
}
