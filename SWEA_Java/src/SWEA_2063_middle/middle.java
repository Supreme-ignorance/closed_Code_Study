package SWEA_2063_middle;

import java.util.Arrays;
import java.util.Scanner;

public class middle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] list = new int[n];
		
		for (int i = 0; i < n; i++) {
			list[i] = sc.nextInt();
		}
		
		Arrays.sort(list);
		
		int m = list.length / 2;
		
		System.out.println(list[m]);
	}
}
