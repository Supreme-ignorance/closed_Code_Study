package BJ_No_2567_confetti2;

import java.util.Scanner;

public class Confetti2 {
	static final int SIZE = 100;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] paper = new int[SIZE][SIZE];

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			confetti(paper, x, y);
		}

		checkLine(paper);

		int sum = 0;
		for (int x = 0; x < SIZE; x++) {
			for (int y = 0; y < SIZE; y++) {
				if (paper[x][y] != -1)
					sum += paper[x][y];
			}
		}

		System.out.println(sum);
	}

	static void confetti(int[][] paper, int sx, int sy) {
		for (int x = sx; x < sx + 10; x++) {
			for (int y = sy; y < sy + 10; y++) {
				paper[x][y] = 1;
			}
		}
	}

	static void checkLine (int[][] paper) {
		int[] dx = {0, 0, -1, 1};
		int[] dy = {1, -1, 0, 0};

		for (int x = 0; x < SIZE; x++) {
			for (int y = 0; y < SIZE; y++) {
				//4방 탐색
				if(paper[x][y] == 0) continue;
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int mx = x + dx[d];
					int my = y + dy[d];
					// 경계 설정
					if(mx < 0 || mx > SIZE - 1 || my < 0 || my > SIZE - 1) {
						cnt++; // 경계도 선이야 선!
						continue;
					}
					if (paper[mx][my] == 0) cnt++;
				}
				if (cnt == 0) cnt = -1;
				paper[x][y] = cnt;
			}
		}
	}
}
