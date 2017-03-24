package com.general;

public class ReverseBits {
    private static long precomputedReverseBits[] = new long[1 << 16];

    public static long reverseBits(long x, int n ) {
        for(int i = 0 ,j = n ;  i < j ; i++,j--){
           x = BitSwap.swapValueOfBits(x,i,j);
        }
        return x;
    }

    private static void precomputeTableInit() {
        for (int i = 0; i < (1 << 16); i++) {
            precomputedReverseBits[i] = reverseBits(i, 15);
        }
    }

        public static long reverseBits(long x) {
            int WORD_SIZE = 16;
            int BIT_MASK = 0xFFFF;
            return precomputedReverseBits[(int)(x & BIT_MASK)] << (3 * WORD_SIZE)
                    | precomputedReverseBits[(int)((x >>> WORD_SIZE) & BIT_MASK)]
                    << (2 * WORD_SIZE)
                    | precomputedReverseBits[(int)((x >>> (2 * WORD_SIZE)) & BIT_MASK)]
                    << WORD_SIZE
                    | precomputedReverseBits[(int)((x >>> (3 * WORD_SIZE)) & BIT_MASK)];
    }

    public static void main (String args[]) {
        precomputeTableInit();
        System.out.println(reverseBits(1));
    }


}
