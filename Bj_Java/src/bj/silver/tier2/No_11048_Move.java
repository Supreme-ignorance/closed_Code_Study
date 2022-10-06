package bj.silver.tier2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_11048_Move {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		
		int[][] dp = new int[2][m + 1];
		
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < m + 1; j++) {
				dp[1][j] = dp[1][j - 1];
				dp[1][j] = Math.max(dp[1][j], dp[0][j - 1]);
				dp[1][j] = Math.max(dp[1][j], dp[0][j]);
				dp[1][j] += Integer.valueOf(st.nextToken());
			}
			
			dp[0] = dp[1];
			dp[1] = new int[m + 1];
		}
		
		System.out.println(dp[0][m]);
	}
}
