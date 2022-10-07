package bj.silver.tier2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

public class No_1912_Sum {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		int[] dp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		dp[0] = Integer.valueOf(st.nextToken());
		int max = dp[0];
		
		for (int i = 1; i < n; i++) {
			dp[i] = Integer.valueOf(st.nextToken());
			dp[i] = Math.max(dp[i], dp[i] + dp[i - 1]);
			max = Math.max(dp[i], max);
		}
		
		System.out.println(max);
	}
}
class Exercise implements Comparable<Exercise>{
	Date recent;
	int value;
	
	public Exercise(int value) {
		super();
		this.recent = new Date();
		this.value = value;
	}

	@Override
	public int compareTo(Exercise o) {
		Date now = new Date();
		Date date = this.recent;

		Calendar cal = Calendar.getInstance(); 
		cal.setTime(date);
		cal.add(Calendar.DATE, 2); //2일 더하기
		int dateDay = cal.DATE;
		
		cal.setTime(now);
		int nowDay = cal.DATE;
		
		if (dateDay < nowDay) {
			return this.value - o.value;
		} else 
			return 0 - o.value;
	}
}