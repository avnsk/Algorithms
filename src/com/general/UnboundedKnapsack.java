package com.general;

public class UnboundedKnapsack {
    public static void main(String args[]){
        int W = 100;
        int val[] = {10, 30, 20};
        int wt[] = {5, 10, 15};
        System.out.println(maxValue(W ,val ,wt));
    }

    public static int maxValue(int W ,int val[] ,int wt[]) {
        int temp[] = new int[W+1];
        for(int i = 1 ; i <= W ; i++) {
            for(int j = 0 ; j < wt.length ; j++) {
                if(wt[j] <= i)
                temp[i] = Math.max(temp[i] ,val[j] + temp[i-wt[j]]);
            }
        }
        return temp[W];
    }
}
