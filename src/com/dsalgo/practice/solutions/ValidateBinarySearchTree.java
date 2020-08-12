package com.dsalgo.practice.solutions;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }

        StepValue value = isValid(root);
        return value.isValid;
    }

    public StepValue isValid(TreeNode root) {
        if(root == null){
            return null;
        }

        StepValue left = isValid(root.left);
        StepValue right = isValid(root.right);

        if(left == null && right == null){
            return new StepValue(root.val, root.val, true);
        }
        if(left == null){
            if(root.val < right.min && right.isValid){
                return new StepValue(root.val, right.max, true);
            }
        }
        else if(right == null){
            if(root.val > left.max && left.isValid){
                return new StepValue(left.min, root.val, true);
            }
        }
        else if(left.isValid && right.isValid && root.val > left.max && root.val < right.min){
            return new StepValue(left.min, right.max, true);
        }

        return new StepValue(0, 0, false);
    }
}

class StepValue{
    int max;
    int min;
    boolean isValid;

    public StepValue(int min, int max, boolean isValid){
        this.min = min;
        this.max = max;
        this.isValid = isValid;
    }
}
