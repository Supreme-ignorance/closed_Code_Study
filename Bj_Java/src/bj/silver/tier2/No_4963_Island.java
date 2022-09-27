package bj.silver.tier2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_4963_Island {
	static int n;
	static int m;
	static int res;
	static boolean[][] checked;
	static Queue<int[]> island = new LinkedList<int[]>();
	static int[] dr = {-1, 1, 0, 0, 1, 1, -1, -1};
	static int[] dc = {0, 0, -1, 1, 1, -1, 1, -1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			res = 0;
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			if (n == 0 && m == 0) break;
			
			checked = new boolean[n][m];
			
			for (int r = 0; r < n; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < m; c++) {
					if (Integer.parseInt(st.nextToken()) == 0) checked[r][c] = true;
				}
			}
			
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < m; c++) {
					findIsland(r, c);
				}
			}
			
			System.out.println(res);
		}
	}
	// 섬 걸리면 BFS
	static void findIsland(int r, int c) {
		if (!checked[r][c]) {
			res++;
			checked[r][c] = true;
			island.add(new int[] { r, c });

			while (!island.isEmpty()) {
				for (int i = 0; i < 8; i++) {
					int tempr = island.peek()[0] + dr[i];
					int tempc = island.peek()[1] + dc[i];

					if (tempr < 0 || tempr >= n || tempc < 0 || tempc >= m)
						continue;
					if (!checked[tempr][tempc]) {
						island.add(new int[] { tempr, tempc });
						checked[tempr][tempc] = true;
					}
				}
				island.poll();
			}
		}
	}
}
