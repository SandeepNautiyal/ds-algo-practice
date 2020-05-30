package com.dsalgo.practice.binarysearch;

public class ListUtil {
    public static ListNode convertToList(int[] listVal1) {
        if(listVal1 == null || listVal1.length == 0){
            return null;
        }

        ListNode prev = null;
        ListNode head = null;

        for(int i = 0; i < listVal1.length; i++){
            ListNode node = new ListNode(listVal1[i]);
            if(prev == null){
                prev = node;
                head = node;
            }
            else{
                prev.next = node;
                prev = prev.next;
            }
        }

        return head;
    }

    public static String printList(ListNode node) {
        StringBuilder sb = new StringBuilder();

        while(node != null){
            sb.append(node.val+" ---> ");
            node = node.next;
        }

        sb.append("null");
        return sb.toString();
    }
}
