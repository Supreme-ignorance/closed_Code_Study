package bj.silver.tier3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1003_Fibo {
	static int[][] dp = new int[41][2];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		dp[0][0] = 1;
		dp[1][1] = 1;

		for (int i = 2; i < 41; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
			dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
		}

		int tc = Integer.valueOf(br.readLine());

		for (int t = 0; t < tc; t++) {
			int n = Integer.valueOf(br.readLine());
			System.out.println(dp[n][0] + " " + dp[n][1]);
		}
	}
}
