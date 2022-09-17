package swea_1215_우영우1;

import java.util.Scanner;

public class 우영우1 {
	static final int TC = 10;
	static final int SIZE = 8;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= TC; t++) {
			int n = sc.nextInt();
			
			char[][] arr = new char[SIZE][SIZE];
			
			for (int r = 0; r < SIZE; r++) {
				String input = sc.next();
				for (int c = 0; c < SIZE; c++) {
					arr[r][c] = input.charAt(c);
				}
			}
			int res = 0;
			for (int r = 0; r < SIZE; r++) {
				for (int c = 0; c < SIZE; c++) {
					// ȸ�� �˻�
					int cntr = 0;
					int cntc = 0;
					for (int j = 0; j < n / 2; j++) {
						if (c + j < 0 || c + j >= SIZE || c + n - 1 - j < 0 || c + n - 1 - j >= SIZE) continue;
						if (arr[r][c + j] == arr[r][c + n - 1 - j]) {
							cntr++;
						}
						if (arr[c + j][r] == arr[c + n - 1 - j][r]) {
							cntc++;
						}
						if (cntr == n / 2) {
							res++;
						}
						if (cntc == n / 2) {
							res++;
						}
					}
				}
			}
			
			System.out.println("#" + t + " " + res);
		}
		sc.close();
	}
}
