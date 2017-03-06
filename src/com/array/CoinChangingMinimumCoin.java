package com.array;

import java.util.Arrays;

public class CoinChangingMinimumCoin {
    public int minNoOfCoins(int coins[] ,int total) {
        int temp[] = new int[total+1];
        int r[] = new int[total + 1];
        Arrays.fill(r ,-1);
        Arrays.fill(temp , Integer.MAX_VALUE);
        temp[0] = 0;

        for(int i = 1 ; i <= total ; i++) {
            for(int j = 0 ; j < coins.length ; j++) {
                if(i >= coins[j]) {
                    int res = temp[i-coins[j]];

                    if(res != Integer.MAX_VALUE && res+1 < temp[i]){
                        temp[i] = res+1;
                        r[i] = j;
                    }
                }
            }
        }
        printCoinCombination(r, coins);
        return  temp[total];
    }
    private void printCoinCombination(int R[], int coins[]) {
        if (R[R.length - 1] == -1) {
            System.out.print("No solution is possible");
            return;
        }
        int start = R.length - 1;
        while ( start != 0 ) {
            int j = R[start];
            System.out.print(coins[j] + " ");
            start = start - coins[j];
        }
        System.out.print("\n");
    }

    public static void main ( String args[] ) {
        int total = 13;
        int coins[] = {7, 3, 2, 6};
        CoinChangingMinimumCoin cc = new CoinChangingMinimumCoin();

        System.out.print(cc.minNoOfCoins(coins, total));



    }
}
