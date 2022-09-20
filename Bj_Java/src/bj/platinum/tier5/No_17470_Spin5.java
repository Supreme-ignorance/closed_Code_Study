package bj.platinum.tier5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No_17470_Spin5 {
	static int[][] map;
	static int n;
	static int m;
	static int skin;
	static int r;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		skin = Math.min(n, m) / 2;

		map = new int[n][m];

		for (int r = 0; r < n; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < m; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < r; i++) {
			spinControl(Integer.parseInt(br.readLine()));
		}
		
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}

	static void spinControl(int command) {
		switch (command) {
		case 1:
			upsideDown();
			break;
		case 2:
			leftAndRightReverse();
			break;
		case 3:
			cW();
			break;
		case 4:
			cCW();
			break;
		case 5:
		case 6:
		}
	}

	static void cCW() {
		int[][] temp = new int[m][n];
		for (int i = 0; i < skin; i++) {
			// 상
			for (int c = i; c < m - i; c++)
				temp[m - 1 - c][i] = map[i][c];
			// 우
			for (int r = i; r < n - i; r++)
				temp[i][r] = map[r][m - 1 - i];
			// 하
			for (int c = i; c < m - i; c++)
				temp[m - 1 - c][n - 1 - i] = map[n - 1 - i][c];
			// 좌
			for (int r = i; r < n - i; r++)
				temp[i][n - 1 - r] = map[r][i];
		}

		if (m % 2 == 1 && n % 2 == 1)
			temp[m / 2][n / 2] = map[n / 2][m / 2];

		map = temp;
	}

	static void cW() {
		int[][] temp = new int[m][n];
		for (int i = 0; i < skin; i++) {
			// 상
			for (int c = i; c < m - i; c++)
				temp[c][n - 1 - i] = map[i][c];
			// 우
			for (int r = i; r < n - i; r++)
				temp[m - 1 - i][n - 1 - r] = map[r][m - 1 - i];
			// 하
			for (int c = i; c < m - i; c++)
				temp[c][i] = map[n - 1 - i][c];
			// 좌
			for (int r = i; r < n - i; r++)
				temp[i][n - 1 - r] = map[r][i];
		}

		if (m % 2 == 1 && n % 2 == 1)
			temp[m / 2][n / 2] = map[n / 2][m / 2];

		map = temp;
	}

	static void leftAndRightReverse() {
		int[][] temp = new int[n][m];
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				temp[r][c] = map[r][m - 1 - c];
			}
		}
		
		map = temp;
	}

	static void upsideDown() {
		int[][] temp = new int[n][m];
		
		for (int r = 0; r < n; r++) {
			temp[r] = map[n - 1 - r]; 
		}
		
		map = temp;
	}
}