package com.array;

/**
 * Created by hunter on 22-Feb-17.
 */
public class MedianOfTwoSortedArrayOfDifferentLength {

    public double findMedianOfTwoArray(int input1[] ,int input2[]) {
        int m = input1.length;
        int n = input2.length;
        double ans = 0;
        if(m>n)
            return findMedianOfTwoArray(input2,input1);
        if(m == 0) {
            ans = (n%2 == 0) ? ((double) input2[n/2-1] + input2[n/2])/2 :input2[n/2]/2 ;
            return  ans;
        }

        int low = 0;
        int high = m;
        while(low <= high){
            int cut1 = (low + high)/2;
            int cut2 = (m + n + 1)/2 - cut1;   // m was made smaller so that cut2 remains non negative

            int a1 = (cut1 == 0) ? Integer.MIN_VALUE : input1[cut1 - 1];
            int a2 = (cut1 == m) ? Integer.MAX_VALUE : input1[cut1];

            int b1 = (cut2 == 0) ? Integer.MIN_VALUE : input2[cut2 - 1];
            int b2 = (cut2 == n) ? Integer.MAX_VALUE : input2[cut2];

            if (a1 <= b2 && b1 <= a2) {
                if ((m + n) % 2 == 0) {
                    ans = ((double)Math.max(a1, b1) + Math.min(a2, b2))/2;
                } else {
                    ans = (double)Math.max(a1, b1);
                }
                break;
            } else if (a1 > b2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
            }
        return  ans;
        }
    public  static  void  main(String args[]) {
        int ar1[] = {1, 2, 3, 6};
        int ar2[] = {4, 6, 8, 10};
        int A[] = {900};
        int B[] = {5, 8, 10, 20};

        MedianOfTwoSortedArrayOfDifferentLength m = new MedianOfTwoSortedArrayOfDifferentLength();
        System.out.println(m.findMedianOfTwoArray(ar1,ar2));
        System.out.println(m.findMedianOfTwoArray(A,B));

    }
    }

