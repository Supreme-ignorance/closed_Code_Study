package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_7733_Cheese {
	
	static int n;
	static int[][] cheece;
	static boolean[][] visited;
	static Queue<int[]> Q = new LinkedList<int[]>();
	static int lump;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.valueOf(br.readLine());

		for (int t = 1; t <= tc; t++) {
			n = Integer.valueOf(br.readLine());

			res = 0;
			cheece = new int[n][n];

			for (int r = 0; r < n; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < n; c++) {
					cheece[r][c] = Integer.valueOf(st.nextToken());
				}
			}

			int day = 0;
			do {
				lump = 0;
				visited = new boolean[n][n];

				for (int r = 0; r < n; r++) {
					for (int c = 0; c < n; c++) {
						if (cheece[r][c] > day && !visited[r][c]) {
							Q.add(new int[] { r, c });
							bfs(day);
						}
					}
				}

				if (res < lump)
					res = lump;
				day++;
			} while (lump != 0);

			System.out.println("#" + t + " " + res);
		}
	}

	private static void bfs(int day) {
		lump++;

		while (!Q.isEmpty()) {
			int r = Q.peek()[0];
			int c = Q.poll()[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nr >= n || nc < 0 || nc >= n)
					continue;

				if (cheece[nr][nc] > day && !visited[nr][nc]) {
					visited[nr][nc] = true;
					Q.add(new int[] { nr, nc });
				}
			}
		}
	}
}
