package SWEA.UN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2105_Dessert {
	static int n;
	static int[][] map;
	static boolean[] visited;
	static int[] dr = {1, 1, -1, -1};
	static int[] dc = {-1, 1, 1, -1};
	static int res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.valueOf(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			n = Integer.valueOf(br.readLine());
			
			map = new int[n][n];
			visited = new boolean[101];
			res = -1;
			
			for (int r = 0; r < n; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < n; c++) {
					map[r][c] = Integer.valueOf(st.nextToken());
				}
			}
			
			for (int r = 0; r < n - 2; r++) {
				for (int c = 0; c < n - 1; c++) {
					visited[map[r][c]] = true;
					dfs(r, c, r, c, 0, 0);
					visited[map[r][c]] = false;
				}
			}
			
			System.out.println("#" + t + " " + res);
		}
	}
	
	private static void dfs(int r, int c, int startr, int startc, int dir, int cnt) {
		if ((dir == 3 || dir == 2) && r == startr + 1) {
			if (c == startc + 1) {
				res = Math.max(res, cnt + 1);
			}
			return;
		}
		
		for (int i = dir; i < 4; i++) {
			if (i == dir + 2 || i == dir + 3) continue;
			int tempr = r + dr[i];
			int tempc = c + dc[i];
			if (tempr < 0 || tempr >= n || tempc < 0 || tempc >= n) continue;
			int nextVal = map[tempr][tempc];
			if (!visited[nextVal]) {
				visited[nextVal] = true;
				dfs(tempr, tempc, startr, startc, i, cnt + 1);
				visited[nextVal] = false;
			}
		}
	}
}
