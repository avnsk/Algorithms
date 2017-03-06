package com.array;

import java.util.ArrayList;
import java.util.List;

public class CoinChanging {
    int numberOfSolutions(int total ,int coins[]) {
        int temp[][] = new int[coins.length+1][total+1];
        for(int i = 0 ; i <= coins.length ; i++)
            temp[i][0] = 1;

        for(int i = 1 ; i <= coins.length ; i++) {
            for(int j = 1 ; j <= total ; j++) {
                if(coins[i-1] > j){
                    temp[i][j] = temp[i-1][j];
                }else {
                    temp[i][j] = temp[i][j-coins[i-1]] + temp[i-1][j];
                }
            }
        }

        return  temp[coins.length][total];
    }

    public void printCoinChangingSolution(int total,int coins[]){
        List<Integer> result = new ArrayList<>();
        printActualSolution(result, total, coins, 0);
    }

    private void printActualSolution(List<Integer> result, int total, int[] coins, int pos) {
        if(total == 0) {
            System.out.print('{');
            for(int i = 0 ; i < result.size() ; i++) {
                if(i == result.size() -1) {
                    System.out.print(result.get(i));
                }else {
                    System.out.print(result.get(i) + ",");
                }
            }
            System.out.print('}');
            System.out.println();

        }

        for(int i = pos ; i < coins.length ; i++) {
            if(coins[i] <= total) {
                result.add(coins[i]);
                printActualSolution(result,total-coins[i],coins,i);
                result.remove(result.size()-1);
            }
        }
    }


    public static void main(String args[]) {
        CoinChanging cc = new CoinChanging();
        int total = 15;
        int coins[] = {3, 4, 6, 7, 9};
        System.out.println(cc.numberOfSolutions(total, coins));
        cc.printCoinChangingSolution(total,coins);
    }
}
