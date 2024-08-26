package org.example.mergesort;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> listToSort = List.of(4, 6, 1, 3, 5, 7, 2, 8);

        ExecutorService executorService = Executors.newCachedThreadPool();
        MergeSorter mergeSorter = new MergeSorter(listToSort, executorService);

        Future<List<Integer>> sortedListFuture = executorService.submit(mergeSorter);

        System.out.println(sortedListFuture.get());
    }
}
