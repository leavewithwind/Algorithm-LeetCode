package array;

import java.util.Arrays;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class MostElement {
//    public static void main(String[] args) {
//        int most = (int) Math.ceil(1.5) ;
//
//        System.out.println(most);
//    }

    /**
     * 自己的解法
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {

        int most = (int) Math.ceil((double) nums.length / 2);
        Arrays.sort(nums);

        int count = 0;

        int current = nums[0];

        for (int num : nums) {
            if (num == current) {
                count++;
            } else {
                current = num;
                count = 1;
            }
            if (count >= most)
                break;
        }
        return current;

    }


    /**
     * 排序返回中位数，该中位数一定是众数
     * 时间复杂度n*logn
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 自己看完摩尔投票思路后，写的算法
     */

    public int majorityElementMolVote(int[] nums) {
        int majority = nums[0];
        int vote = 0;
        for (int num : nums) {

            if (vote == 0) {
                majority = num;
                vote++;
            } else {
                if (num == majority) {
                    vote++;
                } else{
                    vote--;
                }

            }

        }
        return majority;
    }


    /**
     * 官方更优雅的摩尔投票
     */
    public int majorityElement2(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums){
            if (votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }

    /**
     * 最后自己的优化
     */

    public int majorityElementOptimized(int[] nums) {
        int majority = 0, vote = 0;
        for (int num : nums) {
            if (vote == 0) majority = num;
            vote += num == majority? 1 : -1;
        }
        return majority;
    }

}
