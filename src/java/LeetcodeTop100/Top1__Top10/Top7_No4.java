package LeetcodeTop100.Top1__Top10;

/**
 * 4. 寻找两个有序数组的中位数
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 *
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 *
 * @思路 :注意本题，寻找一个中位数，中位数的作用是其左右两边的数组长度相等而且左边的均小于右边的。
 *       考虑将A数组分为两部分A[0]...A[i-1]---A[i]...A[m-1]、同理B数组分为B[0]...B[j-1]---B[j]...B[n-1].
 *       将A与B的左半边放一起，称为left_part，同理右半边为right_part，因此需要满足以下条件：
 *              1、i + j = m + n - i - j (当m + n为奇数时将右边+1:m + n - i -j + 1) 表示左右两边数字数量相等。
 *                 如果 n >= m, 我们需要: i = 0 ~ m, j = (m + n + 1)/2 - i，这一点需要人为满足。
 *              2、A[i-1] < B[j] && B[j-1] < A[i] 表示左边部分与右边部分数量相等。
 *       所以我们要做的是：在0...m之间搜索一个i，使其满足：
 *              A[i-1] < B[j] && B[j-1] < A[i]  其中：j = (m + n + 1)/2 - i;
 *       因此我们需要在A中进行二分搜索，找到满足上述条件的i，二分搜索的步骤如下：
 *              1、设置二分范围为：i_min = 0，i_max = m
 *              2、先另i = (i_min + i_max)/2，并且此时：j = (m + n + 1)/2 - i;
 *              3、比较A[i-1] < B[j] && B[j-1] < A[i]是否满足，则可能出现如下3种情况：
 *                 a):满足上诉条件，则直接找到了最终的i。
 *                 b):有A[i-1] > B[j]，代表i太大了，此时应该i_max = i - 1;
 *                 c):有A[i-1] < B[j]，代表i太小了，应该有i_min = i + 1;
 *              4、当找到了满足条件的i时，应该有中位数为：
 *                 当(m + n)为奇数时，则median = max(A[i-1], B[j -1])
 *                 当(m + n)为偶数时，则median = (max(A[i-1], B[j -1]) + min(A[i], B[j]))/2
 *
 *       额外的边界条件考虑：显然题目只保证了其中一个数组不为空，因此可能出现A[i-1],B[j-1],A[i],B[j] 不存在的情况。
 *       但是根据我们的算法，我们需要保证的是：max(left_part) < min(right_part),数量根据i与j的算法肯定是满足相等的。
 *          a.当算法解得的i不是0或者m时，则代表四个边界均存在，因此要满足:A[i-1] < B[j] && B[j-1] < A[i]。
 *          b.当算法解得的i为下界0时，则有A[i-1]不存在，因此只需要比较:B[j-1] < A[i]。
 *          c.当算法解得的i为上界m是，则有A[i]不存在，因此只需要比较：A[i-1] < B[j]。
 *          以代码描述如下：<a> (j == 0 or i == m or B[j-1] <= A[i]) && (i == 0 or j = n or A[i-1] <= B[j])
 *                             Means i is perfect, we can stop searching.
 *
 *                         <b> j > 0 and i < m and B[j - 1] > A[i]
 *                             Means i is too small, we must increase it.
 *
 *                         <c> i > 0 and j < n and A[i - 1] > B[j]
 *                             Means i is too big, we must decrease it.
 *          注意：i < m ==> j > 0 and i > 0 ==> j < n
 *                  m <= n, i < m ==> j = (m+n+1)/2 - i > (m+n+1)/2 - m >= (2*m+1)/2 - m >= 0
 *                  m <= n, i > 0 ==> j = (m+n+1)/2 - i < (m+n+1)/2 <= (2*n+1)/2 <= n
 *
 * */

public class Top7_No4 {

    public static void main(String[] args) {
        int[] a = {2,4,6,8,9};
        int[] b = {1,4,5,7,9};
        System.out.println(findMedianSortedArrays(a,b));
    }

    static public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A, B;
        int m, n;
        if(nums1.length <= nums2.length){
            A = nums1;
            B = nums2;
            m = nums1.length;
            n = nums2.length;
        }
        else{
            A = nums2;
            B = nums1;
            m = nums2.length;
            n = nums1.length;
        }
        int i_min = 0, i_max = m;
        int i = 0, j = 0;
        double maxOfLeft, minOfRight;
        while(true){
            i = i_min + (i_max - i_min)/2;
            j = (m + n + 1)/2 - i;
            if(i < m  && B[j - 1] > A[i])
                i_min = i + 1;
            else if(i > 0 && A[i - 1] > B[j])
                i_max = i - 1;
            else{               //这种情况下，i就是所要求的位置
                if(i == 0)
                    maxOfLeft = B[j-1];
                else if(j == 0)
                    maxOfLeft = A[i-1];
                else
                    maxOfLeft = Math.max(A[i-1],B[j-1]);
                if((m + n) % 2 == 1)
                    return maxOfLeft;
                if(i == m)
                    minOfRight = B[j];
                else if(j == n)
                    minOfRight = A[i];
                else
                    minOfRight = Math.min(A[i], B[j]);
                return (maxOfLeft + minOfRight)/2;
            }
        }
    }

}
