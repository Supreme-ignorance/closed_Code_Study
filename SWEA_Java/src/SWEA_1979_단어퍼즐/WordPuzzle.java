package SWEA_1979_단어퍼즐;

import java.util.Scanner;

public class WordPuzzle {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			int[][] puzzle = new int[n][n];
			int[] word = new int[k];
			
			//퍼즐 구성
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					puzzle[r][c] = sc.nextInt();
				}
			}
			
			// 체크용
			int cnt = 0;
			
			// 패턴 체크
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					boolean w_inword = true;
					boolean h_inword = true;
					for (int i = 0; i < k; i++) {
						if (c+i >= n || puzzle[r][c+i] != 1) w_inword = false;
						if (r+i >= n || puzzle[r+i][c] != 1) h_inword = false;
					}
					if ((c-1 >= 0 && puzzle[r][c-1] == 1) || (c+k < n && puzzle[r][c+k] == 1)) w_inword = false;
					if ((r-1 >= 0 && puzzle[r-1][c] == 1) || (r+k < n && puzzle[r+k][c] == 1)) h_inword = false;
					if (w_inword) {
						cnt++;
					}
					if (h_inword) {
						cnt++;
					}
				}
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	}
}
