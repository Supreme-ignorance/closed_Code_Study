package swea_5432_PipeCut;

import java.util.Scanner;

public class PipeCut2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			String input = sc.next();
			char[] arr = input.toCharArray();
			
			int[] temp = new int[arr.length];
			int cnt = 0; // 레이저를 쏠때 잘리는 파이프의 수
			int res = 0;
			
			for (int i = 0; i < arr.length; i++) {
				if (cnt > 0 && arr[i] == '(' && arr[i+1] == ')') {
					res += cnt;
					i++;
				} else if (cnt == 0 && arr[i] == '(' && arr[i+1] == ')') {
					i++;
				} else if (arr[i] == '(') {
					cnt++;
					res++;
				} else if (cnt > 0 && arr[i] == ')') {
					cnt--;
				}
			}
			
			System.out.println("#" + t + " " + res);
		}
	}
}
