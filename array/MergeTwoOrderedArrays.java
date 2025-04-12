package array;

import java.util.Arrays;

/** 合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */
public class MergeTwoOrderedArrays {

    /**
     * 我的解法
     */
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {

            int pointer1 = m - 1;
            int pointer2 = n - 1;

            for (int position = m + n - 1; position >= 0; position--) {
                if (pointer2 < 0)
                    break;

                if (pointer1 < 0) {
                    for (int i = pointer2; i >= 0; i--) {
                        nums1[i] = nums2[i];
                    }
                    break;
                }

                if (nums1[pointer1] > nums2[pointer2]) {
                    nums1[position] = nums1[pointer1];
                    pointer1--;
                } else {
                    nums1[position] = nums2[pointer2];
                    pointer2--;
                }
            }

        }
    }

    /**
     * 直接合并后排序
     * 最直观的方法是先将数组 nums
     * 2
     * ​
     *   放进数组 nums
     * 1
     * ​
     *   的尾部，然后直接对整个数组进行排序。
     */
    class Solution1 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            for (int i = 0; i != n; ++i) {
                nums1[m + i] = nums2[i];
            }
            Arrays.sort(nums1);

        }
    }

    /**
     * 方法二：双指针
     * 算法
     *
     * 方法一没有利用数组 nums
     * 1
     * ​
     *   与 nums
     * 2
     * ​
     *   已经被排序的性质。为了利用这一性质，我们可以使用双指针方法。这一方法将两个数组看作队列，每次从两个数组头部取出比较小的数字放到结果中。如下面的动画所示：
     */
    class Solution2 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1 = 0, p2 = 0;
            int[] sorted = new int[m + n];
            int cur;
            while (p1 < m || p2 < n) {
                if (p1 == m) {
                    cur = nums2[p2++];
                } else if (p2 == n) {
                    cur = nums1[p1++];
                } else if (nums1[p1] < nums2[p2]) {
                    cur = nums1[p1++];
                } else {
                    cur = nums2[p2++];
                }
                sorted[p1 + p2 - 1] = cur;
            }
            for (int i = 0; i != m + n; ++i) {
                nums1[i] = sorted[i];
            }
        }
    }

    /**
     * 方法三：逆向双指针
     * 算法
     *
     * 方法二中，之所以要使用临时变量，是因为如果直接合并到数组 nums
     * 1
     * ​
     *   中，nums
     * 1
     * ​
     *   中的元素可能会在取出之前被覆盖。那么如何直接避免覆盖 nums
     * 1
     * ​
     *   中的元素呢？观察可知，nums
     * 1
     * ​
     *   的后半部分是空的，可以直接覆盖而不会影响结果。因此可以指针设置为从后向前遍历，每次取两者之中的较大者放进 nums
     * 1
     * ​
     *   的最后面。
     */

    class Solution3 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1 = m - 1, p2 = n - 1;
            int tail = m + n - 1;
            int cur;
            while (p1 >= 0 || p2 >= 0) {
                if (p1 == -1) {
                    cur = nums2[p2--];
                } else if (p2 == -1) {
                    cur = nums1[p1--];
                } else if (nums1[p1] > nums2[p2]) {
                    cur = nums1[p1--];
                } else {
                    cur = nums2[p2--];
                }
                nums1[tail--] = cur;
            }
        }
    }

}
