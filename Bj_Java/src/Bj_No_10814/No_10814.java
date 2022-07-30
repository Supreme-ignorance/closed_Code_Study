package Bj_No_10814;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class No_10814 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		String[][] list = new String[n][3];

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < 2; c++) {
				list[r][c] = sc.next();
				if (c == 0)
					list[r][2] = r + "";
			}
		}

		sc.close();

		Arrays.sort(list, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				if (o1[0].equals(o2[0])) {
					return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
				} else
					return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
			}
		});

		for (int r = 0; r < n; r++) {
			System.out.println(list[r][0] + " " + list[r][1]);
		}
	}
}
