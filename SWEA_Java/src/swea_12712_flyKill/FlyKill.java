package swea_12712_flyKill;

import java.util.Scanner;

public class FlyKill {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int t = 0; t < tc; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			int[][] arr = new int[n][n];

			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					arr[r][c] = sc.nextInt();
				}
			}

			int[] mr = { 1, -1, 0, 0, 1, -1, 1, -1 };
			int[] mc = { 0, 0, 1, -1, 1, 1, -1, -1 };

			int max = 0;

			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
                    
					int cross_sum = arr[r][c];
					int x_sum = arr[r][c];

					inner: for (int d = 0; d < 8; d++) {
						for (int s = 1; s < m; s++) {
							int check_r = r + s * mr[d];
							int check_c = c + s * mc[d];
							// 경게처리
							if (check_r >= n || check_r < 0 || check_c < 0 || check_c >= n) {
								continue inner;
							}
							// 확인
							if (d < 4) {
								cross_sum += arr[check_r][check_c];
							} else {
								x_sum += arr[check_r][check_c];
							}
						}
					}

					if (max < cross_sum)
						max = cross_sum;
					if (max < x_sum)
						max = x_sum;
				}
			}

			System.out.println("#" + (t+1) + " " + max);
		}
	}
}
