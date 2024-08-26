package org.example.addersubtractor;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();

        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);

        Thread adderThread = new Thread(adder);
        Thread subtractorThread = new Thread(subtractor);

        adderThread.start();
        subtractorThread.start();

        adderThread.join();
        subtractorThread.join();

        System.out.println(count.value);
    }
}
