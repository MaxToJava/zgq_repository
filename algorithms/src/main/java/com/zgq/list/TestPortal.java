package com.zgq.list;

import org.junit.Test;

/**
 * TODO
 *
 * @author zgq
 * @date 2020/10/30
 */
public class TestPortal {

    @Test
    public void testPortal(){
        int[] arr = {1,3,5,7,11};
        ListNode head = new ListNode(arr);
        RemoveListNodeOperations remOperations = new RemoveListNodeOperations();
        ListNode newHead = remOperations.removeNthListNodeFromEnd(head,2);
        System.out.println(new ListNode().getListNodeStr(newHead));
    }
}
