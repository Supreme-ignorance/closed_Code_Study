package SWEA.UN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_1767_Processor {
	static int n;
	static int[][] map;
	static int[] order;
	static boolean[] visited;
	static List<int[]> cores;
	static int cs;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int resCore;
	static int res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.valueOf(br.readLine());

		for (int t = 1; t <= tc; t++) {
			resCore = Integer.MIN_VALUE;
			res = Integer.MAX_VALUE;
			n = Integer.valueOf(br.readLine());
			map = new int[n][n];
			cores = new ArrayList<int[]>();

			for (int r = 0; r < n; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < n; c++) {
					map[r][c] = Integer.valueOf(st.nextToken());
					// 코어 위치 입력받기 (외곽 제외)
					if (map[r][c] == 1 && (r != 0 && r != n - 1 && c != 0 && c != n - 1))
						cores.add(new int[] { r, c });
				}
			}

			cs = cores.size();
			visited = new boolean[cs];
			order = new int[cs];

			dfs(0, 0);

			System.out.println("#" + t + " " + res);
		}
	}

	static void dfs(int depth, int coreNum) {
		if (coreNum + cs - depth < resCore) return;
		if (depth == cs) {
			int lines = 0;
			int core = 0;
			
			int[][] temp = new int[n][n];
			
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					temp[r][c] = map[r][c];
				}
			}
			
			for (int i = 0; i < cs; i++) {
				if (core + cs - i < resCore) return;
				int line = 0;
				
				if (order[i] != 4) {
					line = isIgo(temp, cores.get(i)[0], cores.get(i)[1], order[i]);
				}
				
				if (line != 0) {
					lines += line;
					core++;
				}
			}
			
			if (core > resCore) {
				res = lines;
				resCore = core;
			} else if (core == resCore && res > lines) {
				res = lines;
			}
			return;
		}

		for (int i = 0; i < 5; i++) {
			if (!visited[depth]) {
				visited[depth] = true;
				order[depth] = i;
				if (i == 5) dfs(depth + 1, coreNum);
				else dfs(depth + 1, coreNum + 1);
				visited[depth] = false;
			}
		}
	}

	static int isIgo(int[][] temp, int pr, int pc, int dir) {
		int dist = 0;
		dist = 0;
		while (dir != -1) {
			dist++;
			int checkr = pr + dist * dr[dir];
			int checkc = pc + dist * dc[dir];

			if (checkr < 0 || checkr >= n || checkc < 0 || checkc >= n)
				break;
			
			if (temp[checkr][checkc] != 0)
				return 0;

			temp[checkr][checkc] = 2;
		}
		
		int min = dist - 1;
		
		return min;
	}
}
