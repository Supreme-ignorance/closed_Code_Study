package SWEA.UN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class No_5656_Brick {
	static int n; // 쏘아올린 공의 개수
	static int w; // 너비
	static int h; // 높이
	static int[][] map;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			res = Integer.MAX_VALUE;

			map = new int[h][w];

			for (int r = 0; r < h; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < w; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			dfs(0);

			System.out.println("#" + t + " " + res);
		}
	}

	private static void dfs(int depth) {
		if (depth == n) {
			int score = getScore();
			if (score < res) {
				res = score;
			}
			return;
		}

		int[][] currentMap = new int[h][w];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				currentMap[i][j] = map[i][j];
			}
		}

		for (int c = 0; c < w; c++) {
			boolean isnotemp = actRemove(c);

			if (isnotemp)
				actFall();

			dfs(depth + 1);

			if (isnotemp)
				for (int i = 0; i < h; i++) {
					for (int j = 0; j < w; j++) {
						map[i][j] = currentMap[i][j];
					}
				}
		}
	}

	private static int getScore() {
		int cnt = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (map[i][j] != 0)
					cnt++;
			}
		}
		return cnt;
	}

	private static void actFall() {
		for (int c = 0; c < w; c++) {
			Stack<Integer> s = new Stack<>();
			for (int r = 0; r < h; r++) {
				if (map[r][c] != 0) {
					int temp = map[r][c];
					map[r][c] = 0;
					s.add(temp);
				}
			}

			int idx = h - 1;
			while (!s.isEmpty()) {
				map[idx][c] = s.pop();
				idx--;
			}
		}
	}

	private static boolean actRemove(int c) {
		int r = 0;

		while (r < h) {
			if (map[r][c] != 0)
				break;
			r++;
		}

		if (r == h)
			return false;

		int range = map[r][c] - 1;

		map[r][c] = 0;

		if (range == 0)
			return true;

		for (int i = 0; i < 4; i++) {
			for (int d = 1; d <= range; d++) {
				int nr = r + d * dr[i];
				int nc = c + d * dc[i];

				if (nr < 0 || nr >= h || nc < 0 || nc >= w)
					break;

				actRemove(nr, nc);
			}
		}

		return true;
	}

	private static void actRemove(int r, int c) {
		int range = map[r][c] - 1;

		map[r][c] = 0;

		if (range <= 0)
			return;

		for (int i = 0; i < 4; i++) {
			for (int d = 1; d <= range; d++) {
				int nr = r + d * dr[i];
				int nc = c + d * dc[i];

				if (nr < 0 || nr >= h || nc < 0 || nc >= w)
					break;

				actRemove(nr, nc);
			}
		}
	}
}