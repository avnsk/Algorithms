package com.array;

/**
 * Created by hunter on 28-Feb-17.
 */
public class Flip0sMaximum1s {
    public static void main(String args[]) {
        int input[] = {0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        Flip0sMaximum1s fm = new Flip0sMaximum1s();
        System.out.print(fm.flip0sToMaximizeConsecutive1s(input, 1));
    }

    private int flip0sToMaximizeConsecutive1s(int[] input, int m) {
        int cStart = 0;
        int cEnd = 0;
        int winL = 0;
        int winR =0;
        int cZero = 0;

        for(int i = 0 ; i < input.length ; i++) {
            if(input[i] == 1){
                cEnd ++;
            }else {
                if(cZero <= m){
                    cZero++;
                    cEnd++;
                }

                if(cZero > m) {
                    while(cZero > m) {
                        if(input[cStart] == 0)
                            cZero--;
                        cStart++;
                    }
                }
            }

            if(cEnd-cStart > winR -winL) {
                winR = cEnd;
                winL = cStart;
            }
        }


        return winR - winL;
    }
}
