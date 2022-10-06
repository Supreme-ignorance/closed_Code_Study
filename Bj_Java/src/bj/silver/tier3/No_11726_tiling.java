package bj.silver.tier3;

import java.util.Scanner;

public class No_11726_tiling {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] dp = new int[n + 1];
		
		dp[0] = 1;
		dp[1] = 1;
		
		for (int i = 2; i < n + 1; i++) {
			dp[i] = (2 * dp[i - 2] + dp[i - 1]) % 10007;
		}
		
		System.out.println(dp[n]);
	}
}
