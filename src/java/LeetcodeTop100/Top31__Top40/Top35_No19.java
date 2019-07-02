package LeetcodeTop100.Top31__Top40;

/**
 * @Name : 删除链表的倒数第N个节点
 * @Level : Medium
 * @Author : Chris
 * @Date : 2019年07月01日14时59分
 *
 * @题目描述 : 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。给定的 n 保证是有效的。
 *
 * @链接 : https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @示例 : 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *        当删除了倒数第二个节点后，链表变为 1->2->3->5
 *
 * @思路 : 设计一把尺子，长度为n+1，尺子向后移动，使尺子前部指向要被删除的节点的前面。
 *
 *
 **/

public class Top35_No19 {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode l2 = removeNthFromEnd(l1,4);
        System.out.println(111);
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode help = head, start = head;
        for(int i = 0; i < n; ++i){
            help = help.next;
        }
        //辅助节点为null，则代表要删除的是第一个节点
        if(help == null)
            return head.next;
        while(help.next != null){
            help = help.next;
            start = start.next;
        }
        //尺子头部指向的就是要被删除的节点的前一个节点。
        start.next = start.next.next;
        return head;
    }

    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

}
