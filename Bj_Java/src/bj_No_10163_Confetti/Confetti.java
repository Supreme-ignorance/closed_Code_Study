package bj_No_10163_Confetti;

import java.util.Scanner;

public class Confetti {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[1001][1001];
		
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			int fr = sc.nextInt();
			int fc = sc.nextInt();
			int pr = sc.nextInt();
			int pc = sc.nextInt();
			
			for (int r = fr; r < fr + pr; r++) {
				for (int c = fc; c < fc + pc; c++) {
					arr[r][c] = i;
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int r = 0; r < 1001; r++) {
				for (int c = 0; c < 1001; c++) {
					if (arr[r][c] == i) sum += 1;
				}
			}
			System.out.println(sum);
		}
 	}
}
