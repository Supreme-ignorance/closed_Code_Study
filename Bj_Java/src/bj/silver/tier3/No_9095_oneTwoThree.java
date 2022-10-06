package bj.silver.tier3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_9095_oneTwoThree {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.valueOf(br.readLine());
		
		int dpsize = 10;
		int[] dp = new int[dpsize + 1];
		
		dp[0] = 1;
		
		for (int i = 1; i < dpsize + 1; i++) {
			if (i - 3 >= 0)
				dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
			else if (i - 2 >= 0)
				dp[i] = dp[i - 1] + dp[i - 2];
			else if (i - 1 >= 0)
				dp[i] = dp[i - 1];
		}
		
		for (int t = 0; t < tc; t++) {
			System.out.println(dp[Integer.valueOf(br.readLine())]);
		}
	}
}
