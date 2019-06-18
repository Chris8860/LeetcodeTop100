package LeetcodeTop100.Top1__Top10;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。水。
 *
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 *
 * @思路 :1、以层为单位进行分析，对于每一层，统计能够放入多少水。对于第一层，就是统计有多少个夹在1中间的0.对于第二层，就是统计
 *        有多少夹在2中间的1.依次一直统计到最后一层，也就是最高层。
 *
 *        2、方法1中是按照行来求，换一种思路，按照列来解算？求出每一个位置上能够放多少水。对于每一个位置，其上能够放的水为：
 *        min(left_max, right_max) - height[i];问题变成，如何求解每个位置左右最大的值？
 *
 *
 * */


public class Top5_No42 {

    public static void main(String[] args) {

        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap1(arr));
    }


    //
    static int trap2(int[] height){

        return 0;
    }





    //way 1:依次统计每一层能够装多少水，原理就是将每一层转为0 1数组，统计有多少个0在1中间。此方法只有最后一个测试用例没有通过。
    static int trap1(int[] height){
        int[] back = Arrays.copyOf(height,height.length);
        int[] help = new int[height.length];
        Arrays.sort(back);
        int maxHeight = back[back.length - 1];
        int water = 0;
        if(maxHeight < 1) return 0;
        for(int i = 1; i <= maxHeight; ++i){
            for(int j = 0; j < height.length; ++j){  //将数组转为01数组，统计有多少0在1中间即可。
                if(height[j] >= i)
                    help[j] = 1;
            }
            water += cal(help);
            Arrays.fill(help,0);
        }
        return water;
    }

    //用于计算01数组中有多少个0在1中间
    static int cal(int[] arr){
        boolean meetone1 = false;
        int cur0 = 0;
        int total0 = 0;
        for(int i = 0; i < arr.length; ++i){
            if(arr[i] == 0){
                if(meetone1)
                    cur0++;
            }
            else{
                if(!meetone1)
                    meetone1 = true;
                else{
                    total0 += cur0;
                    cur0 = 0;
                }
            }
        }
        return total0;
    }


}
