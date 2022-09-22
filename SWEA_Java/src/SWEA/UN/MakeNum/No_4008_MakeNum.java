package SWEA.UN.MakeNum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_4008_MakeNum {
	static final int PLUS = 0;
	static final int MINUS = 1;
	static final int MULTIPLY = 2;
	static final int DIVISION = 3;
	static int[] numberArr;
	static int[] operatorArr;
	static int[] calcArr;
	static int n;
	static int max;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.valueOf(br.readLine());

		for (int t = 1; t <= tc; t++) {
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			n = Integer.valueOf(br.readLine());

			numberArr = new int[n];
			operatorArr = new int[4];
			calcArr = new int[n - 1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				operatorArr[i] = Integer.valueOf(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				numberArr[i] = Integer.valueOf(st.nextToken());
			}

			perm(0, n - 1);
			
			int res = max - min;
			sb.append("#" + t + " " + res + "\n");
		}
		System.out.println(sb);
	}

	static void perm(int depth, int goal) {
		if (depth == goal) {
			int temp = calc();
			if (max < temp) max = temp;
			if (min > temp) min = temp;
				return;
		}

		for (int i = 0; i < 4; i++) {
			if (operatorArr[i] != 0) {
				operatorArr[i]--;
				calcArr[depth] = i;
				perm(depth + 1, goal);
				operatorArr[i]++;
			}
		}
	}
	
	static int calc() {
		int a = numberArr[0];
		int b;
		for (int i = 1; i < n; i++) {
			b = numberArr[i];
			switch (calcArr[i - 1]) {
			case PLUS:
				a = a + b;
				break;
			case MINUS:
				a = a - b;
				break;
			case MULTIPLY:
				a = a * b;
				break;
			case DIVISION:
				a = a / b;
				break;
			}
		}
		return a;
	}
}
