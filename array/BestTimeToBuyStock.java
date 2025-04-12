package array;

/**买卖股票的最佳时机
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */

/**
 * 示例 1：
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 *
 * 示例 2：
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class BestTimeToBuyStock {

    /**
     * 暴力算法
     * 时间复杂度：O(n^2)。循环运行 n*(n-1)/2次
     * 空间复杂度：O(1)。只使用了常数个变量。
     */
    class Solution1 {
        public int maxProfit(int[] prices) {
            int profit = 0;
            for (int i = 0; i < prices.length; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    // profit = ((prices[j] - prices[i]) > profit) ? prices[j] - prices[i] : profit;
                    if ((prices[j] - prices[i]) > profit){
                        profit = prices[j] - prices[i];
                    }
                }
            }
            return profit;

        }
    }

    /**
     * 方法二：一次遍历
     * 并不是求全局历史最低点，而是每次都假设是今天卖出，然后根据今天之前的历史最低点计算最大利润。而这个历史最低点并不需要额外遍历，而是每天考虑的时候顺带记录的。因此时间复杂度还是O(N)而不是O(N^2)。
     */
    public class Solution2 {
        public int maxProfit(int prices[]) {
            int minprice = Integer.MAX_VALUE;
            int maxprofit = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < minprice) {
                    minprice = prices[i];
                } else if (prices[i] - minprice > maxprofit) {
                    maxprofit = prices[i] - minprice;
                }
            }
            return maxprofit;
        }
    }

    /**
     * 官方Python题解，用时长
     *
     * class Solution:
     *     def maxProfit(self, prices: List[int]) -> int:
     *         minprice = int(1e9)
     *         maxprofit = 0
     *         for price in prices:
     *             maxprofit = max(price - minprice, maxprofit)
     *             minprice = min(price, minprice)
     *         return maxprofit
     */

    /**
     * 根据方法二思路的重写
     */
    class Solution3 {
        public int maxProfit(int[] prices) {
            int maxProfit = 0;
            int minPrice = Integer.MAX_VALUE;

            for (int price : prices){
                if (price < minPrice){
                    minPrice = price;
                }else{
                    int currentProfit = price - minPrice;
                    maxProfit = maxProfit > currentProfit ? maxProfit:currentProfit;
                }
            }
            return maxProfit;
        }
    }


    /**
     * 我的Python实现，更优
     *
     *     def maxProfit(self, prices: List[int]) -> int:
     *         minPrice = int (1e9)
     *         profit = 0
     *
     *         for price in prices:
     *             if price < minPrice:
     *                 minPrice = price
     *             else:
     *                 currentProfit = price - minPrice
     *                 profit = currentProfit if currentProfit > profit else profit
     *                 # profit = max(profit, currentProfit) # 耗时长
     *
     *         return profit
     */

}
