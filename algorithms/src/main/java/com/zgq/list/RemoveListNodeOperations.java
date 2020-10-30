package com.zgq.list;

import org.junit.Test;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * @author zgq
 * @date 2020/10/30
 */
public class RemoveListNodeOperations {


    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点
     *
     * @param head
     * @param N
     * @return
     */
   public ListNode removeNthListNodeFromEnd(ListNode head, int N) {

        if (head == null || N <= 0) {
            return head;
        }

        //创建一个虚拟头结点
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        //创建两个指针p，q
        ListNode p = tempHead, q = tempHead;

        //p比q多跑了N个长度
        for (int i = 0; i < N; i++) {
            if (p == null) {
                return head;
            } else {
                p = p.next;
            }
        }

        //两个指针一起向后运行，不过它们的起始点不同，当p运行到最后时，q.next就是要删除的元素
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }

        q.next = q.next.next;
        return head;
    }


}
