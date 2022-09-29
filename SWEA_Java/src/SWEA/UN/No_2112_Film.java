package SWEA.UN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No_2112_Film {
	static int D;
	static int W;
	static int K;
	static boolean[][] film;
	static boolean[] A;
	static boolean[] B;
	static int res;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.valueOf(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			res = Integer.MAX_VALUE;
			
			D = Integer.valueOf(st.nextToken());
			W = Integer.valueOf(st.nextToken());
			K = Integer.valueOf(st.nextToken());
			
			film = new boolean[D][W];
			A = new boolean[W];
			B = new boolean[W];
			
			for (int r = 0; r < D; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < W; c++) {
					film[r][c] = Integer.valueOf(st.nextToken()) == 0;
				}
			}
			for (int c = 0; c < W; c++) {
				A[c] = true;
			}
			for (int c = 0; c < W; c++) {
				B[c] = false;
			}
			
			bfs(0, 0);
			
			System.out.println("#" + t + " " + res);
		}
	}
	
	static void bfs(int target, int depth) {
		if (isGood()) {
			if (res > depth) res = depth;
			return;
		}
		
		if (depth >= res || target == D || K < depth) return;
		
		boolean[] temp = film[target];
		
		
		bfs(target + 1, depth);
		
		film[target] = A;
		bfs(target + 1, depth + 1);
		
		film[target] = B;
		bfs(target + 1, depth + 1);
		
		film[target] = temp;
	}

	static boolean isGood() {
		boolean linecheck = false;
		
		for (int c = 0; c < W; c++) {
			int cnt = 0;
			linecheck = false;
			boolean evefilm = film[0][c];
			for (int r = 0; r < D; r++) {
				cnt++;
				if (evefilm == film[r][c]) {
					if (cnt == K) {
						linecheck = true;
						break;
					}
				} else {
					evefilm = film[r][c];
					cnt = 1;
				}
			}
			if (!linecheck) return linecheck;
		}
		return linecheck;
	}
}
