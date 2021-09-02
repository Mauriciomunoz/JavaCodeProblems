package MediumProblems.DynamicProgramming;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/111/dynamic-programming/809/
 *
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Example 1:
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 * Example 3:
 * Input: coins = [1], amount = 0
 * Output: 0
 *
 * Example 4:
 * Input: coins = [1], amount = 1
 * Output: 1
 *
 * Example 5:
 * Input: coins = [1], amount = 2
 * Output: 2
 *
 *
 * [2,5,10,1]
 * 27
 *
 *
 * Input:
 * [186,419,83,408]
 * 6249
 * Output:
 * -1
 * Expected:
 * 20
 *
 */

public class CoinChange {

    public static void main(String[] args) {

        //int[] array = {186,419,83,408};
        int[] array = {2,5};

        int result = coinChange(array, 11);

        System.out.println("DONE");
    }
    static public int coinChange(int[] coins, int amount) {
        int[] coinAmounts = new int[amount + 1];

        for(int i = 0; i < coinAmounts.length; i++){
            coinAmounts[i] = Integer.MAX_VALUE;
        }

        coinAmounts[0] = 0;

        for(int i = 0; i < coins.length; i++){
            for(int j = coins[i]; j <= amount; j++){
                if(coinAmounts[j - coins[i]] != Integer.MAX_VALUE)
                    coinAmounts[j] = Math.min(coinAmounts[j - coins[i]] + 1, coinAmounts[j]);
            }
        }

        if(coinAmounts[amount] != Integer.MAX_VALUE)
            return coinAmounts[amount];
        else
            return -1;

    }


    static public int coinChangeTry(int[] coins, int amount) {
        int[] coinAmounts = new int[amount + 1];

        for(int i = 0; i < coins.length; i++){
            coinAmounts[coins[i]] = 1;
        }

        int firstCoin = 0;
        for(; firstCoin < coinAmounts.length; firstCoin++){
            if(coinAmounts[firstCoin] == 1)
                break;
        }

        for(int coinIndex = firstCoin; coinIndex < coinAmounts.length; coinIndex++){

        }

        int maxCoin = 0;
        for(int j = firstCoin; j < coinAmounts.length; j++){
            if(coinAmounts[j] == 0){
                int rest = j % maxCoin;
                int n = j / maxCoin;
                if(coinAmounts[rest] == 0 && rest != 0)
                    coinAmounts[j] = -1;
                else
                    coinAmounts[j] = (n * coinAmounts[maxCoin]) + coinAmounts[rest];
            }else{
                maxCoin = j;
            }
        }

        return coinAmounts[amount];
    }

    static public int coinChangeWrong(int[] coins, int amount) {
        int result = 0;

        Arrays.sort(coins);

        for(int i = coins.length - 1; i >= 0; i--){
            if(
                    coins[i] <= amount){
                result = result + (amount / coins[i]);
                amount = amount % coins[i];

            }
        }


        if(amount > 0){
            result = -1;
        }

        return result;
    }
}
