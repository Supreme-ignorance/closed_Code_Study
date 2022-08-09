package SWEA_1208_Flatten;

import java.util.Scanner;

public class Flatten {
	
	static int tc = 10;
	static final int SIZE = 100;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <=tc ; t++) {
			int n = sc.nextInt();
			int[] map = new int[SIZE];
			
			for (int i = 0; i < SIZE; i++) {
				map[i] = sc.nextInt();
			}
			
			for (int i = 0; i < n; i++) {
				int minidx = -1;
				int minval = Integer.MAX_VALUE;
				int maxidx = -1;
				int maxval = Integer.MIN_VALUE;
				
				for (int j = 0; j < SIZE; j++) {
					if (maxval < map[j]) {
						maxidx = j;
						maxval = map[j];
					}
					if (minval > map[j]) {
						minidx = j;
						minval = map[j];
					}
				}
				
				--map[maxidx];
				++map[minidx];
			}
			
			int minidx = -1;
			int minval = Integer.MAX_VALUE;
			int maxidx = -1;
			int maxval = Integer.MIN_VALUE;
			
			for (int j = 0; j < SIZE; j++) {
				if (maxval < map[j]) {
					maxidx = j;
					maxval = map[j];
				}
				if (minval > map[j]) {
					minidx = j;
					minval = map[j];
				}
			}
			
			System.out.println("#" + t + " " + (map[maxidx] - map[minidx]));
		}
	}
}
