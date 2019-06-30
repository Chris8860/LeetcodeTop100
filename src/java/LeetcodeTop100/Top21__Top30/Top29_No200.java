package LeetcodeTop100.Top21__Top30;

import java.util.Stack;

/**
 * @Name : 岛屿数量
 * @Level : Medium
 * @Author : Chris
 * @Date : 2019年06月30日22时37分
 * @题目描述 : 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直
 *            方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * @链接 : https://leetcode-cn.com/problems/number-of-islands
 *
 * @示例 :输入:
 *          11000
 *          11000
 *          00100
 *          00011
 *       输出: 3
 *
 * @思路 : 经典的DFS题目，将二维矩阵看做一个图，使用深度搜索，每一次搜索都要找到相连的所有1，并全部置为0。对于DFS一般有两种写法：
 *         1、递归法。
 *         2、基于系统自定义栈。
 *
 *
 **/

public class Top29_No200 {
    public static void main(String[] args) {

        char[][] arr = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(numIslands_2(arr));
    }

    private static int numIslands_1(char[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[i].length; ++j){
                if(grid[i][j] == '1') {
                    res++;
                    Stack<int[]> stack = new Stack<>();
                    int[] tmp = {i ,j};
                    stack.push(tmp);
                    while(!stack.isEmpty()){
                        int[] cur = stack.pop();
                        if(grid[cur[0]][cur[1]] == '1') {
                            grid[cur[0]][cur[1]] = '0';
                            int[] a = new int[]{cur[0] + 1, cur[1]};
                            int[] b = new int[]{cur[0] - 1, cur[1]};
                            int[] c = new int[]{cur[0], cur[1] + 1};
                            int[] d = new int[]{cur[0], cur[1] - 1};
                            if(isValid(a[0], a[1], grid)) stack.add(a);
                            if(isValid(b[0], b[1], grid)) stack.add(b);
                            if(isValid(c[0], c[1], grid)) stack.add(c);
                            if(isValid(d[0], d[1], grid)) stack.add(d);
                        }
                    }
                }
            }
        }
        return res;
    }

    private static int numIslands_2(char[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if(grid[i][j] == '1') {
                    dfs(i, j, grid);
                    res++;
                }
            }
        }
        return res;
    }

    private static void dfs(int i, int j, char[][] grid){
        if(isValid(i, j, grid)){
            grid[i][j] = '0';
            dfs(i + 1, j, grid);
            dfs(i - 1, j, grid);
            dfs(i, j + 1, grid);
            dfs(i, j - 1, grid);
        }
    }

    private static boolean isValid(int i, int j, char[][] grid){
        return i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] != '0';
    }



}
