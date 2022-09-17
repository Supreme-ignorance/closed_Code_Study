package bj_No_1300_Kthnum;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Kthnum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextInt();
		long k = sc.nextInt();

		PriorityQueue<numWithC> pq = new PriorityQueue<>();
		
		for (int i = 1; i <= n; i++) {
			pq.add(new numWithC((long) i, 1, i));
		}
		
		for (int i = 1; i < k; i++) {
			long tempr = pq.peek().r;
			long tempc = pq.peek().c;
			
			if (++tempr <= n) {
				pq.add(new numWithC((long) tempr * tempc, tempr, tempc));
			}
			pq.poll();
		}
		
		System.out.println(pq.poll().num);
	}
}

class numWithC implements Comparable<numWithC> {
	long num;
	long r;
	long c;
	
	public numWithC(long num, long r, long c) {
		super();
		this.num = num;
		this.r = r;
		this.c = c;
	}

	@Override
	public int compareTo(numWithC o) {
		int res;
    	if (num == o.num) res = this.c <= o.c ? 1 : -1;
    	else res = this.num <= o.num ? -1 : 1;
    	
        return res;
	}
}
