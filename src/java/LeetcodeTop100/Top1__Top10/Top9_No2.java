package LeetcodeTop100.Top1__Top10;

import java.util.List;

/**
 * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字0之外，这两个数都不会以0开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * @date : 2019年6月20日13:08:59
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 *
 * @思路 : 这题就是把一个加法给拆成了两个链表，再让你加。注意链表已经倒序了，因此直接从前往后加即可，满足加法从低到高的规则。
 *         比较难的是边界判断，一直要注意，有哪个链表没数了。while循环可以在两个链表均为空时退出。
 *
 * */
public class Top9_No2 {

    public static void main(String[] args) {

        ListNode a = new ListNode(2);
        a.next = new ListNode(4);
        a.next.next = new ListNode(3);
        ListNode b = new ListNode(5);
        b.next = new ListNode(6);
        b.next.next = new ListNode(4);
        addTwoNumbers(a,b);
    }

    static public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode help = res;
        boolean flag = false;
        while (l1 != null || l2 != null){
            if(flag) {
                if(l1 == null) {
                    help.val = (l2.val + 1) % 10;
                    flag = (l2.val + 1) > 9;
                    l2 = l2.next;

                }
                else if(l2 == null){
                    help.val = (l1.val + 1) % 10;
                    flag = (l1.val + 1) > 9;
                    l1 = l1.next;
                }
                else{
                    help.val = (l1.val + l2.val + 1) % 10;
                    flag = (l1.val + l2.val + 1) > 9;
                    l1 = l1.next;
                    l2 = l2.next;
                }
            }
            else {
                if(l1 == null) {
                    help.val = l2.val;
                    l2 = l2.next;
                }
                else if(l2 == null){
                    help.val = l1.val % 10;
                    l1 = l1.next;
                }
                else{
                    help.val = (l1.val + l2.val) % 10;
                    flag = (l1.val + l2.val) > 9;
                    l1 = l1.next;
                    l2 = l2.next;
                }
            }
            if(l1 == null && l2 == null && !flag )
                break;
            else {
                help.next = new ListNode(0);
                help = help.next;
            }
        }
        if(flag)
            help.val = 1;
        return res;
    }

    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int x){
            this.val = x;
        }
    }

}
