package swea_1213_findtext;

import java.util.Scanner;

public class FindText {
	static final int TC = 10;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t < TC;) {
			
			t = sc.nextInt();
			char[] find = (sc.next()).toCharArray();
			char[] string = (sc.next()).toCharArray();
			
			int i = 0;
			int j = 0;
			int result = 0;
			int f = find.length;
			
			while (i < string.length + 1 - f) {
				
				if (string[i+j] != find[j]) {
					i++; // 다음 문자열 부터 찾기
					j = -1; // j가 0이 되도록
				} 
				
				j++;
				
				if (j == f) {
					i += j; // 문자가 겹치는 부분은 찾을 필요 없다.
					result++; // 카운트
					j = 0;
				}
			} // 패턴 찾기
			System.out.println("#" + t + " "+ result); // 결과 출력
		} // 테스트 케이스
	}
}
