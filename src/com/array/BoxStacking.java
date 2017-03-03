package com.array;

import java.util.Arrays;

public class BoxStacking {
    static class Dimension implements Comparable<Dimension> {
        int height;
        int length;
        int width;

        public Dimension() {
        }

        Dimension(int height, int length, int width) {
            this.height = height;
            this.length = length;
            this.width = width;
        }

        @Override
        public int compareTo(Dimension d) {
            if (this.length * this.width >= d.length * d.width) {
                return -1;
            } else {
                return 1;
            }
        }
    }
    public int maxHeight(Dimension[] input) {
        Dimension[] allRotationInput = new Dimension[input.length * 3];
        int index  = 0;
        for(int i = 0 ; i < input.length ; i++) {
            allRotationInput[index] = input[i];
            index++;
            allRotationInput[index] = new Dimension();
            allRotationInput[index].height = input[i].width;
            allRotationInput[index].length = Math.max(input[i].length , input[i].height);
            allRotationInput[index].width = Math.min(input[i].length , input[i].height);
            index++;
            allRotationInput[index] = new Dimension();
            allRotationInput[index].height = input[i].length;
            allRotationInput[index].length = Math.max(input[i].width , input[i].height);
            allRotationInput[index].width = Math.min(input[i].width , input[i].height);
            index++;
        }

        Arrays.sort(allRotationInput);

        int temp[] = new int[allRotationInput.length];

        for(int i = 1 ; i < allRotationInput.length ; i++ ) {
            for(int j = 0 ; j  < i ; j++) {
                if(allRotationInput[i].width < allRotationInput[j].width && allRotationInput[i].length < allRotationInput[j].length ) {
                   temp[i] = Math.max(temp[i] , temp[j] + allRotationInput[i].height);
                }
            }
        }

        int res = Integer.MIN_VALUE;
        for(int i = 0 ; i < temp.length ; i++) {
            res = Math.max(res ,temp[i]);
        }
        return res;
    }

    public static void main(String args[]) {
        BoxStacking bs = new BoxStacking();
        Dimension input[] = {new Dimension(3, 2, 5), new Dimension(1, 2, 4)};
        int maxHeight = bs.maxHeight(input);
        System.out.println("Max height is " + maxHeight);
    }
    }
