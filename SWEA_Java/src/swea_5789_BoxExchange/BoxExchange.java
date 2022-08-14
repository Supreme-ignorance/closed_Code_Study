package swea_5789_BoxExchange;

import java.util.Scanner;

public class BoxExchange {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			int[] box = new int[n];
			int q = sc.nextInt();
			
			for (int i = 1; i <= q; i++) {
				int l = sc.nextInt();
				int r = sc.nextInt();
				for (int j = l-1; j < r; j++) {
					box[j] = i;
				}
			}

			System.out.print("#" + t);
			for (int i = 0; i < n; i++) {
				System.out.print(" " + box[i]);
			}
			System.out.println();
		}
	}
}
