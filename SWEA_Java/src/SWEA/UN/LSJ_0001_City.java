package SWEA.UN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LSJ_0001_City {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		
		int[][] adj = new int[n][n];
		
		for (int r = 0; r < n; r++) {
			Arrays.fill(adj[r], 100000000);
		}
		for (int r = 0; r < n; r++) {
			adj[r][r] = 0;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			int val = Integer.valueOf(st.nextToken());
			
			adj[r][c] = adj[c][r] = val;
		}
		
		for (int k = 0; k < n; k++) {
			for (int s = 0; s < n; s++) {
				for (int e = 0; e < n; e++) {
					adj[s][e] = adj[e][s] = Math.min(adj[s][e], adj[s][k] + adj[k][e]);
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		int idx = -1;
		for (int r = 0; r < n; r++) {
			int sum = 0;
			for (int c = 0; c < n; c++) {
				sum += adj[r][c];
			}
			if (min > sum) {
				min = sum;
				idx = r;
			}
		}
		
		System.out.println(idx);
		System.out.println(min);
	}
}
