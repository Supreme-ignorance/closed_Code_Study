package swea_3499_PerfectShuffle;

import java.util.Scanner;

public class PerfectShuffle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();

			String[] U = new String[n - (int) n / 2];
			String[] L = new String[n / 2];

			for (int i = 0, u = 0, l = 0; i < n; i++) {
				if (i < n - (int) n / 2)
					U[u++] = sc.next();
				else
					L[l++] = sc.next();
			}
			
			System.out.print("#" + t);
			
			for (int i = 0, u = 0, l = 0; i < n; i++) {
				if (i % 2 == 0)
					System.out.print(" " + U[u++]);
				else
					System.out.print(" " + L[l++]);
			} System.out.println();
			
		}
		sc.close();
	}
}