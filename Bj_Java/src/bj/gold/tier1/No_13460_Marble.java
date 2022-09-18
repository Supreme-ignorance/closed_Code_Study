package bj.gold.tier1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_13460_Marble {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int n;
	static int m;
	static int maxMove;
	
	static char[][] map;
	static Queue<int[]> Q = new LinkedList<>();
	
	static int[] initialR = new int[2];
	static int[] initialB = new int[2];
	static int[] O = new int[2];
	static boolean success = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		maxMove = Math.max(n, m) - 2;
		
		map = new char[n][m];
		
		for (int r = 0; r < n; r++) {
			char[] temp = br.readLine().toCharArray();
			for (int c = 0; c < m; c++) {
				map[r][c] = temp[c];
				checkPosition(r, c);
			}
		}
		
		Q.add(new int[] {initialR[0], initialR[1], initialB[0], initialB[1], 0});
		bfs(initialR[0], initialR[1], initialB[0], initialB[1], 0);
	}
	
	static void bfs (int Rr, int Rc, int Br, int Bc, int tryNum) {
		tryNum++;
		for (int i = 0; i < 4; i++) {
			
		}
	}
	
	static void incline (int dir) {
		int[] temp = Q.peek();
		for (int i = 1; i < maxMove; i++) {
			int Rr = temp[0] + dir * dr[i];
			int Rc = temp[1] + dir * dc[i];
		}
	}
	
	/**
	 * 각 구슬과 구멍의 위치를 파악
	 * @param r
	 * @param c
	 */
	static void checkPosition (int r, int c) {
		if (map[r][c] == 'R') {
			initialR[0] = r;
			initialR[1] = c;
		} else if (map[r][c] == 'B') {
			initialB[0] = r;
			initialB[1] = c;
		} else if (map[r][c] == 'O') {
			O[0] = r;
			O[1] = c;
		}
	}
}
