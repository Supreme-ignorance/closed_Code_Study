package SWEA_1984_middleAvg;

import java.util.Arrays;
import java.util.Scanner;

public class middleAvg {
	static final int N = 10;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			int[] list = new int[N];
			
			for (int i = 0; i < list.length; i++) {
				list[i] = sc.nextInt();
			}
			
			Arrays.sort(list);
			int sum = 0;
			
			for (int i = 1; i < list.length-1; i++) {
				if (list[i] != list[0] && list[i] != list[list.length-1]) sum += list[i];
			}
			
			int avg = sum / (list.length-2);
			float i = (float) sum / (list.length-2) - avg;
			
			if (i >= 0.5) avg++;
			
			System.out.println("#" + t + " " + avg);
		}
	}
}
