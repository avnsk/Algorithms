package com.array;


import java.util.Arrays;

public class CheckIfArrayElementsAreConsecutive {

    public boolean isConsecutive(int arr[], int n) {
        if(n < 1)
            return false;
       int min = Arrays.stream(arr).min().getAsInt();
        int output = 0;

        for(int i = 0 ; i < arr.length ; i++) {
            output = output ^ (arr[i] - (min -1))^(i+1);
        }

        return (output == 0);
    }

    public static void main(String[] args) {
        CheckIfArrayElementsAreConsecutive ac = new CheckIfArrayElementsAreConsecutive();
        int arr[] = {-3, -2, -1};
        int n = arr.length;
        if (ac.isConsecutive(arr, n))
            System.out.println("Array elements are consecutive");
        else
            System.out.println("Array elements are not consecutive");
    }
}
