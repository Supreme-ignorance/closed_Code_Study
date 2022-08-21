package bj_No_2669_Area;

import java.util.Scanner;

public class Area {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] all = new int[100][100];
		
		for (int i = 0; i < 4; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int lx = sc.nextInt();
			int ly = sc.nextInt();
			
			for (int j = x; j < lx; j++) {
				for (int k = y; k < ly; k++) {
					all[j][k] = 1;
				}
			}
		}
		
		int sum = 0;
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				sum += all[i][j];
			}
		}
		
		System.out.println(sum);
	}
}
