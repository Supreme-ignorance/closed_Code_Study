package bj_No_2578_BingGo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BingGo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Integer, Object> map = new HashMap<>();
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int[] arr = { i, j };
				map.put(sc.nextInt(), arr);
			}
		}
 		
		int cnt = 0;
		int[] row = new int[5];
		int[] col = new int[5];
		int s = 0;
		int bs = 0;
		
		for (int i = 1; i <= 25; i++) {
			int num = sc.nextInt();
			
			int r = ((int[]) map.get(num))[0];
			int c = ((int[]) map.get(num))[1];
			
			if (++row[r] == 5) cnt++;
			if (++col[c] == 5) cnt++;
			if (r == c && ++s == 5) cnt++;
			if (r + c == 4 && ++bs == 5) cnt++;
			
			if (cnt >= 3) {
				System.out.println(i);
				break;
			}
		}
	}
}
