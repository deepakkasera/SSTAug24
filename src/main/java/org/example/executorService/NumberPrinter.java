package org.example.executorService;

import java.util.concurrent.Callable;

public class NumberPrinter implements Runnable {
    private int number;

    public NumberPrinter(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        //Print the number
        System.out.println(number + ": Printed by " + Thread.currentThread().getName());
    }
}
