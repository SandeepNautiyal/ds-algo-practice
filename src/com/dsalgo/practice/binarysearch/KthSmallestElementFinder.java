package com.dsalgo.practice.binarysearch;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementFinder {

    public static void main(String [] args){
        int [][] testArray1 = {{1,2,3,5},{4,4,4,8},{7,8,9,10},{8,8,11,11},{10,10,12,12}};
        int kthElement1 = 20;

        int kthElement2 = 5;

        int [] result = Arrays.asList(testArray1).stream().flatMapToInt(Arrays::stream).toArray();
        Arrays.sort(result);
        System.out.println("sorted test array is : "+Arrays.toString(result));
        System.out.println("kth element is : "+kthSmallest(testArray1, kthElement1));
        System.out.println("kth element is : "+kthSmallest(testArray1, kthElement2));
    }

    //Remember if we remove element from the queue, then we have to add the element below the removed element in the matrix into the queue
    //remove -> (i,j) - then add (i+1,j) into the queue.
    public static int kthSmallest(int[][] matrix, int k) {
        Queue<GridElement> gridElementQueue = new PriorityQueue<GridElement>();
        for(int i = 0; i < matrix[0].length; i++){
            gridElementQueue.add(new GridElement(0, i, matrix[0][i]));
        }

        int count = 0;
        while(!gridElementQueue.isEmpty()){
            GridElement element = gridElementQueue.poll();
            count++;
            if(count == k){
                return element.val;
            }

            int rowIndex = element.rowIndex;
            int columnIndex = element.columnIndex;
            if(rowIndex + 1 < matrix.length){
                GridElement gridElement = new GridElement(rowIndex+1, columnIndex, matrix[rowIndex+1][columnIndex]);
                gridElementQueue.add(gridElement);
            }
        }

        return -1;
    }

    static class GridElement implements Comparable<GridElement>{
        int rowIndex;
        int columnIndex;
        int val;

        public GridElement(int rowIndex, int columnIndex, int val){
            this.rowIndex = rowIndex;
            this.columnIndex = columnIndex;
            this.val = val;
        }

        @Override
        public int compareTo(GridElement o) {
            return this.val - o.val;
        }
    }
}
