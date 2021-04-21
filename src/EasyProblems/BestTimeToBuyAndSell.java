package EasyProblems;

/***
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 *You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 *
 */

public class BestTimeToBuyAndSell {
    public static void main(String[] args) {

//        int[] n = {2,7,1,4,3,5};
        int[] n = {2,7,10,1,5,8};


        System.out.println(maxProfit2(n));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++){
            for(int j = i + 1; j < prices.length; j++){
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }

        return maxProfit;
    }

    public static int maxProfit2(int[] prices) {
        int maxProfit = 0;
        int b = 0;
        int s = 1;

        while(s < prices.length){
            if(prices[b] < prices[s]){
                maxProfit = Math.max(maxProfit, prices[s] - prices[b]);
            }else{
                b = s;
            }
            s++;
        }

        return maxProfit;
    }
}
