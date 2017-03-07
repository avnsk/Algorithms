package com.Tree;

public class CountNumberOfTreePreorder {
    public int count(int n) {
        int temp[] = new int[n+1];
        temp[0] = temp[1] = 1;
        for(int i = 2 ; i <= n ; i++) {
            for(int j = 0 ; j < i ; j++) {
                temp[i] += temp[j]*temp[i-j-1];
            }
        }

        return temp[n];
    }

    public static void main(String args[]) {
        CountNumberOfTreePreorder cn = new CountNumberOfTreePreorder();
        System.out.println(cn.count(3));
        System.out.println(cn.count(4));
        System.out.println(cn.count(5));
    }
}
