package bj_No_17406_ArrayTurn4;

import java.util.Scanner;

public class ArrayTurn4 {
	static int n;
	static int m;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n][m];
		
		int k = sc.nextInt();
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				arr[r][c] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < k; i++) {
			int startr = sc.nextInt();
			int startc = sc.nextInt();
			int range = sc.nextInt();
			ArrayTurn(startr - 1, startc - 1, range);
		}
		
		int min = Integer.MAX_VALUE;
		int sum;
		
		for (int r = 0; r < n; r++) {
			sum = 0;
			for (int c = 0; c < m; c++) {
				sum += arr[r][c];
			}
			if (min > sum) min = sum;
		}
		
		System.out.println(min);
	}
	
	static void ArrayTurn(int sr, int sc, int range) {
		int[][] temp = new int[n][m];
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				temp[r][c] = arr[r][c];
			}
		}
		
		for (int i = 0; i < range; i++) {
			for (int c = sc - range + i; c < sc + range - i; c++) {
				temp[sr - range + i][c+1] = arr[sr - range + i][c];
			}
			for (int r = sr - range + i; r < sr + range - i; r++) {
				temp[r+1][sc + range - i] = arr[r][sc + range - i];
			}
			for (int c = sc - range + 1 + i; c <= sc + range - i; c++) {
				temp[sr + range - i][c-1] = arr[sr + range - i][c];
			}
			for (int r = sr - range + 1 + i; r <= sr + range - i; r++) {
				temp[r-1][sc - range + i] = arr[r][sc - range + i];
			}
		}
		
		for (int r = sr - range; r <= sr + range; r++) {
			for (int c = sc - range; c <= sc + range; c++) {
				arr[r][c] = temp[r][c];
			}
		}
	}
}
