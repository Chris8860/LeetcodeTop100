package LeetcodeTop100.Top1__Top10;

/**
 *反转一个单链表。
 *
 * @示例 ：
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 *
 * @思路 :本题难度不大，仔细分析一个单链表的结构，显然是从前向后的链接顺序，因此只需要将从前向后处理，断开原来的链接，添加新链接。
 *        需要维持两个变量，一个是prev，一个是cur。prev开始指向null，而cur指向head。从前往后，一直遍历到cur为null即可，返回prev。
 *
 * */


public class Top4_No206 {
    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        a.next = new ListNode(5);
        a.next.next = new ListNode(6);
        a.next.next.next = new ListNode(7);
        Top4_No206 s = new Top4_No206();
        a = s.reverseList(a);
        while(a != null) {
            System.out.println(a.val);
            a = a.next;
        }
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
