package LeetcodeTop100.Top21__Top30;

import java.util.List;

/**
 * @Name : 合并K个排序链表
 * @Level : Hard
 * @Author : Chris
 * @Date : 2019年06月24日00时51分
 * 
 * @题目描述 : 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * @链接 : https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *
 * @示例 : 输入:
 *          [
 *              1->4->5,
 *              1->3->4,
 *              2->6
 *          ]
 *          输出: 1->1->2->3->4->4->5->6
 *
 * @思路 : 1、基于合并两个排序的链表，直接对k个链表进行两两合并，时间复杂度为O(kN)，k是链表长度，N为链表中总节点数。
 *         2、将链表数组分为左右两部分，利用分治法，先处理左边，在处理右边，依次往下递归。时间复杂度为O(Nlog(k))
 *
 */
public class Top26_No23 {
    public static void main(String[] args) {
        ListNode a = new ListNode(0);
        a.next = new ListNode(3);
        a.next.next = new ListNode(6);
        ListNode b = new ListNode(1);
        b.next = new ListNode(4);
        b.next.next = new ListNode(5);
        ListNode c = new ListNode(2);
        c.next = new ListNode(5);
        c.next.next = new ListNode(7);

        ListNode test = mergeTwoLists(a,b);
        ListNode[] lis = {a,b,c};
        ListNode data = mergeKLists(lis);
        ListNode data2 = mergeKLists_2(lis);


        while(data != null){
            System.out.println(data.val);
            data = data.next;
        }

        while(data2 != null){
            System.out.println(data2.val);
            data2 = data2.next;
        }
    }

    private static ListNode mergeKLists_2(ListNode[] lists){
        if(lists == null || lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        if(lists.length == 2) return mergeTwoLists(lists[0], lists[1]);

        return merge(lists, 0, lists.length - 1);
    }


    private static ListNode merge(ListNode[] lists, int le, int ri){
        if(lists == null || lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        if(lists.length == 2) return mergeTwoLists(lists[0], lists[1]);

        if(le == ri) return lists[le];
        if(ri - le == 1) return mergeTwoLists(lists[le], lists[ri]);

        int mid = le + (ri - le)/2;
        ListNode Left = merge(lists, le, mid);
        ListNode Right = merge(lists, mid + 1, ri);

        return mergeTwoLists(Left, Right);
    }


    /**
     * @Description: 合并k个排序链表
     * @Param: [lists 链表头结点列表]
     * @return: ListNode
     * @Author: Chris
     * @Date: 2019/6/25
     */
    private static ListNode mergeKLists(ListNode[] lists) {

        ListNode res = mergeTwoLists(lists[0],lists[1]);
        for(int i = 2; i < lists.length; ++i){
            res = mergeTwoLists(res,lists[i]);
        }

        return res;
    }


    /**
     * @Description: 合并两个排序链表
     * @Param: [a 链表头结a, 链表头结点b]
     * @return: ListNode
     * @Author: Chris
     * @Date: 2019/6/25
     */
    private static ListNode mergeTwoLists(ListNode a, ListNode b){
        if(a == null) return b;
        if(b == null) return a;
        ListNode res = new ListNode(0);
        ListNode help = res;
        while(a != null && b != null){
            if(a.val > b.val){
                help.next = new ListNode(b.val);
                help = help.next;
                b = b.next;
            }
            else{
                help.next = new ListNode(a.val);
                help = help.next;
                a = a.next;
            }
        }
        if(a == null && b != null)
            help.next = b;
        else if(a != null && b == null)
            help.next = a;
        return res.next;
    }


    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
}
