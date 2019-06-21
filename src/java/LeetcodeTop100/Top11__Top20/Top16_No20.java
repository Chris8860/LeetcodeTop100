package LeetcodeTop100.Top11__Top20;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *     注意空字符串可被认为是有效字符串。
 *
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * */

public class Top16_No20 {
    public static void main(String[] args) {
        String s = "[]{}()[{()}";
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s){
        if(s.length() == 0)
            return true;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if(c == '[')
                stack.push(']');
            else if(c == '{')
                stack.push('}');
            else if(c == '(')
                stack.push(')');
            else{
                if(stack.isEmpty() || c != stack.pop())  //为什么判断stack是否为空？防止第一个出现的字符时] } ).
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
