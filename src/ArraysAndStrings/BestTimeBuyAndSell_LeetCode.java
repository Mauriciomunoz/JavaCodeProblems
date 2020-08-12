package ArraysAndStrings;

public class BestTimeBuyAndSell_LeetCode {

    public static void main(String[] args) {

       int[] nums={8,1,8,9,2,9,4};
        //int[] nums={1,2,3,4,5};
        //int[] nums={7,6,4,3,1};
        //int[] nums={7,1,5,3,6,4};

        System.out.println(maxProfit(nums));
    }

    //Time complexity: O(N^2)
    //Space complexity: O(1)
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];
        int sell = 0;

        for(int i=1;i<prices.length;i++){
            buy = prices[i-1];
            sell = prices[i];
            if (buy > sell) {

            }else {
                for(int j = i + 1; j < prices.length; j++) {
                    int nSell = prices[j];
                    if(nSell > sell){
                        sell = nSell;
                        i = j;
                    }else{
                        break;
                    }
                }
                profit += sell - buy;
            }

        }
        return profit;
    }

    //Time complexity: O(N)
    //Space complexity: O(1)
    public int OtherSOLUTION_maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1, n = prices.length; i < n; i++){
            if(prices[i] - prices[i-1] > 0){
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }

    //Time complexity: O(N^2)
    //Space complexity: O(1)
    public static int maxProfit2(int[] prices) {
        int c=0;
        int buy=prices[0];
        int sell=0;

        for(int i=0;i<prices.length;i++){
            if(i+1<prices.length) {
                buy = prices[0];
                if (prices[i] < buy) {
                    buy = prices[i];
                    for (int j = i + 1; j < prices.length; j++) {
                        if (prices[j] > sell && prices[j] > buy ) {
                            sell = prices[j];
                            c += (sell - buy);
                        } else {
                            i = j - 1;
                            break;
                        }
                    }
                    sell = 0;
                }
            }
        }
/*
        if(c==0){
            for(int i=0;i<prices.length;i++){
                if(prices[i]>sell){
                    sell=prices[i];
                }
            }
            c += (sell - buy);
        }*/
        return c;
    }

}
