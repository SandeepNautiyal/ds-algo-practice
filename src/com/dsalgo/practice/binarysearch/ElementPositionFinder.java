package com.dsalgo.practice.binarysearch;


import java.util.Arrays;

public class ElementPositionFinder {

    public static void main(String [] args){
        int [] input1 = {1,2,3,4,5,6,7,8,9,10};
        int [] input2 = {1,2,3,3,3,3,4,5,6,7,8,9,10};
        int [] input3 = {1,2,3,4,5,6,7,8,8,8,9,10};

        int [] result1 = searchRange(input1, 3);
        int [] result2 = searchRange(input2, 3);
        int [] result3 = searchRange(input3, 8);

        System.out.println("result 1 ==> "+ Arrays.toString(result1));
        System.out.println("result 2 ==> "+ Arrays.toString(result2));
        System.out.println("result 3 ==> "+ Arrays.toString(result3));

    }

    /**
     * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
     * @param nums - input array
     * @param target - target to find
     * @return - start and end index of target element in input array. If not found return {-1,-1}
     */
    public static int[] searchRange(int [] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[]{-1,-1};

        int leftIndex = searchElement(nums, target, 0, nums.length-1, true);

        if(leftIndex == -1){
            return new int[]{-1,-1};
        }

        int rightIndex = searchElement(nums, target, leftIndex, nums.length-1, false);

        return new int[]{leftIndex, rightIndex};
    }

    private static int searchElement(int[] nums, int target, int left, int right, boolean isLeft) {
        if(left == right){
            if(nums[left] == target){
                return left;
            }
            else{
                return -1;
            }
        }

        if(left > right){
            return  -1;
        }

        int mid = (left+right)/2;

        if(nums[mid] == target){
            if(isLeft){
                if(mid == left || nums[mid-1] != target){
                    return mid;
                }
                else{
                    return  searchElement(nums, target, left, mid-1, isLeft);
                }
            }
            else{
                if(mid == right || nums[mid+1] != target){
                    return mid;
                }
                else{
                    return  searchElement(nums, target, mid+1, right, isLeft);
                }
            }
        }
        else{
            if(nums[mid] < target){
                return searchElement(nums, target, mid+1, right, isLeft);
            }
            else{
                return searchElement(nums, target, left, mid-1, isLeft);
            }
        }

    }
}
