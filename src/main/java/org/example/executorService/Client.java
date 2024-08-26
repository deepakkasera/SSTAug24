package org.example.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Client {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        for (int i = 1; i <= 100; i++) {
            if (i == 5 || i == 10 || i == 50 || i == 98) {
                System.out.println("DEBUG");
            }

            NumberPrinter numberPrinter = new NumberPrinter(i);
            executorService.execute(numberPrinter);
        }
    }
}
