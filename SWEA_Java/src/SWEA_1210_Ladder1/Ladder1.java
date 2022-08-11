package SWEA_1210_Ladder1;

import java.util.Scanner;

public class Ladder1 {
	static final int TC = 10;
	static final int SIZE = 100;
	static boolean check;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t < TC;) {
			t = sc.nextInt();
			check = false;
			
			int[][] ladder = new int[SIZE][SIZE];
			
			for(int r = 0; r < SIZE; r++) {
				for(int c = 0; c < SIZE; c++) {
					ladder[r][c] = sc.nextInt();
				}
			}
			
			for(int c = 0; c < SIZE; c++) {
				if(ladder[0][c] == 0) continue;
				goLadder (t, c, ladder, 0, c, 0);
				if (check) break;
			}
		}
	}
	
	static Object goLadder (int t, int sc, int[][] ladder, int r, int c, int indc) {
		// 3방 탐색 왜? 올라가진 않으니까
		int[] dr = {0, 0, 1};
		// dc를 한 행렬로만 사용한다면 온 길로 다시 돌아가 버린다.
		int[][] dc = {{1, -1, 0}, {-1, 1, 0}};
		
		int i = 0;
		int j = 0;
		// 이전에 어떤 방향으로 이동했는지에 따라 dc결정
		if (indc == -1) {
			i = 1;
		} else if (indc == 1) {
			i = 1;
			j = 1;
		}
		
		for (; i < 3; i++) {
			int mr = r + dr[i];
			int mc = c + dc[j][i];
			// 경계 탐색
			if (mr == SIZE - 1) {
				isX(t, sc, ladder, mr, mc);
				return null;
			} else if (mc >= SIZE || mc < 0) continue;
			// 1일 경우
			if (ladder[mr][mc] == 1) {
				return goLadder (t, sc, ladder, mr, mc, dc[j][i]);
			}
		}
		return null;
	}
	
	static void isX (int t, int sc, int[][] ladder, int r, int c) {
		if (ladder[r][c] == 2) {
			System.out.println("#" + t + " " + sc);
			check = true;
		}
	}
}
