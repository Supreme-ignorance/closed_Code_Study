package bj.gold.tier1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO_13977_Fermat {
	static long[] fac;
	static int decimal = 1000000007;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int m = Integer.valueOf(br.readLine());

		fac = new long[4000001];
		fac[0] = 1;
		
		for (int i = 1; i < 4000001; i++) {
			fac[i] = (i * fac[i - 1]) % decimal;
		}

		for (int tc = 0; tc < m; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.valueOf(st.nextToken());
			int k = Integer.valueOf(st.nextToken());

			long numerator = fac[n];
			long denominator = (fac[n - k] * fac[k]) % decimal;

			long res = (numerator * (pow(denominator, decimal - 2) % decimal)) % decimal;

			System.out.println(res);
		}
	}

	public static long pow(long a, long b) {
		if (b == 0)
			return 1;
		long ans = pow(a, b / 2);
		long next = (ans * ans) % 1000000007;
		if (b % 2 == 0)
			return next;
		else
			return (next * a) % 1000000007;
	}

}
