package com.general;

public class CountMaxAs {
    int countAs(int n) {
        if(n < 7)
            return n;

        int[] temp = new int[n+1];
        for(int i = 1 ; i < 7 ; i++)
            temp[i] = i;
        for(int i = 7 ; i <= n ; i++) {
            for(int j = i-3 ; j >= 1 ; j--) {
                temp[i] = Math.max(temp[i] ,(i-j-1)*(temp[j]));
            }
        }

        return temp[n];
    }

    public static void main(String args[]){
        CountMaxAs ca =new CountMaxAs();
        System.out.println(ca.countAs(20));

    }
}
