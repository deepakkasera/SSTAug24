package org.example.mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>>  {
    private List<Integer> listToSort;
    private ExecutorService executorService;

    public MergeSorter(List<Integer> listToSort,
                       ExecutorService executorService) {
        this.listToSort = listToSort;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        if (listToSort.size() <= 1) {
            return listToSort;
        }

        // Divide the list into 2 parts.
        int mid = listToSort.size()/2;

        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        for (int i = 0; i < mid; i++) {
            leftList.add(listToSort.get(i));
        }

        for (int i = mid; i < listToSort.size(); i++) {
            rightList.add(listToSort.get(i));
        }

        MergeSorter leftMergeSorter = new MergeSorter(leftList, executorService);
        MergeSorter rightMergeSorter = new MergeSorter(rightList, executorService);

//        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<List<Integer>> sortedLeftListFuture = executorService.submit(leftMergeSorter);
        Future<List<Integer>> sortedRightListFuture = executorService.submit(rightMergeSorter);

        //Merge left and right sorted parts.
        List<Integer> sortedLeftList = sortedLeftListFuture.get(); // blocking call.
        List<Integer> sortedRightList = sortedRightListFuture.get();

        //Merge
        List<Integer> sortedList = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < sortedLeftList.size() && j < sortedRightList.size()) {
            if (sortedLeftList.get(i) <= sortedRightList.get(j)) {
                sortedList.add(sortedLeftList.get(i));
                ++i;
            } else {
                sortedList.add(sortedRightList.get(j));
                ++j;
            }
        }

        while (i < sortedLeftList.size()) {
            sortedList.add(sortedLeftList.get(i));
            ++i;
        }

        while (j < sortedRightList.size()) {
            sortedList.add(sortedRightList.get(j));
            ++j;
        }

        return sortedList;
    }
}
