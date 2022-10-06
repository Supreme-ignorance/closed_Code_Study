package bj.gold.tier5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class No_2565_PowerCord {
	static int n;
	static int[][] map;
	static int[] dp;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.valueOf(br.readLine());

		map = new int[n][2];
		dp = new int[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.valueOf(st.nextToken());
			map[i][1] = Integer.valueOf(st.nextToken());
		}
		
		Arrays.sort(map, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
			
		});
		
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (map[j][1] < map[i][1])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			max = Math.max(dp[i], max);
		}
		
		System.out.println(n - max);
	}
}
