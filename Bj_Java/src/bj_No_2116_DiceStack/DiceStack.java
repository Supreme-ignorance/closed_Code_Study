package bj_No_2116_DiceStack;

import java.util.*;

public class DiceStack {
	
	static int[][] dice;
	static int[] top;
	static int n;
	static int[][] except = { {0, 5}, {1, 3}, {2, 4}, {3, 1}, {4, 2}, {5, 0} };
	static int ans = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		dice = new int[n][6];
		
		for(int i = 0; i < n; i++) {
			for (int j = 0; j < 6; j++) {
				dice[i][j] = sc.nextInt();
			}
		}
		
		dicestack(-1, 0, 0);
		
		System.out.println(ans);
		
		sc.close();
	}
	/**
	 * @param prevtopidx : 아무 값이나 상관 없음
	 * @param size : 시작할 때는 0
	 * @param sum : 시작할 때는 0
	 */
	static void dicestack (int prevtopidx, int size, int sum) {
		if (size == n) {
			ans = Math.max(sum, ans);
			return;
		} else if (size == 0) {
			for (int i = 0; i < 6; i++) {
				sum += maxdice(i, 0);
				dicestack(i, 1, sum);
				sum -= maxdice(i, 0);
			}
		} else {
			int prevtopvalue = dice[size-1][prevtopidx];
			int nowtopidx = -1;
			// 현재의 위쪽 주사위의 인덱스 찾기
			for (int i = 0; i < 6; i++) {
				if (dice[size][i] == prevtopvalue) nowtopidx = except[i][1];
			}
			// 최대값 찾아서  sum에 더하기
			sum += maxdice (nowtopidx, size);
			// 다음 주사위 찾기
			dicestack (nowtopidx, size + 1, sum);
		}
	}
	
	static int maxdice (int topidx, int size) {
		int max = 0;
		
		for (int i = 0; i < 6; i++) {
			// 천장과 바닥이 아닌면 중에서 찾기
			if (i == except[topidx][0] || i == except[topidx][1]) continue;
			if (max < dice[size][i]) max = dice[size][i];
		}
		
		return max;
	}
}
