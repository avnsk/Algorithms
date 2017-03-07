package com.general;

public class CountNumberOfBinaryWithoutConsecutive1s {
    public int count(int n){
        int a = 1, b = 1 ,c;
        if(n == 1)
            return 2;
        for(int i = 2 ; i <= n ; i++){
            c = a+b;
            b = a;
            a = c;
        }

        return a+b;
    }

    public static void main(String args[]){
        CountNumberOfBinaryWithoutConsecutive1s cnb = new CountNumberOfBinaryWithoutConsecutive1s();
        System.out.println(cnb.count(3));
    }
}
