package Bj_no_16927_arraysturn;

import java.util.Scanner;

public class arraysTurn2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int t = sc.nextInt();
		
		int[][] arr = new int [n][m];
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				arr[r][c] = sc.nextInt();
			}
		}
		
		turn(arr, t);
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				System.out.println(arr[r][c] + " ");
			}
			System.out.println();
		}
	}
	
	static void turn(int[][] arr, int t) {
		if (t == 0) return;
		int n = arr.length;
		int m = arr[0].length;
		int[][] temp = new int[n][m];
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				temp[r][c] = arr[r][c]
			}
		}
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				arr[r][c] = temp[r][c];
			}
		}
		
		turn(arr, --t);
	}
}
