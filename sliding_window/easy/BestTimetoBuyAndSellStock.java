package sliding_window.easy;

public class BestTimetoBuyAndSellStock {
    
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {10,1,5,6,7,1};
        int[] prices2 = {10,8,7,5,2};
        int[] failedCase = {5,1,5,6,7,1,10};
         
        System.out.println(

            "maxProfit = " + solution.maxProfit(prices)
        );
    }

}


class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        int i=0;

        while(i < prices.length){
            int j=i+1;
            int buyPrice = prices[i];
            while (j < prices.length){
                int sellPrice = prices[j];
                int profit = Math.max(0, sellPrice-buyPrice);
                maxProfit = Math.max(maxProfit, profit);
                if (profit == 0){
                    break;
                } else {
                    j++;
                }
            }
            i=j;

        }

        return maxProfit;
    }
}
