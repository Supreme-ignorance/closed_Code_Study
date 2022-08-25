package bj_No_17406_ArrayTurn4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Operation {
	int r;
	int c;
	int s;

	public Operation(int r, int c, int s) {
		this.r = r;
		this.c = c;
		this.s = s;
	}
}

public class Example {

	public static int[] dx = { 1, 0, -1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };

	public static int[][] arr;
	public static int[][] operated;
	public static Operation[] ops;
	public static int N, M, K;
	public static int min;
	public static boolean[] isPerformed;
	public static int[] sequence;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		K = Integer.parseInt(line[2]);

		isPerformed = new boolean[K];
		ops = new Operation[K];
		sequence = new int[K];
		arr = new int[N + 1][M + 1];
		operated = new int[N + 1][M + 1];

		for (int i = 1; i <= N; ++i) {
			line = br.readLine().split(" ");
			for (int j = 1; j <= M; ++j) {
				arr[i][j] = Integer.parseInt(line[j - 1]);
			}
		}

		for (int i = 0; i < K; ++i) {
			line = br.readLine().split(" ");
			ops[i] = new Operation(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]));
		}

		min = Integer.MAX_VALUE;
		dfs(0);

		System.out.println(min);

	}

	public static void dfs(int performed) {
		if (performed == K) {
			operateAndCalc();
			return;
		}

		for (int i = 0; i < K; ++i) {
			if (!isPerformed[i]) {
				sequence[performed] = i;
				isPerformed[i] = true;
				dfs(performed + 1);
				isPerformed[i] = false;
			}
		}

	}

	public static void operateAndCalc() {
		initializeOperated();
		for (int i = 0; i < K; ++i) {
			operate(ops[sequence[i]]);
		}
		calc();
	}

	public static void initializeOperated() {
		for (int i = 1; i <= N; ++i) {
			for (int j = 1; j <= M; ++j) {
				operated[i][j] = arr[i][j];
			}
		}
	}

	public static void operate(Operation op) {
		int r = op.r;
		int c = op.c;
		int s = op.s;
		for (int i = 0; i < s; ++i) {
			int curX = c - s + i;
			int curY = r - s + i;
			int dir = 0;
			int before = operated[curY][curX];
			int tmp = 0;
			while (dir < 4) {
				curX += dx[dir];
				curY += dy[dir];
				tmp = operated[curY][curX];
				operated[curY][curX] = before;
				before = tmp;

				int nextX = curX + dx[dir];
				int nextY = curY + dy[dir];
				if (nextX < c - s + i || nextX > c + s - i || nextY < r - s + i || nextY > r + s - i) {
					dir++;
				}
			}
		}
	}

	public static void calc() {
		for (int i = 1; i <= N; ++i) {
			int sum = 0;
			for (int j = 1; j <= M; ++j) {
				sum += operated[i][j];
			}
			min = min < sum ? min : sum;
		}
	}
}
