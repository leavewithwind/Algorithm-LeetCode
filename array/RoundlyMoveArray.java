package array;


/** 转轮数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class RoundlyMoveArray {

    /**
     * 自己开始的解法
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (nums.length < 2 || nums == null || k == 0 || k == nums.length) return;

        if (k > nums.length){
            k = k % nums.length;
        }

        int[] result = new int[nums.length];

        for (int i = k; i > 0; i--) {
            result[k - i] = nums[nums.length - i];
        }
        for (int i = k; i < nums.length; i++) {
            result[i] = nums[i - k];
        }

        System.arraycopy(result, 0, nums, 0, result.length);
    }

    /**
     *方法一：使用额外的数组
     * 我们可以使用额外的数组来将每个元素放至正确的位置。用 n 表示数组的长度，我们遍历原数组，将原数组下标为 i 的元素放至新数组下标为 (i+k)modn 的位置，最后将新数组拷贝至原数组即可。
     * 时间复杂度： O(n)，其中 n 为数组的长度。
     * 空间复杂度： O(n)。
     */
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }

    /**
     * 方法一重写
     *
     */
    public void rotate11(int[] nums, int k) {
        int n = nums.length;
        int[] tempArray = new int[n];
        for (int i = 0; i < n; i++) {
            tempArray[(i + k) % n] = nums[i];
        }
        System.arraycopy(tempArray, 0, nums, 0, n);
    }

    /**
     * 方法二：数组翻转
     * 该方法基于如下的事实：当我们将数组的元素向右移动 k 次后，尾部 kmodn 个元素会移动至数组头部，其余元素向后移动 kmodn 个位置。
     *
     * 该方法为数组的翻转：我们可以先将所有元素翻转，这样尾部的 kmodn 个元素就被移至数组头部，然后我们再翻转 [0,kmodn−1] 区间的元素和 [kmodn,n−1] 区间的元素即能得到最后的答案。
     * 复杂度分析
     *
     * 时间复杂度：O(n)，其中 n 为数组的长度。每个元素被翻转两次，一共 n 个元素，因此总时间复杂度为 O(2n)=O(n)。
     *
     * 空间复杂度：O(1)。
     */
    class Solution1 {
        public void rotate(int[] nums, int k) {
            k %= nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        public void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start += 1;
                end -= 1;
            }
        }
    }

    /**
     * 方法2:翻转数组，重写
     */
    class Solution2{
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k %= n;
            reverseArray(nums, 0, n - 1);
            reverseArray(nums, 0, k - 1);
            reverseArray(nums, k, n - 1);
        }

        private int[] reverseArray(int[] array, int start, int end) {
            int temp;
            while (end > start) {
                temp = array[end];
                array[end] = array[start];
                array[start] = temp;
                end--;
                start++;
            }
            return array;
        }
    }

}
