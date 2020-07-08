package com.dsalgo.practice.solutions;

public class BuyAndSellStock {
    public static void main(String [] args){
        int [] testArray1 = {7,1,5,3,6,4};
        int [] testArray2 = {1,2,3,4,5,6,7,10,1,2,3,18,21,25,4};
        int [] testArray3 = {1};
        int [] testArray4 = {1,8};
        int maxProfit1 = maxProfit(testArray1);
        int maxProfit2 = maxProfit(testArray2);
        int maxProfit3 = maxProfit(testArray3);
        int maxProfit4 = maxProfit(testArray4);
        System.out.println("maxProfit1 = "+maxProfit1+" maxProfit2 = "+maxProfit2+
                " maxProfit3="+maxProfit3+" maxProfit4 = "+maxProfit4);
    }

    /**
     * If we know the maximum price of share after every day(i),
     * we can easily calculate the profit by buying share on that day and selling in on the day with maximum price.
     * {7,1,5,3,6,4};
     * 7 - Max 6
     * 1 - Max 6
     * 5 -Max 6
     * 3 - Max 6
     * 6 - Max 4
     * 4 - No max
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0 || prices.length == 1){
            return 0;
        }

        // prices - {7,1,5,3,6,4}
        // maxPrices -            7,6,6,6,6,4
        int [] maxArray = new int[prices.length];
        maxArray[prices.length-1] = prices[prices.length-1];
        for(int i = prices.length-2; i >= 0; i--){
            if(prices[i] > maxArray[i+1]){
                maxArray[i] = prices[i];
            }
            else{
                maxArray[i] = maxArray[i+1];
            }
        }

        int max = 0;
        for(int i = 0; i < maxArray.length-1; i++){
            max = Math.max(max, (maxArray[i+1] - prices[i]));
        }
        return max;
    }
}
