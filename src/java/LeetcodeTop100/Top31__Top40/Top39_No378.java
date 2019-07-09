package LeetcodeTop100.Top31__Top40;

import java.util.*;
import java.util.function.Consumer;

/**
 * @Name : 有序矩阵中第K小的元素
 * @Level : Medium
 * @Author : Chris
 * @Date : 2019年07月01日15时00分
 *
 * @题目描述 : 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 *
 * @链接 : https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 *
 * @示例 :  matrix = [
 *                      [ 1,  5,  9],
 *                      [10, 11, 13],
 *                      [12, 13, 15]
 *                  ],
 *          k = 8,
 *
 *         返回 13。
 *
 * @思路 : 1、利用优先队列，维持一个大小为k的堆，这样将所有元素添加到堆内后，将堆顶的元素pop出来就是第k小的元素。注意在定义
 *            优先队列的时候，传入比较器为((o1,o2) -> o2-o1),这样的话堆得定义就是最小的元素存储在堆底。
 *         2、使用二分查找
 *            一看到查找，第一时间不是想到遍历，而是怎么二分，能大大降低时间复杂度。首先二分法的上界是矩阵右下角元素，下界是矩阵
 *            左上角元素。
 *            每次二分的时候，设定mid为两个边界的平均值。统计本次矩阵中比mid小的元素的个数。如果cnt > k，则代表上界过大，令mid为
 *            新的上界，反之令mid为新的下界。
 *            统计矩阵中比mid小或等于的元素的方法：
 *              a) 使用upper_bound，即对矩阵每一行进行二分，查找比mid大的元素的个数，再累加。
 *              b) 分析矩阵的特点，从左下角开始，按列分析，如果当前值大于target，则减小行数，反之增加列数并将该列的行数加到cnt。
 *
 *
 **/

public class Top39_No378 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(kthSmallest_2(arr,8));
    }

    private static int kthSmallest_2(int[][] matrix, int k) {
        int left = matrix[0][0], right = matrix[matrix.length - 1][matrix.length - 1];
        while(left < right){
            int mid = left + (right - left)/2;
            int cnt = countLessOrEquals(matrix, mid);
            if(cnt < k)    //代表当前的mid太小了，没有找到足够多比他小的数
                left = mid + 1;
            else
                right = mid; //mid太大，
        }
        return left;
    }

    private static int countLessOrEquals(int[][] matrix, int mid){
        int i = matrix.length - 1, j = 0, cnt = 0;
        while(i >= 0 && j < matrix[0].length){
            if(matrix[i][j] <= mid){
                cnt += i + 1;
                j++;
            }
            else
                i--;
        }
        return cnt;
    }

    private static int upper_bounr(int begin, int end, int tar){
        while(begin < end){
            int mid = begin + (end - begin)/2;

        }
        return 0;
    }


    private static int kthSmallest_1(int[][] matrix, int k) {
        //维护一个优先队列，其元素存储的是大的元素放在堆底，小的元素放在堆顶。
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int[] matrix1 : matrix) {
            for (int i : matrix1) {
                queue.add(i);
                if(queue.size() > k)
                    queue.poll();
            }
        }

        return queue.peek();

    }

}
