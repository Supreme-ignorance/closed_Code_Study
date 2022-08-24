package bj_No_2559_Sequence;

import java.util.Scanner;

public class Sequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		int k = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] res = new int[n-k+1];
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < n-k+1; i++) {
			for (int j = i; j < i+k; j++) {
				res[i] += arr[j];
			}
			if (max < res[i]) max = res[i];
		}
		
		System.out.println(max);
	}
}
