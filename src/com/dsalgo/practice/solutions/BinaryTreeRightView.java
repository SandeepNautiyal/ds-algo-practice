package com.dsalgo.practice.solutions;

import java.util.*;

public class BinaryTreeRightView {

    /**
     * Example - [1,2,3,null,5,null,4]
     *
     *                         1
     *                    2         3
     *               null   5  null   4
     * Level 1 - 1, null
     * Level 2 - 3, 2, null, (right to left)
     * Level 3 - 4, 5, null, (right to left)
     */
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return Collections.EMPTY_LIST;
        }

        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        bfsQueue.add(null);

        TreeNode prev = null;
        List<Integer> result = new ArrayList<>();
        while(!bfsQueue.isEmpty()){
            TreeNode node = bfsQueue.poll();

            if(node == null && prev == null){
                return result;
            }

            if(node == null){
                bfsQueue.add(null);
            }
            else{
                if(prev == null){
                    result.add(node.val);
                }

                if(node.right != null){
                    bfsQueue.add(node.right);
                }

                if(node.left != null){
                    bfsQueue.add(node.left);
                }
            }
            prev = node;
        }

        return result;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
}