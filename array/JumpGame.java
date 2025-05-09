package array;

/** 55.跳跃游戏
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 * 示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 */
public class JumpGame {

    /**
     * 自己的解法
     */
    // class Solution {
//     public boolean canJump(int[] nums) {
//         int n = nums.length - 1;
//         int maxPosition = 0;
//         int currentPosition = 0;

//         while (currentPosition <= maxPosition) {
//             maxPosition = Math.max(currentPosition + nums[currentPosition], maxPosition);
//             if (maxPosition >= n)
//                 return true;

//             if (maxPosition > currentPosition) {
//                 currentPosition++;
//             } else {
//                 break;
//             }
//         }
//         return false;

//     }

// }

    /*
     * 思路不错的一个题解：
     如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点
    可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新
    如果可以一直跳到最后，就成功了
    作者：Ikaruga
    链接：https://leetcode.cn/problems/jump-game/solutions/24322/55-by-ikaruga/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public boolean canJump(int[] nums) {
            int maxPosition = 0, n = nums.length - 1;

            for (int i = 0; i <= n; i++) {
                if (i > maxPosition)
                    return false;

                maxPosition = Math.max(i + nums[i], maxPosition);

                if (maxPosition >= n)
                    return true;
            }
            return true;
        }
    }

// public class Solution {
//     public boolean canJump(int[] nums) {
//         int n = nums.length;
//         int rightmost = 0;
//         for (int i = 0; i < n; ++i) {
//             if (i <= rightmost) {
//                 rightmost = Math.max(rightmost, i + nums[i]);
//                 if (rightmost >= n - 1) {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }


// class Solution {
//     public boolean canJump(int[] nums) {
//         int r = nums.length - 1;
//         for (int l = r - 1; l >= 0; l--) {
//             if (nums[l] >= r - l)
//                 r = l;
//         }
//         return r == 0;
//     }
// }
}

/**
 * Python解法
 */
/*
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        maxPosition = 0
        n = len(nums) - 1
        for i in range(0, n + 1):
            if i > maxPosition:
                return False

            maxPosition = max(maxPosition, i + nums[i])
            if maxPosition >= n:
                return True
        return True
 */