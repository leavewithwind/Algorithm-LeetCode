package array;

// https://leetcode.cn/problems/remove-duplicates-from-sorted-array/?envType=study-plan-v2&envId=top-interview-150
/**
 * 26.删除有序数组中的重复项
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 *
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 *
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
 * 返回 k 。
 */

/**
 * 2025/04/07
 */
public class DeleteRepeatItemsInOrderedArray {
    /**
     * 自己的解法
     * @param nums
     * @return
     */
    public int removeDuplicates1(int[] nums) {
        int pointerA = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[pointerA] != nums[i]) {
                nums[pointerA + 1] = nums[i];
                pointerA++;
            }
        }

        return pointerA + 1;
    }

    /**
     * 优化思路
     * @param nums
     * @return
     */
    public int removeDuplicatesBetter(int[] nums) {
        /**
         * 优化一：为空时直接返回
         */
        if(nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while(q < nums.length){
            if(nums[p] != nums[q]){
                /**
                 * 添加判断：两个指针不相邻时，才进行复制。
                 * 即当两个指针相邻时，不用进行原地复制。
                 */
                if(q - p > 1){
                    nums[p + 1] = nums[q];
                }
                p++;
            }
            q++;
        }
        return p + 1;
    }

    /**
     * 应用优化后的解法
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int pointerA = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[pointerA] != nums[i]) {

                if(i - pointerA > 1){
                    nums[pointerA + 1] = nums[i];
                }
                pointerA++;
            }
        }

        return pointerA + 1;
    }


}
