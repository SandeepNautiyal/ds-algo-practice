package com.dsalgo.practice.solutions;

public class NegativeNumsInASortedMatrixWithOptimzations {

    public static void main(String [] args){
        int [][] example0 = {{}};
        int [][] example1 =   {{5,4,3,2,1},{4,3,-1,-1,-1},{2,2,-1,-2,-2},{-1,-1,-1,-2,-3}}; //example from video
        int [][] example2 =   {{3,2,1},{2,1,0}}; //example from video
        int [][] example3 =   {{10,8,5},{8,6,4},{3,2,-1},{2,1,-1},{-1,-2,-3}}; //example from video
        System.out.println("example0 negative element count = "+countNegatives(example0));
        System.out.println("example1 negative element count = "+countNegatives(example1));
        System.out.println("example2 negative element count = "+countNegatives(example2));
        System.out.println("example3 negative element count = "+countNegatives(example3));
    }


    public static int countNegatives(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;

        int negativeNumberCount = 0;
        /**
         * The variable 'endColumnIndex' keeps track of the end index that we need to consider for any row i.
         * for the first row the value of variable endColumnIndex will be grid[0].length-1.
         */
        int endColumnIndex = grid[0].length-1;
        /**
         * The variable 'columnCount' represents the number of columns in the matrix.
         */
        final int columnCount = grid[0].length;
        for(int i = 0; i < grid.length; i++){
            /**
             * In the step below we will only consider subarray in row i starting at index 0 and ending at index equal to the value of variable endColumnIndex.
             */
            int index = findFirstNegativeElementInTheRow(grid, i, 0, endColumnIndex);
            if(index == 0){ //This condition represents that all the elements in this row and subsequent rows will be negative.
                negativeNumberCount = negativeNumberCount + ((grid.length-i) * columnCount);
                return negativeNumberCount;
            }
            if(index != -1){ //This condition represents the case when we have found a negative element in the row
                negativeNumberCount = negativeNumberCount + (grid[i].length-index);
                endColumnIndex = index;
            }
        }
        return negativeNumberCount;
    }

    /**
     * This method contains the standard binary search code.
     */
    public static int findFirstNegativeElementInTheRow(int[][] grid, int rowIndex, int start, int end) {
        if(start == end){
            if(grid[rowIndex][start] < 0){
                return start;
            }
            else{
                return -1;
            }
        }

        if(end < start){
            return -1;
        }

        int mid = (start + end)/2;

        if(mid == 0 && grid[rowIndex][mid] < 0){
            return 0;
        }

        if(grid[rowIndex][mid] < 0 && grid[rowIndex][mid-1] >= 0){
            return mid;
        }

        if(grid[rowIndex][mid] < 0){
            return findFirstNegativeElementInTheRow(grid, rowIndex, start, mid-1);
        }
        else{
            return findFirstNegativeElementInTheRow(grid, rowIndex, mid+1, end);
        }
    }
}