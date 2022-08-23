package swea_1873_BattleField;

import java.util.Scanner;

public class BattleField {
	
	static int myr = -1;
	static int myc = -1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			
			int h = sc.nextInt(); // 세로
			int w = sc.nextInt(); // 가로
			
			char[][] field = new char[h][w];
			
			for (int r = 0; r < h; r++) {
				String temp = sc.next();
				for (int c = 0; c < w; c++) {
					field[r][c] = temp.charAt(c);
					if (field[r][c] == '>' || field[r][c] == '<' || field[r][c] == '^' || field[r][c] == 'v') {
						myr = r;
						myc = c;
					}
				}
			} // field 입력 및 전차 위치 확인
			
			int comandlength = sc.nextInt(); // 명령 길이 확인
			
			String comands = sc.next(); // 명령 입력
			
			for (int i = 0; i < comandlength; i ++) {
				control(field, comands.charAt(i), field[myr][myc]);
			} // 실행
			
			System.out.print("#" + t + " ");
			for (int r = 0; r < h; r++) {
				for (int c = 0; c < w; c++) {
					System.out.print(field[r][c]);
				} System.out.println();
			}
		} // 테스트 케이스
		sc.close();
	}
	
	static void control(char[][] field, char comand, char mydir) {
		switch (comand) {
		// 위로 방향 전환 이동 가능시 이동
		case 'U' : 
			field[myr][myc] = '^';
			if (myr - 1 >= 0 && ismoveable(field[myr - 1][myc])) {
				field[myr - 1][myc] = field[myr][myc];
				field[myr][myc] = '.';
				myr--;
			}
			break;
		// 아래로 방향 전환 이동 가능시 이동
		case 'D' : 
			field[myr][myc] = 'v';
			if (myr + 1 < field.length && ismoveable(field[myr + 1][myc])) {
				field[myr + 1][myc] = field[myr][myc];
				field[myr][myc] = '.';
				myr++;
			}
			break;
		// 왼쪽으로 방향 전환 이동 가능시 이동
		case 'L' :
			field[myr][myc] = '<';
			if (myc - 1 >= 0 && ismoveable(field[myr][myc - 1])) {
				field[myr][myc - 1] = field[myr][myc];
				field[myr][myc] = '.';
				myc--;
			}
			break;
		// 오른쪽으로 방향 전환 이동 가능시 이동
		case 'R' :
			field[myr][myc] = '>';
			if (myc + 1 < field[0].length && ismoveable(field[myr][myc + 1])) {
				field[myr][myc + 1] = field[myr][myc];
				field[myr][myc] = '.';
				myc++;
			}
			break;
		//발사
		case 'S' : 
			int[] dr = { 1, -1, 0, 0 };
			int[] dc = { 0, 0, 1, -1 };
			
			int i = -1;
			
			if (field[myr][myc] == 'v') i = 0;
			else if (field[myr][myc] == '^') i = 1;
			else if (field[myr][myc] == '>') i = 2;
			else if (field[myr][myc] == '<') i = 3;
			
			int tempr = myr + dr[i];
			int tempc = myc + dc[i];
			// 배열 범위를 벗어나기 전까지
			while (tempr >= 0 && tempr < field.length && tempc >= 0 && tempc < field[0].length) {
				if (isbreakable(field[tempr][tempc])) {
					field[tempr][tempc] = '.';
					break;
				} else if (isunbreakable(field[tempr][tempc])) break;
				tempr += dr[i];
				tempc += dc[i];
			}
		}
	}
	
	static boolean ismoveable(char input) {
		if (input == '.') return true;
		else return false;
	}
	
	static boolean isbreakable(char input) {
		if (input == '*') return true;
		else return false;
	}
	
	static boolean isunbreakable(char input) {
		if (input == '#') return true;
		else return false;
	}
}
