package SWEA_1209_Sums;

import java.util.Scanner;

public class Sums {
	static final int SIZE = 100;
	static final int TC = 10;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = 0;
		while (t < TC) {
			t = sc.nextInt();
			
			int[][] arr = new int[SIZE][SIZE];
			
			for(int r = 0; r < SIZE; r++) {
				for(int c = 0; c < SIZE; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			
			int result = 0;
			int sum[] = {0,0,0,0}; // 가로, 세로, 대각선, 역대각선
			
			for(int r = 0; r < SIZE; r++) {
				sum[0] = 0;
				sum[1] = 0;
				for(int c = 0; c < SIZE; c++) {
					sum[0] += arr[r][c];
					sum[1] += arr[c][r];
					if (r == c) sum[2] += arr[r][c];
					if (r + c == SIZE-1) sum[3] += arr[r][c];
				}
				for (int i = 0; i < sum.length; i++) {
					result = Math.max(result, sum[i]);
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}
