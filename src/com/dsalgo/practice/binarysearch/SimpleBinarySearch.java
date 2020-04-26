package com.dsalgo.practice.binarysearch;

public class SimpleBinarySearch {

    public static void main(String [] args){
        SimpleBinarySearch bs = new SimpleBinarySearch();
        int elementToFind = 6;
        int targetIndex = bs.search(new int[]{1,2,3,4,5,6,7,8,9,10}, elementToFind);
        System.out.println("element : "+ elementToFind+" found at index : "+targetIndex);
    }

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;

        return search(nums, 0, nums.length-1, target);
    }

    public int search(int[] nums, int left, int right, int target) {
        if(right < left)
            return -1;

        if(left == right){
            if(nums[left] == target)
                return left;
            else
                return -1;
        }

        int mid = (left + right)/2;

        if(nums[mid] == target){
            return mid;
        }
        else if(target < nums[mid]){
            return search(nums, left, mid-1, target);
        }
        else{
            return search(nums, mid+1, right, target);
        }
    }
}