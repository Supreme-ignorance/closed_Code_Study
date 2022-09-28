package bj.gold.tier5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No_2565_PowerCord {
	static int n;
	static int[][] map;
	static int[] dp;

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
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if ((map[i][0] > map[j][0] && map[i][1] > map[j][1])
						|| (map[i][0] < map[j][0] && map[i][1] < map[j][1]))
					continue;
				
				dp[i]++;
				dp[j]++;
			}
			if (dp[i] > 1) {
				cnt++;
				for (int j = i + 1; j < n; j++) {
					if ((map[i][0] > map[j][0] && map[i][1] > map[j][1])
							|| (map[i][0] < map[j][0] && map[i][1] < map[j][1]))
						continue;
					dp[i] = 0;
					dp[j]--;
				}
			}
		}
		
		System.out.println (Arrays.toString(dp));
		Arrays.sort(dp);
		
		
		int sum = 0;
		
		for (int i = 0; i < n; i++) {
			sum += dp[i];
		}
		
		
		int idx = n - 1;
		while (sum > 0) {
			cnt++;
			sum -= 2 * dp[idx--];
		}
		
		System.out.println(cnt);
	}
}
