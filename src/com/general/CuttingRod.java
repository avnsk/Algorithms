package com.general;

public class CuttingRod {
    public int maxValue(int price[]) {
        int temp[] = new int[price.length + 1];
        for(int i = 1 ; i <= price.length ; i++) {
            for(int j = 0 ; j < i ; j++) {
                temp[i] = Math.max(temp[i], price[j] + temp[i-j-1]);
            }
        }

        return temp[price.length];
    }

    public static void main(String args[]) {
        CuttingRod cr = new CuttingRod();
        int[] price = {3, 5, 8, 9, 10, 20, 22, 25};
        System.out.println(cr.maxValue(price));
    }
}
