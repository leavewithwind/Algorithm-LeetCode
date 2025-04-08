package array;

/**
 * 80. 删除有序数组中的重复项 II
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class DeleteRepeatItemsInOrderedArray2 {
    /**
     * 官方题解，双指针
     *
     * 因为本题要求相同元素最多出现两次而非一次，所以我们需要检查上上个应该被保留的元素 nums[slow−2] 是否和当前待检查元素 nums[fast] 相同。当且仅当 nums[slow−2]=nums[fast] 时，当前待检查元素 nums[fast] 不应该被保留（因为此时必然有 nums[slow−2]=nums[slow−1]=nums[fast]）。最后，slow 即为处理好的数组的长度。
     *
     * 特别地，数组的前两个数必然可以被保留，因此对于长度不超过 2 的数组，我们无需进行任何处理，对于长度超过 2 的数组，我们直接将双指针的初始值设为 2 即可。
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/solutions/702644/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-yec2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int removeDuplicates1(int[] nums) {
        if (nums.length <= 2)
            return nums.length;

        int pointerFront = 0;
        int pointerBack = 2;


        while (pointerBack < nums.length) {
            if (nums[pointerFront] != nums[pointerBack]) {
                nums[pointerFront + 2] = nums[pointerBack];
                pointerFront++;
            }
            pointerBack++;
        }

        return pointerFront + 2;
    }

    /**
     * 比较符合场景的思路：栈
     */
    public int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i < 2 || num > nums[i - 2]) {
                nums[i++] = num;
            }
        }

        return i;
    }

    /**
     * 最简洁优雅的方法，排序
     *
     * 排序可以，思路太棒了！
     *
     * 本质还是有序数组支持这么做，用i<2规避了数组报错问题和数据简单处理，前2次直接进来，第3次开始判断，第3位是不是比第1位大，理论上来说应该可以判断不同吧，然后进行赋值
     *
     * 这样看nums就是快指针，而i是慢指针进行赋值可计数
     *
     * 本质是双指针的变形，不过想法还是无敌！
     *
     * 我的理解是每个数字只保留两位+顺序比大小，太优美了！
     */
    public int removeDuplicates3(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i < 2 || num > nums[i - 2]) {
                nums[i++] = num;
            }
        }

        return i;
    }
}
