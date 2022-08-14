package swea_5432_PipeCut;

import java.util.Arrays;
import java.util.Scanner;

public class PipeCut {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			String input = sc.next();
			char[] arr = input.toCharArray();
			
			int[] temp = new int[arr.length];
			int cnt = 0;
			int max = 0;
			
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == '(' && i+1 < arr.length && arr[i+1] == ')') {
					i++;
				} else if (arr[i] == '(') {
					temp[i] = ++cnt;
					if (max < cnt) max = cnt;
				} else if (arr[i] == ')') {
					temp[i] = cnt--;
				}
			}
			
			int res = 0;

			for (int j = 1; j <= max; j++) {
				boolean pipe = false;
				for (int i = 0; i < temp.length; i++) {
					if (!pipe && temp[i] == j) {
						pipe = true;
						res++;
					} else if (pipe && temp[i] == 0 && temp[i + 1] == 0) {
						i++;
						res++;
					} else if (pipe && temp[i] == j) {
						pipe = false;
					}
				}
			}
			
			System.out.println("#" + t + " " + res);
		}
	}
}
