package bj_No_11725_Mother;

import java.util.Scanner;

public class Mother_bad {
	
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		arr = new int[100001];
		
		arr[0] = -2;
		arr[1] = -1;
		
		for (int i = 0; i < n -1; i++) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			
			if (first == 1 && arr[second] == 0) {
				arr[second] = first;
			} else if (second == 1 && arr[first] == 0) {
				arr[first] = second;
			} else if (arr[first] == 0) {
				arr[first] = second;
			} else if (arr[second] == 0) {
				arr[second] = first;
			} else {
				isAncestorisRoot(first, first, second);
			}
		}
		
		for (int i = 2; i < n + 1; i++) {
			System.out.println(arr[i]);
		}
	}
	
	static void isAncestorisRoot (int s, int o, int other) {
		if (arr[o] == -1) {
			int temp = arr[other];
			arr[temp] = other;
			arr[other] = s;
			return;
		} else if (arr[o] == -2) {
			int temp = arr[s];
			arr[temp] = s;
			arr[s] = other;
			return;
		}
		
		isAncestorisRoot (s, arr[o], other);
	}
}