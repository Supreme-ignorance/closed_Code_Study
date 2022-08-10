package BJ_No_2563_confetti;

import java.util.Scanner;

public class Confetti {
	static final int SIZE = 100; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] paper = new int [SIZE][SIZE];
		
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			confetti(paper, x, y);
		}
		
		int sum = 0;
		for (int x = 0; x < 100; x++) {
			for (int y = 0; y < 100; y++) {
				sum += paper[x][y];
			}
		}
		
		System.out.println(sum);
	}
	
	static void confetti (int[][] paper, int sx, int sy) {
		for (int x = sx; x < sx + 10; x++) {
			for (int y = sy; y < sy + 10; y++) {
				paper[x][y] = 1;
			}
		}
	}
}
