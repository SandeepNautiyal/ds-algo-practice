package com.dsalgo.practice.binarysearch;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeSortedLists {
    public static void main(String [] args){
        int [] listVal1 = {5,8,10,12};
        int [] listVal2 = {};
        int [] listVal3 = {1,3,4,6,7};
        int [] listVal4 = {};

        ListNode list1 = ListUtil.convertToList(listVal1);
        ListNode list2 = ListUtil.convertToList(listVal2);
        ListNode list3 = ListUtil.convertToList(listVal3);
        ListNode list4 = ListUtil.convertToList(listVal4);

        System.out.println("list1 = "+ListUtil.printList(list1));
        System.out.println("list2 = "+ListUtil.printList(list2));
        System.out.println("list3 = "+ListUtil.printList(list3));
        System.out.println("list4 = "+ListUtil.printList(list4));

        ListNode result = mergeKLists(new ListNode[]{list1,list2, list3, list4});
        System.out.println("Result :  "+ListUtil.printList(result));

    }

    public static ListNode mergeKLists(ListNode [] lists){
        if(lists == null || lists.length == 0)
            return null;

        Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null){
                queue.add(lists[i]);
            }
        }

        ListNode prev = null;
        ListNode head = null;
        while(!queue.isEmpty()){
            ListNode node = queue.poll();

            if(prev == null){
                prev = node;
                head = node;
                if(node.next != null){
                    queue.add(node.next);
                }
            }
            else{
                prev.next = node;
                prev = prev.next;
                if(node.next != null){
                    queue.add(node.next);
                }
            }
        }
        return head;
    }
}

//    public class ListNode {
//        int val;
//        ListNode next;
//
//        public ListNode(int val){
//            this.val = val;
//        }
//    }