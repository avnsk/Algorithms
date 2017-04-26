import java.util.*;
import java.lang.*;
import java.io.*;

 class Solution {
   int arr[] = new int[500005];
   int sqlen ;
   static int temp[] = new int[100005];
  public void buildSqrtDecompTable(int temp[]) {
    int len = temp.length;
    sqlen = (int) Math.ceil(Math.sqrt(len));

    //arr = new int[sqlen+1];
    Arrays.fill(arr, Integer.MAX_VALUE);
    int index = -1;
    for(int i = 0 ; i < len ; i++) {
      if(i%sqlen == 0) {
        index++;
      }
      arr[index] = Math.min(arr[index],temp[i]);
    }
  }

  public int getMinInRange(int l, int r) {
    int min = Integer.MAX_VALUE;
    while(l%sqlen != 0 && l < r && l != 0) {
      min = Math.min(min, temp[l++]);
    }

    while(l+sqlen <= r) {
      min = Math.min(min, arr[l/sqlen]);
      l += sqlen;
    }

    while(l <= r) {
      min = Math.min(min, temp[l++]);
    }

    return min;
  }

  public static void main (String[] args) throws java.lang.Exception {
      Parser in = new Parser(System.in);
  		StringBuilder string = new StringBuilder();
  		int n = in.nextInt();
      //temp = new int[n];
  		for (int i = 0; i < n; i++) {
  			temp[i] = in.nextInt();
  		}
      Solution sol  = new Solution();
      sol.buildSqrtDecompTable(temp);

      int q = in.nextInt();
		 for (int j = 0; j < q; j++) {
			 int r = in.nextInt();
			 int s = in.nextInt();
			 int ans = sol.getMinInRange(r, s);
			 string.append(ans + "\n");
		}

		 System.out.print(string);
  }


  static class Parser
{
   final private int BUFFER_SIZE = 1 << 16;

   private DataInputStream din;
   private byte[] buffer;
   private int bufferPointer, bytesRead;

   public Parser(InputStream in)
   {
      din = new DataInputStream(in);
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
   }

   public long nextLong() throws Exception
   {
      long ret = 0;
      byte c = read();
      while (c <= ' ') c = read();
      boolean neg = c == '-';
      if (neg) c = read();
      do
      {
         ret = ret * 10 + c - '0';
         c = read();
      } while (c > ' ');
      if (neg) return -ret;
      return ret;
   }

   //reads in the next string
   public String next() throws Exception
   {
      StringBuilder ret = new StringBuilder();
      byte c = read();
      while (c <= ' ') c = read();
      do
      {
         ret = ret.append((char)c);
         c = read();
      } while (c > ' ');
      return ret.toString();
   }

   public int nextInt() throws Exception
   {
      int ret = 0;
      byte c = read();
      while (c <= ' ') c = read();
      boolean neg = c == '-';
      if (neg) c = read();
      do
      {
         ret = ret * 10 + c - '0';
         c = read();
      } while (c > ' ');
      if (neg) return -ret;
      return ret;
   }

   private void fillBuffer() throws Exception
   {
      bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
      if (bytesRead == -1) buffer[0] = -1;
   }

   private byte read() throws Exception
   {
      if (bufferPointer == bytesRead) fillBuffer();
      return buffer[bufferPointer++];
   }
}
}
