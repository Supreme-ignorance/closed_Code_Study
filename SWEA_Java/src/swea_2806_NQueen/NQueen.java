package swea_2806_NQueen;

import java.util.Scanner;

public class NQueen {
	static boolean[][] map;
	static int n;
	static int res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			n = sc.nextInt();
			res = 0;

			map = new boolean[n][n];
			putQueen(0);
			
			System.out.println("#" + t + " " + res);
		}
	}
	
	static void putQueen(int r) {
		if (r == n) {
			res++;
			return;
		}
		
		for (int c = 0; c < n; c++) {
			if (isPutable(r, c)) {
				map[r][c] = true;
				putQueen(r + 1);
				map[r][c] = false;
			}
		}
	}
	
	static boolean isPutable(int r, int c) {
		int[] dc = {-1, 0, 1};
		
		for(int i = 0; i < 3; i++) {
			for (int j = 1; j < n; j++) {
				int insr = r + j * -1;
				int insc = c + j * dc[i];
				
				if (insr < 0 || insc < 0 || insc >= n) break;
				
				if (map[insr][insc]) return false;
			}
		}
		
		return true;
	}
}
