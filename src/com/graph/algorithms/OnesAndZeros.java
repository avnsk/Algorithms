import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	class Pair {
		long rem;
		String num;
		public Pair() { }
	}
	
	public  String bfs(int n) {
		Queue<Pair> queue = new LinkedList<Pair>();
		
		Pair obj3 = new Pair();
		obj3.num = "1";
		obj3.rem = 1;
		queue.add(obj3);
		
		while(!queue.isEmpty()) {
			obj3 = queue.poll();
		//	System.out.println(obj1.num);
		    Pair obj1 = new Pair();
		    Pair obj2 = new Pair();
			long rem = obj3.rem;
			String num = obj3.num;
			if(rem % n == 0) {
				return obj3.num;
			} else {
				obj2.num = num + "1";
				obj2.rem = (rem % n) *10 + 1;
				obj1.num = num + "0";
				obj1.rem = (rem % n)*10 + 0;
				
				if(obj1.rem % n == 0 )
				return obj1.num;
				if(obj2.rem % n == 0)
				return obj2.num;
				System.out.println(obj1.num);
				System.out.println(obj2.num);
				queue.offer(obj1);
				queue.offer(obj2);
				//obj3 = null;
				//obj1 = null;
				//obj2 = null;
			}
		}
		
		return "";
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Ideone id = new Ideone();
		System.out.println(id.bfs(9999999));
	}
}
