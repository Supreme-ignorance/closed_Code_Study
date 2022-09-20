package SWEA_1204_Mode;

import java.util.Scanner;

public class Mode {
	static final int SIZE = 1000;
	static final int MAX = 100;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t;
		
		do {
			t = sc.nextInt();
			
			int[] checkscore = new int[MAX+1]; // 0 ~ 100����
			
			for (int i = 0; i < SIZE; i++) {
				int score = sc.nextInt();
				checkscore[score]++;
			}
			
			int mode = 0;
			for (int i = 0; i <= MAX; i++) {
				if (checkscore[mode] < checkscore[i]) {
					mode = i;
				} else if (checkscore[mode] == checkscore[i]) {
					mode = i;
				}
			}
			
			System.out.println("#" + t + " " + mode);
		} while(t < tc);
	}
}
