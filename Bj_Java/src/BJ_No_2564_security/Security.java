package BJ_No_2564_security;

import java.util.Scanner;

public class Security {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] block = new int[2];
		block[0] = sc.nextInt(); //가로
		block[1] = sc.nextInt(); //세로
		
		int n = sc.nextInt();
		int[][] sl = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			sl[i][0] = sc.nextInt(); // 동서남북
			sl[i][1] = sc.nextInt(); // 거리
		}
		
		int[] security = new int[2];
		security[0] = sc.nextInt(); // 동서남북
		security[1] = sc.nextInt(); // 거리
		
		int sum = 0;
		
		for (int i = 0; i < n; i++) {
			sum += distance(block, i, sl, security);
		}
		
		System.out.println(sum);
	}
	
	static int distance(int[] block, int i, int[][] store, int[] security) {
		
		int cw = 0;
		int ccw = 0;
		int tempcw = security[0];
		int tempccw = security[0];
		int temp = security[1];
		
		CW : while (true) {
			if (store[i][0] == tempcw) {
				cw += Math.abs(store[i][1] - security[1]);
				security[1] = temp;
				break CW;
			} else if (tempcw == 4){
				cw += block[1] - security[1];
				tempcw = 2;
				security[1] = block[0];
			} else if (tempcw == 2){
				cw += security[1];
				tempcw = 3;
				security[1] = block[1];
			} else if (tempcw == 3){
				cw += security[1];
				tempcw = 1;
				security[1] = 0;
			} else if (tempcw == 1){
				cw += block[0] - security[1];
				tempcw = 4;
				security[1] = 0;
			}
		}
		
		CCW : while (true) {
			if (store[i][0] == tempccw) {
				ccw += Math.abs(store[i][1] - security[1]);
				security[1] = temp;
				break CCW;
			} else if (tempccw == 4){
				ccw += security[1];
				tempccw = 1;
				security[1] = block[0];
			} else if (tempccw == 2){
				ccw += block[0] - security[1];
				tempccw = 4;
				security[1] = block[1];
			} else if (tempccw == 3){
				ccw += block[1] - security[1];
				tempccw = 2;
				security[1] = 0;
			} else if (tempccw == 1){
				ccw += security[1];
				tempccw = 3;
				security[1] = 0;
			}
		}
		
		return Math.min(cw, ccw);
	}
}
