package LeetcodeTop100.Top31__Top40;

import java.util.ArrayList;
import java.util.List;

/**
 * @Name : 括号生成
 * @Level : Medium
 * @Author : Chris
 * @Date : 2019年07月01日14时59分
 *
 * @题目描述 : 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * @链接 : https://leetcode-cn.com/problems/generate-parentheses/
 *
 * @示例 : 给出 n = 3，生成结果为：
 *          [
 *              "((()))",
 *              "(()())",
 *              "(())()",
 *              "()(())",
 *              "()()()"
 *          ]
 *
 * @思路 : 类似于全排列的题目，肯定是要用到回溯法。根据当前的左括号、右括号与总括号对数关系来决定递归方向。回溯过程中，依次
 *         判断open个数与n大小关系，close个数与open大小关系。
 *
 *
 **/

public class Top36_No22 {
    public static void main(String[] args) {
        Top36_No22 b = new Top36_No22();
        List<String> res = b.generateParenthesis(4);
        for(String s : res)
            System.out.println(s);
    }

    int max;
    private List<String> generateParenthesis(int n) {
        max = n * 2;
        List<String> list = new ArrayList<>();
        String sb = "";
        backtrace(list, 0, 0, sb);
        return list;
    }

    private void backtrace(List<String> res, int open, int close, String cur){
        if(cur.length() == max)
            res.add(cur);
        else{
            if(open < max/2)
                backtrace(res, open + 1, close, cur + "(");
            if(close < open)
                backtrace(res, open, close + 1, cur + ")");
        }
    }





}
