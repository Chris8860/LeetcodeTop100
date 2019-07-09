package LeetcodeTop100.Top31__Top40;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Name : 二叉树的最近公共祖先
 * @Level : Medium
 * @Author : Chris
 * @Date : 2019年07月01日14时58分
 *
 * @题目描述 : 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * @链接 : https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @示例 :
 *
 * @思路 : 1、较为复杂的递归方式。本题的目的就是寻找一个二叉树节点，其本身同时包含pq，但是左子树与右子树不同时包含pq。
 *           使用递归的方式从根节点开始遍历，寻找这样一个节点。注意判断是否包含可以采用任意一种对二叉树的遍历方式。
 *         2、使用递归的思想，对于根节点，分析其左右子节点。对左右子节点分别求关于pq的最近公共祖先。此时就要注意循环的结束
 *            条件，当遇到节点为null或者为pq是都返回节点本身。
 *            那么当左右子节点搜索出来的最近公共祖先都不为空，代表左右中都至少含有一个pq。反之有一个为空的话，代表pq都在左
 *            子树或者右子树中，就直接返回左右子树的搜索结果即可。
 *
 *
 **/


public class Top33_No236 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(7);
        root.right.right = new TreeNode(8);

        LinkedList<Integer> res = postOrder(root);

        for(int i : res)
            System.out.println(i);

    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)
            return root;
        return left == null ? right : left;

    }

    //后序遍历，实际转换为中右左，利用addFirst方法。
    private static LinkedList<Integer> postOrder(TreeNode root){
        if(root == null) return null;
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode help = root;
        while(help != null || !stack.isEmpty()){
            if(help != null) {
                stack.push(help);
                list.addFirst(help.val);
                help = help.right;
            }
            else {
                help = stack.pop();
                help = help.left;
            }
        }
        return list;
    }


    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

}
