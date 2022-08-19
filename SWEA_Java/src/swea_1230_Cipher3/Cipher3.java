package swea_1230_Cipher3;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Cipher3 {
	static final int tc = 10;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= tc; t++) {
			List<Integer> Cipher = new LinkedList<Integer>();
			
			int n = sc.nextInt(); // 입력 받을 암호의 길이
			
			for (int i = 0; i < n; i++) {
				Cipher.add(sc.nextInt());
			}
			
			n = sc.nextInt(); // 입력 받을 명령어의 개수
			
			for (int i = 0; i < n; i++) {
				char c = sc.next().charAt(0);
				
				if (c == 'I') {
					int x = sc.nextInt(); // x인덱스에
					int y = sc.nextInt(); // y개만큼
					
					for(int j = 0; j < y; j++) {
						Cipher.add(x+j, sc.nextInt());
					} // 추가한다.
				} // 삽입 명령이라면
				
				if (c == 'D') {
					int x = sc.nextInt(); // x인덱스부터
					int y = sc.nextInt(); // y개만큼
					
					for(int j = 0; j < y; j++) {
						Cipher.remove(x+j);
					} // 지운다.
				}
				
				if (c == 'A') {
					int y = sc.nextInt(); // y개만큼
					
					for(int j = 0; j < y; j++) {
						Cipher.add(sc.nextInt());
					} // 붙인다.
				}
				
			}
			
			System.out.print("#" + t);
			for (int i = 0; i < 10; i++) {
				System.out.print(" " + Cipher.get(i));
			}System.out.println();
		}
		sc.close();
	}
}
