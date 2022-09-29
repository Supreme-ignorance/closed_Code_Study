package bj.gold.tier4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_12865_NormalBackpack {
	static int n;
	static int k;
	static int limit;
	static int[][] items;
	static int[][] dp;
	static int maxVal = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
		limit = 1 << n;
		
		items = new int[n][2];
		dp = new int[limit][2];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			items[i][0] = Integer.valueOf(st.nextToken());
			items[i][1] = Integer.valueOf(st.nextToken());
		}
		
		backpack(0, 0);
		
		System.out.println(maxVal);
	}
	
	private static void backpack(int current, int bitmask) {
		if (current == n) return;
		
		if (dp[bitmask][0] <= k && maxVal < dp[bitmask][1]) maxVal = dp[bitmask][1];
		
		//안고른다.
		backpack(current + 1, bitmask);
		
		int nextBitmask = bitmask + (1 << current);
		
		dp[nextBitmask][0] = dp[bitmask][0] + items[current][0];
		dp[nextBitmask][1] = dp[bitmask][1] + items[current][1];
		
//		System.out.println(dp[nextBitmask][0] + " " + dp[nextBitmask][1]);
		
		//고른다.
		backpack(current + 1, nextBitmask);
	}
}
