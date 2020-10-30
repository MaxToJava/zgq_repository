package com.zgq.list;

/**
 * TODO
 *
 * @author zgq
 * @date 2020/10/30
 */
public class ListNode {
    ListNode next;
    int value;

    public ListNode() {

    }

    public ListNode(int val) {
        this.value = val;
    }

    public ListNode(int val, ListNode next) {
        this.value = val;
        this.next = next;
    }

    /**
     * 通过一个数组构建一个单向链表
     * @param arr
     */
    public ListNode(int[] arr) {
        int arrLength = arr.length;
        if (arr == null || arrLength == 0) {
            throw new IllegalArgumentException("arr can to be empty");
        }
        this.value=arr[0];
        ListNode cur = this;
        for(int i=1;i<arrLength;i++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    /**
     * 将链表以字符串的方式输出
     * @return
     */
    public String getListNodeStr(ListNode head){

        if(head == null){
            return "";
        }
        StringBuilder builder = new StringBuilder();
        ListNode tmp = head;
        int i=0;
        while(tmp!=null){
            i++;
            builder.append(tmp.value);
            builder.append("->");
            tmp = tmp.next;
        }

        builder.append("NULL");
        return builder.toString();
    }
}
