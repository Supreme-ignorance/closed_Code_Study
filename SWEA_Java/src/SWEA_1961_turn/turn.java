package SWEA_1961_turn;

import java.util.Scanner;

public class turn {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			int n =sc.nextInt();
			
			String[][] arr = new String[n][n];
			String[][] result = new String[n][3];
			
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					arr[r][c] = sc.next();
				}
			}
			
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < 3; c++) {
					result[r][c] = "";
				}
			}
			
			turnarrays(arr, result);
			
			System.out.println("#" + t);
			
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < 3; c++) {
					System.out.print(result[r][c] + " ");
				}
				System.out.println();
			}
		}
	}
	
	static void turnarrays(String[][] arr, String[][] result) {
		
		String[][] temp = new String[arr.length][arr.length];
		
		for (int i = 0; i < 3; i++) {
			for (int r = 0; r < arr.length; r++) {
				for (int c = 0; c < arr.length; c++) {
					temp[r][c] = arr[arr.length-c-1][r];
				}
			}
			for (int r = 0; r < arr.length; r++) {
				for (int c = 0; c < arr.length; c++) {
					arr[r][c] = temp[r][c];
				}
			}
			for (int j = 0; j < arr.length; j++) {
				for (int r = 0; r < arr.length; r++) {
					result[j][i] += arr[j][r];
				}
			}
		}
	}
}
