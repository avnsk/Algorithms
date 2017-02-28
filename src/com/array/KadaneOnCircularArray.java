package com.array;

/**
 * Created by hunter on 28-Feb-17.
 */
public class KadaneOnCircularArray {
    public int kadane(int arr[]) {     //at least one positive number in array
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        int mStart = 0;
        int end = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            sum += arr[i];
            if(sum <= 0) {
                sum = 0;
                start = i+1;
            }else {
                if(sum >= maxSum) {
                    maxSum = sum;
                    mStart = start;
                    end = i;
                }
            }
        }

        return maxSum;
    }

    public int circularArrayKadane(int arr[]) {
        int simpleKadaneSum = kadane(arr);
        int sum = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            sum += arr[i];
            arr[i] = -arr[i];
        }

        int wraapedKadaneSum = kadane(arr);

        return Math.max(simpleKadaneSum ,sum + wraapedKadaneSum);
    }

    public static  void main(String args[]) {
        KadaneOnCircularArray kc = new KadaneOnCircularArray();
        int input[] = {12, -2, -6, 5, 9, -7, 3};
        int a[] =  {11, 10, -20, 5, -3, -5, 8, -13, 10};
        System.out.println(kc.circularArrayKadane(input));
        System.out.println(kc.circularArrayKadane(a));

    }
}
