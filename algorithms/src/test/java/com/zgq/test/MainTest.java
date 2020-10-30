package com.zgq.test;

import com.zgq.list.ListNode;
import com.zgq.list.RemoveListNodeOperations;
import org.junit.Test;

public class MainTest {
    @Test
    public  void mainTest() {
        int[] arr = {1,3,5,7,9,11};
        ListNode head = new ListNode(arr);
        RemoveListNodeOperations remOperations = new RemoveListNodeOperations();
        ListNode newHead = remOperations.removeNthListNodeFromEnd(head,2);
        System.out.println(new ListNode().getListNodeStr(newHead));
    }

}
