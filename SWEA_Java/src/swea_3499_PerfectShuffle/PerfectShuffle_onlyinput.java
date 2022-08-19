package swea_3499_PerfectShuffle;

import java.util.Scanner;

public class PerfectShuffle_onlyinput {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt(); // nÀº °ª °¹¼ö

			String[] shuffled = new String[n];

			for (int i = 0, u = 0, l = 1; i < n; i++) {
				if (i < n - (int) n / 2) {
					shuffled[u] = sc.next();
					u += 2;
				} else {
					shuffled[l] = sc.next();
					l += 2;
				}
			} // ¼¯±â

			System.out.print("#" + t);
			for (int i = 0; i < n; i++) {
				System.out.print(" " + shuffled[i]);
			}
			System.out.println();
		}
		sc.close();
	}
}
