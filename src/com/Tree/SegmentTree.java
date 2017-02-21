package com.Tree;

/**
 * Created by hunter on 20-Feb-17.
 */
public class SegmentTree {
    int segmentArray[];

    public SegmentTree(int arr[]) {
        int len = arr.length;
        int x = (int) (Math.ceil(Math.log(len) / Math.log(2)));
        int size = 2* (int) Math.pow(2,x) - 1;
        segmentArray = new int[size];
        constructSegmentTree(arr,0,len-1,0);
    }

    private int constructSegmentTree(int[] arr, int ss, int se, int si) {
        if (ss == se) {
            segmentArray[si] = arr[ss];
            return arr[ss];
        }

        // If there are more than one elements, then recur for left and
        // right subtrees and store the sum of values in this node
        int mid = ss+(se-ss)/2;
        segmentArray[si] = constructSegmentTree(arr, ss, mid, si * 2 + 1) +
                constructSegmentTree(arr, mid + 1, se, si * 2 + 2);
        return segmentArray[si];

    }

    int getSum(int n ,int qs ,int qe) {
        if (qs < 0 || qe > n - 1 || qs > qe) {
            return -1;
        }

        return getSumUtil(qs,qe,0,n-1,0);


    }

    private int getSumUtil(int qs, int qe, int ss, int se, int si) {
        if(qs > se  || ss > qe)              // No overlap case
            return 0;
        if(ss >= qs && se <= qe)
            return segmentArray[si];

        int mid = ss + (se-ss)/2;

        return getSumUtil(qs,qe,ss,mid,2*si+1) +getSumUtil(qs,qe,mid+1,se,2*si+2);


    }

    void updateValue(int arr[], int n, int i, int new_val)
    {
        if (i < 0 || i > n - 1)
            return;

        int diff = new_val - arr[i];

        
        arr[i] = new_val;

        
        updateValueUtil(0, n - 1, i, diff, 0);
    }

    private void updateValueUtil(int ss, int se, int index, int diff, int si) {
        if(index < ss || index > se)
            return;
        if(ss == se) {
            segmentArray[si] += diff;
        }else {
            int mid = ss + (se - ss) / 2;
            if(ss <= index && index <= mid) {
                updateValueUtil(ss, mid, index, diff, 2 * si + 1);
            }
           else {
                updateValueUtil(mid + 1, se, index, diff, 2 * si + 2);
            }
            segmentArray[si] = segmentArray[2 * si + 1] + segmentArray[2 * si + 2];
        }
    }

    public static void main(String args[])
    {
        int arr[] = {1, 3, 5, 7, 9, 11};
        int n = arr.length;
        SegmentTree  tree = new SegmentTree(arr);
        for(int i = 0 ; i < tree.segmentArray.length ; i++)
        System.out.println(tree.segmentArray[i]);

        System.out.println(tree.getSum(n,1,n-2));

        tree.updateValue(arr, n, 1, 10);

        System.out.println(tree.getSum(n,1,n-2));
    }
}
