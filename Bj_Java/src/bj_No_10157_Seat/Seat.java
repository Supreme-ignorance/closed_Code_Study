package bj_No_10157_Seat;

import java.util.Scanner;

public class Seat {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int want = sc.nextInt();
		
		if (want > n * m) {
			System.out.println("0");
			return;
		}
		
		int[][] arr = new int[m+2][n+2];
		
		for (int i = 0; i < m+2; i++) {
			arr[i][0] = -1;
			arr[i][n+1] = -1;
		}
		for (int i = 0; i < n+2; i++) {
			arr[0][i] = -1;
			arr[m+1][i] = -1;
		}
		
		int[] dy = { 1, 0, -1, 0};
		int[] dx = { 0, 1, 0, -1};
		
		int num = 1;
		int r = 0;
		int c = 1;
		int idx = 0;
		
		while (num <= m * n) {
			if (arr[r+dy[idx]][c+dx[idx]] != 0) idx = (idx + 1) % 4;
			r = r+dy[idx];
			c = c+dx[idx];
			arr[r][c] = num++;
		}
		
		for (int i = 0; i < m +2; i ++) {
			for (int j = 0; j < n +2; j ++) {
				if (arr[i][j] == want) System.out.println(j + " " + i);
			}
		}
	}
}
