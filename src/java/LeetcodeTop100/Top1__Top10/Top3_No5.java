package LeetcodeTop100.Top1__Top10;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 *
 * 思路：首先注意回文串是中心对称的，因此需要从中间往两边搜索，同时回文串长度可能为奇数也可能为偶数，因此要综合考虑。
 * 比如以i,i为左右搜索的起始，则需要一次搜索出该中心对应的最长回文子串，与一个全局的变量做对比，更长则更新。
 *
 * */



public class Top3_No5 {
    public static void main(String[] args) {

    }

    private static String res = "";
    public static String longestPalindrome(String s) {
        if(s.length() < 2)
            return s;
        for(int i = 0; i < s.length(); ++i){
            isPalindrome(s, i, i);
            isPalindrome(s, i, i + 1);
        }

        return res;
    }

    //遍历搜索以i,j为中心的子字符串的最大回文子串
    public static void isPalindrome(String s, int i, int j){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        res = j - i - 1 <= res.length() ? res : s.substring(i + 1, j);
    }


}
