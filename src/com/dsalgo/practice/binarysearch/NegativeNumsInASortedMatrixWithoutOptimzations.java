package com.dsalgo.practice.binarysearch;

public class NegativeNumsInASortedMatrixWithoutOptimzations {
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
        for(int i = 0; i < grid.length; i++){
            int index = findFirstNegativeElementInTheRow(grid, i, 0, grid[i].length-1);
            if(index != -1){
                negativeNumberCount = negativeNumberCount + (grid[i].length-index);
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
