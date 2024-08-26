package org.example.numberfrom1to100;

import org.example.executorService.NumberPrinter;

public class Client {
    public static void main(String[] args) {
        for (int i = 1; i <= 1; i++) {
            NumberPrinter numberPrinter = new NumberPrinter(i);
            Thread thread = new Thread(numberPrinter);
            thread.start();
        }
    }
}
