package com.general;

import java.util.*;
import java.lang.*;
import java.io.*;

class BitSwap
{
	public static long swapValueOfBits(long x ,int a ,int b) {
		if(((x >>> a) & 1) != ((x >>> b) & 1) ) {
			 long bitmask = 1L << a | 1L << b; //bitmask
			x ^= bitmask;
		}
		return x;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		
		BitSwap bsw = new BitSwap();
		System.out.println(bsw.swapValueOfBits(5,1,2));
		System.out.println(bsw.swapValueOfBits(47,1,4));
	}
}
