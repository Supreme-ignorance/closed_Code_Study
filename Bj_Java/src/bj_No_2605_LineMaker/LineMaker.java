package bj_No_2605_LineMaker;

import java.util.Scanner;

public class LineMaker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] input = new int[n+1];
		int[] res = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			input[i] = sc.nextInt();
		}
		
		for(int i = 1; i <= n; i++) {
			int temp = input[i];
			input[i] = i-temp;
			if (temp != 0) {
				for (int j = i-1; j >= i-temp; j--) {
					for (int k = 1; k < i; k++) {
						if (j == input[k]) input[k]++;
					}
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			res[input[i]] = i;
		}
		
		for(int i = 1; i <= n; i++) {
			System.out.print(res[i] + " ");;
		}
	}
}