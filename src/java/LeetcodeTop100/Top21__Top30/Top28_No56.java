package LeetcodeTop100.Top21__Top30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Name : 合并区间
 * @Level : Medium
 * @Author : Chris
 * @Date : 2019年06月24日00时55分
 * 
 * @题目描述 : 给出一个区间的集合，请合并所有重叠的区间。
 *
 * @链接 : https://leetcode-cn.com/problems/merge-intervals/
 *
 * @示例 : 输入: [[1,3],[2,6],[8,10],[15,18]]
 *         输出: [[1,6],[8,10],[15,18]]
 *         解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * @思路 : 方法一、首先对二维数组排序，按照(先比较第一个值大小，在比较第二个值大小)进行排序。排序过后，区间即变为一种有序的样子。
 *         排序完之后，即从前往后进行遍历，对于相邻两个区间的合并，分为几种情况：
 *           1、一个区间被另一个区间所全包含，此时返回较大的区间即可。
 *           2、两个区间有交叉，返回左区间左界 + 右区间右界即可。
 *           3、完全没有重合，即: 左区间右界 < 右区间左界。
 *         方法二、不要拘泥于区间这个概念，不如直接考虑将区间左界取为一个数组，区间右界取为一个数组。对两个数组进行排序，问题即
 *         变为，用这两个边界数组能够组成多少个区间？从前往后遍历两个数组，进行拼接的过程中，就是将右界与左界的下一个值进行比较，
 *         当出现左边界大于右边界时，代表出现断层，将前面的合并为一个区间后添加进结果，后续继续开始合并。
 *
 */
public class Top28_No56 {
    public static void main(String[] args) {

        int[][] arr = {{0,2},{0,1},{2,3},{1,3},{5,6},{8,10}};
        arr = merge(arr);
        System.out.println(arr);


    }

    private static int[][] merge_2(int[][] intervals){
        if(intervals.length < 2) return intervals;
        int[] left = new int[intervals.length];
        int[] right = new int[intervals.length];
        for(int i = 0; i < intervals.length; ++i){
            left[i] = intervals[i][0];
            right[i] = intervals[i][1];
        }
        Arrays.sort(left);
        Arrays.sort(right);
        List<int[]> res = new ArrayList<>();
        for(int i = 0, j = 0; i < intervals.length; ++i){
            //代表出现断层，或者遍历到了最后一个边界，就直接将其添加。
            if(i == intervals.length - 1 || left[i + 1] > right[i]) { // 右界与左界下一个值进行比较。
                res.add(new int[]{left[j], right[i]});
                j = i + 1;  //只有在进行了一次更新后，当前左界才更新。
            }
        }
        return res.toArray(new int[res.size()][2]);
    }

    private static int[][] merge(int[][] intervals) {
        if(intervals.length < 2) return intervals;
        Arrays.sort(intervals, (o1, o2) -> {         //先比较区间的第一个值，在比较第二个值。按照升序处理。
            if(o1[0] == o2[0]){                      //compare方法，o1 - o2为升序，反之为降序。
                return Integer.compare(o1[1], o2[1]);
            }
            else if(o1[0] > o2[0])
                return 1;
            else
                return -1;
        });
        List<int[]> res = new ArrayList<>();
        int[] left = intervals[0];
        for(int i = 1; i < intervals.length; ++i){
            int[] right = intervals[i];
            List<int[]> tmp = mergeTwo(left, right);
            if(tmp.size() == 1){  //代表合并成功
                left = tmp.get(0);
            }
            else {  //代表合并失败，则将左区间加入结果中，右区间继续与后面的区间合并
                res.add(left);
                left = right;
            }
        }
        res.add(left);  //将剩余的right加入结果中
        int[][] arr = new int[res.size()][2];
        for(int i = 0; i < res.size(); ++i)
            arr[i] = res.get(i);

        return arr;
    }

    private static List<int[]> mergeTwo(int[] a, int[] b){
        List<int[]> res = new ArrayList<>();
        if(a[0] <= b[0] && a[1] >= b[1])
            res.add(a);
        else if(a[0] > b[0] && a[1] < b[1])
            res.add(b);
        else if(a[1] < b[0] || a[0] > b[1]){
            res.add(a);
            res.add(b);
        }
        else{
            int[] arr = {Math.min(a[0], b[0]), Math.max(a[1], b[1])};
            res.add(arr);
        }

        return res;
    }
}
