package bj_No_17298_NGE;

import java.util.*;

public class NGE {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		arr = new int[n];
		
		for (int i = 0; i < n ; i++) {
			arr[i] = sc.nextInt();
		}
		
		next : for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arr[i] < arr[j]) {
					arr[i] = arr[j];
					continue next;
				}
			}
			arr[i] = -1;
		}
		
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
