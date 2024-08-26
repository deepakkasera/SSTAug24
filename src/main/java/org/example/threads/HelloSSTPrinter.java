package org.example.threads;

public class HelloSSTPrinter implements Runnable {
    @Override
    public void run() {
        //The code that we want to execute via a different thread.
        System.out.println("Hello SST, Printed by : " + Thread.currentThread().getName());
    }
}
