package SWEA.UN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No_1251_Hanaro {
	static int n;
	static final long INF = Long.MAX_VALUE;
	static Island[] vertex;
	static long[] dist;
	static boolean[] visited;
	static long[][] adj;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());

			vertex = new Island[n];
			adj = new long[n][n];
			dist = new long[n];
			Arrays.fill(dist, INF);
			visited = new boolean[n];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				int r = Integer.parseInt(st.nextToken());
				vertex[i] = new Island(r);
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				int c = Integer.parseInt(st.nextToken());
				vertex[i].c = c;
			}

			double e = Double.valueOf(br.readLine());

			// 인접행렬 만들어주기
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					if (r < c) {
						Island islandr = vertex[r];
						Island islandc = vertex[c];

						int rlength = islandr.r - islandc.r;
						int clength = islandr.c - islandc.c;

						long temp = (long) (Math.pow(rlength, 2) + (long) Math.pow(clength, 2));
						adj[r][c] = adj[c][r] = temp;
					}
				}
			}

			// prim

			int idx = -1;
			dist[0] = 0;

			for (int i = 0; i < n - 1; i++) {
				double min = INF;

				for (int j = 0; j < n; j++) {
					if (!visited[j] && min > dist[j]) {
						idx = j;
						min = dist[j];
					}
				}

				visited[idx] = true;

				for (int j = 0; j < n; j++) {
					if (!visited[j]) {
						dist[j] = Math.min(dist[j], adj[idx][j]);
					}
				}
			}

			long sum = 0;

			for (int i = 0; i < n; i++) {
				sum += dist[i];
			}
			
			double res = e * sum;
			
			System.out.println("#" + t + " " + Math.round(res));
		}
	}
}

class Island {
	int r;
	int c;

	public Island(int r) {
		super();
		this.r = r;
	}
}