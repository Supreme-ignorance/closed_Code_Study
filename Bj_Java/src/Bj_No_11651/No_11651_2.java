package Bj_No_11651;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class No_11651_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] list = new int[n][2];
		
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < 2; c++) {
				list[r][c] = sc.nextInt();
			}
		}
		
		sc.close();
		
		Arrays.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				} else return o1[1] - o2[1];
			}
		});
		
		for(int r = 0; r < n; r++) {
				System.out.println(list[r][0] + " " + list[r][1]);
		}
	}
}
