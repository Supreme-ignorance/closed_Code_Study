package SWEA_1954_snail;

import java.util.Scanner;

public class Snail {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			
			int[][] arr = new int[n][n];
			
			int num = 1;
			
			int r = 0;
			int c = -1;
			int width = n;
			int height = n - 1;

			while (num <= Math.pow(n, 2)) {
				for (int j = 0; j < width; j++) {
					arr[r][++c] = num++;
				}
				width--;

				for (int j = 0; j < height; j++) {
					arr[++r][c] = num++;
				}
				height--;
				
				for (int j = 0; j < width; j++) {
					arr[r][--c] = num++;
				}
				width--;

				for (int j = 0; j < height; j++) {
					arr[--r][c] = num++;
				}
				height--;
			}

			System.out.println("#" + t);

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
