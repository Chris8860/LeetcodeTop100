package LeetcodeTop100.Top11__Top20;

import org.w3c.dom.ls.LSException;

import java.util.logging.Level;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @link ：https://leetcode-cn.com/problems/merge-two-sorted-lists
 *
 * @思路 ：这题比较简单，直接一次遍历两个链表即可，比较过程中判断大小，出现某个链表为空时停止。
 * */

public class Top14_No21 {
    public static void main(String[] args) {

        ListNode a = new ListNode(2);
        a.next = new ListNode(4);
        a.next.next = new ListNode(7);
        ListNode b = new ListNode(1);
        b.next = new ListNode(3);
        b.next.next = new ListNode(6);
        ListNode res = mergeByRecursion(a,b);
    }

    static ListNode mergeByRecursion(ListNode l1, ListNode l2){
        if(l1 == null)
            return l2;
        else if(l2 == null)
            return l1;
        else if(l1.val > l2.val) {
            l2.next = mergeByRecursion(l1, l2.next);
            return l2;
        }
        else {
            l1.next = mergeByRecursion(l1.next, l2);
            return l1;
        }
    }

    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode t = res;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val) {
                res.next = l2;
                l2 = l2.next;
            }
            else {
                res.next = l1;
                l1 = l1.next;
            }
            res = res.next;
        }
        res.next = l1 == null ? l2 : l1;
        return t.next;

    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
        }
    }
}
