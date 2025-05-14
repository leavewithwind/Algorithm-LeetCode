package array;

/**
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 *
 * 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 *
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 *
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 */
public class JumpingGame2 {

    /**
     * 方法二：正向查找可到达的最大位置
     * 方法一虽然直观，但是时间复杂度比较高，有没有办法降低时间复杂度呢？
     *
     * 如果我们「贪心」地进行正向查找，每次找到可到达的最远位置，就可以在线性时间内得到最少的跳跃次数。
     *
     * 例如，对于数组 [2,3,1,2,4,2,3]，初始位置是下标 0，从下标 0 出发，最远可到达下标 2。下标 0 可到达的位置中，下标 1 的值是 3，从下标 1 出发可以达到更远的位置，因此第一步到达下标 1。
     *
     * 从下标 1 出发，最远可到达下标 4。下标 1 可到达的位置中，下标 4 的值是 4 ，从下标 4 出发可以达到更远的位置，因此第二步到达下标 4。
     *
     * 在具体的实现中，我们维护当前能够到达的最大下标位置，记为边界。我们从左到右遍历数组，到达边界时，更新边界并将跳跃次数增加 1。
     *
     * 在遍历数组时，我们不访问最后一个元素，这是因为在访问最后一个元素之前，我们的边界一定大于等于最后一个位置，否则就无法跳到最后一个位置了。如果访问最后一个元素，在边界正好为最后一个位置的情况下，我们会增加一次「不必要的跳跃次数」，因此我们不必访问最后一个元素。

     */
    class Solution2 {
    public int jump(int[] nums) {
        int n = nums.length;
        int lastMaxPosition = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < n - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == lastMaxPosition) {
                lastMaxPosition = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}

    /**
     * 自己的理解：
     * 1、不能直接跳到本轮确定的下一轮能到达的最远位置，而不检查其中未检查的元素。必须要遍历所有的元素，否则会漏掉更优解；
     * 2、在到达边界（上一轮确定的可到达的最远位置）之前，遍历边界前的元素这一行为是在确定：在本轮的可及范围内，到底跳到哪个位置才能让下一跳跳的更远。即选择下一跳的位置。
     *    因此，并不是每一轮都跳到了本轮可及的最远位置，而是在本次起跳位置可及的，在下一轮能跳的最远的位置。
     */

    class Solution {
        public int jump(int[] nums) {
            int length = nums.length;
            int end = 0;
            int maxPosition = 0;
            int steps = 0;

            int i = 0;
            while (i < length - 1) {
                if (nums[i] + i > maxPosition)
                    maxPosition = nums[i] + i;
                if (i == end) {
                    end = maxPosition;
                    steps++;
                }

                i++;
            }

            // for (int i = 0; i < length - 1; i++) {
            //     if (nums[i] + i > maxPosition)
            //         maxPosition = nums[i] + i;
            //     if (i == end) {
            //         end = maxPosition;
            //         steps++;
            //     }
            // }
            return steps;

        }
    }

    /**
     * Python实现
     */
    /*
    class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums) - 1
        steps = 0
        end = 0
        max_position = 0

        for i in range(0, n):
        # for i = 0 in n:
            max_position = max(i + nums[i], max_position)
            if i == end:
                end = max_position
                steps += 1
        return steps

     */

}
