package bj_No_10158_Ant;

import java.util.Scanner;

public class Ant {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt() + 1;
		int m = sc.nextInt() + 1;
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int time = sc.nextInt();
		
		int[][] dx = { {1, 1, -1, -1}, { 1, 1, -1, -1}, { -1, -1, 1, 1 }, {-1, -1, 1, 1}};
		int[][] dy = { {1, -1, 1, -1}, { -1, 1, -1, 1}, { 1, -1, 1, -1 }, {-1, 1, -1, 1}};
		int[][] ck = { {0, 1, 2, 3}, { 1, 0, 3, 2}, { 2, 3, 0, 1 }, {3, 2, 1, 0}};
		
		int dir = 0;
		
		for (int i = 0; i < time; i++) {
			for (int j = 0; j < 4; j++) {
				int tempx = x + dx[dir][j];
				int tempy = y + dy[dir][j];
				if (tempx < 0 || tempx >= n || tempy < 0 || tempy >= m) continue;
				dir = ck[dir][j];
				x = tempx;
				y = tempy;
				break;
			}
		}
		
		System.out.println(x + " " + y);
	}
}
