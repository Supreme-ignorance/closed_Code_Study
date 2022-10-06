package bj.silver.tier3;

import java.util.Scanner;

public class No_1463_MakeOne {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		int[] dp = new int[input + 1];
		
		for (int i = 2; i < input + 1; i++) {
			dp[i] = dp[i - 1] + 1;
			if (i % 3 == 0)
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			if (i % 2 == 0)
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
		}
		
		System.out.println(dp[input]);
	}
}
