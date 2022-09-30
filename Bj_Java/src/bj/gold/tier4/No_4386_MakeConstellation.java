package bj.gold.tier4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No_4386_MakeConstellation {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Star[] stars = new Star[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			stars[i] = new Star(Double.valueOf(st.nextToken()), Double.valueOf(st.nextToken()));
		}

		double[][] adj = new double[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				double starBetweenX = stars[i].x - stars[j].x;
				double starBetweenY = stars[i].y - stars[j].y;

				double dist = Math.sqrt(Math.pow(starBetweenX, 2) + Math.pow(starBetweenY, 2));

				adj[i][j] = adj[j][i] = dist;
			}
		}

		int idx = -1;
		double[] dist = new double[n];
		boolean[] visited = new boolean[n];
		Arrays.fill(dist, Double.MAX_EXPONENT);

		dist[0] = 0;

		for (int i = 0; i < n - 1; i++) {

			double min = Double.MAX_EXPONENT;
			for (int j = 0; j < n; j++) {
				if (!visited[j] && min > dist[j]) {
					idx = j;
					min = dist[idx];
				}
			}

			visited[idx] = true;

			for (int j = 0; j < n; j++) {
				if (!visited[j]) {
					dist[j] = Math.min(dist[j], adj[idx][j]);
				}
			}
		}

		double res = 0;

		for (int i = 0; i < n; i++) {
			res += dist[i];
		}

		System.out.println((double) Math.round(res * 100) / 100);
	}
}

class Star {
	double x;
	double y;

	public Star(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
}
