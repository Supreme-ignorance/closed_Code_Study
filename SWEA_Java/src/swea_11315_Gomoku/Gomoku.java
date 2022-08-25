package swea_11315_Gomoku;

import java.util.Scanner;

public class Gomoku {
	static int[] dr = { -1, 1, 0, 0, 1, 1, -1, -1 };
	static int[] dc = { 0, 0, -1, 1, 1, -1, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();

			char[][] map = new char[n][n];

			for (int r = 0; r < n; r++) {
				String temp = sc.next();
				for (int c = 0; c < n; c++) {
					map[r][c] = temp.charAt(c);
				}
			}
			System.out.print("#" + t + " ");
			iswin(map, n);
		}
		
		sc.close();
	}

	static void iswin(char[][] map, int n) {
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (map[r][c] != 'o')
					continue;
				for (int i = 0; i < 8; i++) {
					int cnt = 1;
					for (int j = 1;; j++) {
						int mr = r + j * dr[i];
						int mc = c + j * dc[i];
						if (mr < n && mr >= 0 && mc < n && mc >= 0 && map[mr][mc] == 'o') {
							cnt++;
							if (cnt >= 5) {
								System.out.println("YES");
								return;
							}
						} else
							break;
					}
				}
			}
		}
		System.out.println("NO");
	}
}
