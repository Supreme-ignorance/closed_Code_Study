package SWEA.UN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_2112_Film {
	static int D;
	static int W;
	static int K;
	static boolean[][] film;
	static Queue<int[]> Q = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.valueOf(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			Q.clear();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			D = Integer.valueOf(st.nextToken());
			W = Integer.valueOf(st.nextToken());
			K = Integer.valueOf(st.nextToken());
			
			film = new boolean[D][W];
			
			for (int r = 0; r < D; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < W; c++) {
					film[r][c] = Integer.valueOf(st.nextToken()) == 0;
				}
			}
			
			Q.add(new int[] {0, 0});
			
			int res = bfs();
			
			System.out.println("#" + t + " " + res);
		}
	}
	
	static int bfs() {
		if (isGood(film)) return 0;
		while (!Q.isEmpty()) {
			int tryed = Q.peek()[0];
			int cell = Q.poll()[1] + 1 << tryed;
			
			if (tryed + 1 < D) Q.add(new int[] { tryed + 1, cell });
			
			boolean[][] temp = new boolean[D][W];
			System.out.println(tryed);
			
			for (int r = 0; r < D; r++) {
				for (int c = 0; c < W; c++) {
					if ((cell & (1 << tryed)) != 0) temp[r][c] = !film[r][c];
					else temp[r][c] = film[r][c];
					System.out.print(film[r][c] + " ");
				}
				System.out.println();
			}

			if (isGood(film)) return tryed + 1;

			if (tryed + 1 < 8) Q.add(new int[] { tryed + 1, cell });
		}

		return -1;
	}

	static boolean isGood(boolean[][] input) {
		boolean linecheck = false;
		
		for (int c = 0; c < W; c++) {
			int cnt = 0;
			linecheck = false;
			boolean evefilm = input[0][c];
			for (int r = 0; r < D; r++) {
				cnt++;
				if (evefilm == input[r][c]) {
					if (cnt == K) {
						linecheck = true;
						break;
					}
				} else {
					evefilm = input[r][c];
					cnt = 1;
				}
			}
			if (!linecheck) return linecheck;
		}
		
		return linecheck;
	}
}
