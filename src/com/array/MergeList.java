package com.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeList {

    class Triplet implements Comparable<Triplet> {

        int pos;
        int val;
        int nextIndex;

        @Override
        public int compareTo(Triplet o) {
            if(val <= o.val){
                return -1;
            }else{
                return 1;
            }
        }
    }

    public List<Integer> mergeUsingHeap(List<List<Integer>> chunks) {
        List<Integer> result = new ArrayList<Integer>();
        PriorityQueue<Triplet> queue = new PriorityQueue<Triplet>();

        for (int i = 0; i < chunks.size(); i++) {
            Triplet p = new Triplet();
            p.pos = i;
            p.val = chunks.get(i).get(0);
            p.nextIndex = 1;
            queue.add(p);
        }

        while (!queue.isEmpty()) {
            Triplet p = queue.poll();
            result.add(p.val);
            if (p.nextIndex < chunks.get(p.pos).size()) {
                p.val = chunks.get(p.pos).get(p.nextIndex);
                p.nextIndex++;
                queue.add(p);
            }
        }

        return result;
    }

    public static void main(String args[]){
        Integer arr1[] = {1,5,6,9,21};
        Integer arr2[] = {4,6,11,14};
        Integer arr3[] = {-1,0,7};
        Integer arr4[] = {-4,-2,11,14,18};
        Integer arr5[] = {2,6};
        Integer arr6[] = {-5,-2,1,5,7,11,14};
        Integer arr7[] = {-6,-1,0,15,17,22,24};

        List<Integer> list1 = Arrays.asList(arr1);
        List<Integer> list2 = Arrays.asList(arr2);
        List<Integer> list3 = Arrays.asList(arr3);
        List<Integer> list4 = Arrays.asList(arr4);
        List<Integer> list5 = Arrays.asList(arr5);
        List<Integer> list6 = Arrays.asList(arr6);
        List<Integer> list7 = Arrays.asList(arr7);


        List<List<Integer>> chunks = new ArrayList<List<Integer>>();
        chunks.add(list1);
        chunks.add(list2);
        chunks.add(list3);
        chunks.add(list4);
        chunks.add(list5);
        chunks.add(list6);
        chunks.add(list7);

        MergeList cm = new MergeList();
        List<Integer> result = cm.mergeUsingHeap(chunks);
        for(Integer r : result){
            System.out.print(r + " ");
        }
    }

        }



