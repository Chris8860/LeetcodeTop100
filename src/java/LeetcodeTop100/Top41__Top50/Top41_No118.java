package LeetcodeTop100.Top41__Top50;

import java.util.ArrayList;
import java.util.List;

/**
 * @Name : 杨辉三角
 * @Level : Esay
 * @Author : Chris
 * @Date : 2019年07月09日20时03分
 *
 * @题目描述 : 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * @链接 : https://leetcode-cn.com/problems/pascals-triangle/
 *
 * @示例 : 输入: 5
 *         输出:
 *         [
 *              [1],
 *             [1,1],
 *            [1,2,1],
 *           [1,3,3,1],
 *          [1,4,6,4,1]
 *        ]
 *
 * @思路 : 要求按行生成杨辉三角的前指定行数，显然是直接从上往下进行生成了。对于每两个相邻的链表list1与list2，有
 *         list2[i] = list1[i-1] + list1[i];同时list2[0] = list2[len - 1] = 1;
 *
 *
 **/

public class Top41_No118 {
    public static void main(String[] args) {

        List<List<Integer>> data = generate(5);
        for(List<Integer> list : data){
            for(int i : list)
                System.out.println(i);
        }
    }

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lis = new ArrayList<>();
        for(int i = 1; i <= numRows; ++i){
            List<Integer> list = new ArrayList<>(i);
            if(i == 1)
                list.add(1);
            else if(i == 2) {
                list.add(1);
                list.add(1);
            }
            else{
                list.add(1);
                for(int j = 0; j < i-2; ++j){
                    int tmp = lis.get(i - 2).get(j) + lis.get(i - 2).get(j + 1);
                    list.add(tmp);
                }
                list.add(1);
            }
            lis.add(list);
        }
        return lis;
    }

}
