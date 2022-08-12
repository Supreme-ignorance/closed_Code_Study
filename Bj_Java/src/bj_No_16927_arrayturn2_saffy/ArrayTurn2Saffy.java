package bj_No_16927_arrayturn2_saffy;

import java.util.Scanner;

public class ArrayTurn2Saffy {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int r = sc.nextInt();
		
		int[][] arr = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		ArrayTurn(arr, r);

		System.out.println();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
	
	static void ArrayTurn(int[][] arr, int r) {
		if (r == 0)
			return;
		int[][] temp = new int[arr.length][arr[0].length];
		int time = Math.min(arr.length, arr[0].length) / 2;
		
		for (int i = 0; i < time; i++) {
			// 좌측
			for (int a = i; a < arr.length - 1 - i; a++) {
				temp[a + 1][i] = arr[a][i];
			}
			// 하측
			for (int a = i; a < arr[0].length - 1 - i; a++) {
				temp[arr.length - 1 - i][a + 1] = arr[arr.length - 1 - i][a];
			}
			// 우측
			for (int a = 1+i; a < arr.length - i; a++) {
				temp[a - 1][arr[0].length - 1 - i] = arr[a][arr[0].length - 1 - i];
			}
			// 상측
			for (int a = 1+i; a < arr[0].length - i; a++) {
				temp[i][a - 1] = arr[i][a];
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = temp[i][j];
			}
		}
		
		ArrayTurn(arr, r-1);
	}
}
