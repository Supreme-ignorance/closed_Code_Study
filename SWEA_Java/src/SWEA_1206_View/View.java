package SWEA_1206_View;

import java.util.Scanner;

public class View {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 10;
		
		for(int t = 0; t < tc; t++) {
			int n = sc.nextInt();
			
			int[] map = new int[n];
			
			for (int i = 0; i < n; i++) {
				map[i] = sc.nextInt();
			}

			int sum = 0;
			for (int i = 2; i < n-2; i ++) {
				sum += map[i] - map[highest(map, i)];
			}
			
			System.out.println("#" + (t+1) + " " + sum);
		}
	}
	
	static int highest (int[] map, int p) {
		
		int firstidx = 0;
		int secondidx = 0;
		
		for (int i = p - 2; i <= p+2; i++) {
			if(map[firstidx] <= map[i]) firstidx = i;
		}
		for (int i = p - 2; i <= p+2; i++) {
			if(map[secondidx] <= map[i] && firstidx != i) secondidx = i;
		}
		
		if (firstidx == p) return secondidx;
		else return p;
	}
}
