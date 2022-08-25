package swea_1289_MemoryRecovery;

import java.util.*;

public class MemoryRecovery {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int tc = 1; tc <= t; tc++) {
			Queue<Integer> q = new LinkedList<Integer>();
			String input = sc.next();

			for (int i = 0; i < input.length(); i++) {
				q.add(input.charAt(i) - '0');
			}
			
			int cnt = 0;
			int prevdata = 0;

			while (!q.isEmpty()) {
				if (prevdata != q.peek()) {
					prevdata = q.poll();
					cnt++;
				} else
					q.poll();
			}
			
			System.out.println("#" + tc + " " + cnt);
		}
		sc.close();
	}
}
