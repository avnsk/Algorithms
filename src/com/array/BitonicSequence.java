package com.array;


import java.util.Arrays;

public class BitonicSequence {
    public int longestSequence(int arr[]) {
        int lis[] = new int[arr.length];
        int lds[] = new int[arr.length];
        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);

        int i, j;

        for (i = 1; i < arr.length; i++) {
            for (j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        for (i = arr.length - 2; i >= 0; i--) {
            for (j = arr.length - 1; j >= i; j--) {
                if (arr[j] < arr[i]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        int max = 0;
        for (i = 0; i < arr.length; i++) {
            max = Math.max(max, lis[i] + lds[i] - 1);
        }
        return max;
    }
    public static void main(String args[]){
        BitonicSequence bs = new BitonicSequence();
        int[] arr = {1,4,3,7,2,1,8,11,13,0};
        int r = bs.longestSequence(arr);
        System.out.print(r);

    }
}

