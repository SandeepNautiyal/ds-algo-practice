package com.dsalgo.practice.solutions;

/**
 * Input List - 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 reverse between 3,5
 * Result List - 1 -> 2 -> 5 -> 4 -> 3 -> 6 -> 7
 */
public class ReverseLinkedListPortion {

    private ListNode m_minus_one_node = null;
    private ListNode mth_node = null;
    private ListNode reverse_portion_head = null;
    private ListNode reverse_portion_heads_next_node = null;
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int count = 1;
        ListNode prev = null;
        ListNode resultHead = head;

        while(head != null && count < m){
            prev = head;
            head = head.next;
            count++;
        }

        m_minus_one_node = prev;
        mth_node = head;

        reverseList(mth_node, n-m+1);

        if(m == 1){
            resultHead = reverse_portion_head;
            mth_node.next = reverse_portion_heads_next_node;
        }
        else{
            m_minus_one_node.next = reverse_portion_head;
            mth_node.next = reverse_portion_heads_next_node;
        }

        return resultHead;
    }

    private void reverseList(ListNode portionHead, int nodesToBeReversed) {
        int count = 1;
        ListNode prev = null;

        while(portionHead != null && count <= nodesToBeReversed){
            ListNode temp = portionHead.next;
            portionHead.next = prev;
            prev = portionHead;
            portionHead = temp;
            count++;
        }

        reverse_portion_head = prev;
        reverse_portion_heads_next_node = portionHead;
    }


}