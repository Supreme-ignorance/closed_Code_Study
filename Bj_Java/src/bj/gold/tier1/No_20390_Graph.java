package bj.gold.tier1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No_20390_Graph {
	static int n;
	static long A, B, C, D;
	static final long INF = Long.MAX_VALUE;
	static long[] edge;
	static long[][] adj;
	static boolean[] visited;
	static long[] dist;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		edge = new long[n];
		adj = new long[n][n];
		visited = new boolean[n];
		dist = new long[n];
		
		Arrays.fill(dist, INF);
		
		st = new StringTokenizer(br.readLine());
		
		A = Long.valueOf(st.nextToken());
		B = Long.valueOf(st.nextToken());
		C = Long.valueOf(st.nextToken());
		D = Long.valueOf(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			edge[i] = Long.valueOf(st.nextToken());
		}
		
		for (int r = 0 ; r < n; r++) {
			for (int c = 0 ; c < n; c++) {
				if (r < c) 
					adj[r][c] = adj[c][r] = ((edge[r] * A + edge[c] * B) % C) ^ D;
			}
			System.out.println(Arrays.toString(adj[r]));
		}
		
		long res = prim();
		
		System.out.println();
		System.out.println(Arrays.toString(dist));
		System.out.println(res);
	}
	
	private static long prim() {
		
		int idx = -1;
		dist[0] = 0;
		
		for (int i = 0; i < n - 1; i++) {
			long min = INF;
			
			for (int j = 0; j < n; j++) {
				if (!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}
			
			visited[idx] = true;
			
			for (int j = 0; j < n; j++) {
				if (!visited[j] && adj[idx][j] != 0) {
					dist[j] = Math.min(dist[j], adj[idx][j]);
				}
			}
		}
		
		long res = 0;
		
		for (int i = 0; i < n; i++) {
			res += dist[i];
		}
		
		return res;
	}
}
