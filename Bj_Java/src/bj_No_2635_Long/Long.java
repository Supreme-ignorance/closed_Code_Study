package bj_No_2635_Long;

import java.util.Scanner;

public class Long {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int maxnum = 0;
		int maxres = 0;

		for (int i = 1; i <= n; i++) {
			int prenum = n;
			int num = i;
			int cnt = 2;
			while (num >= 0) {
				int temp = num;
				num = prenum - num;
				prenum = temp;
				if (num >= 0) cnt++;
			}
			if (cnt > maxres) {
				maxres = cnt;
				maxnum = i;
			}
		}
		
		System.out.println(maxres);
		System.out.print(n + " ");
		
		int num = maxnum;
		int prenum = n;

		while (num >= 0) {
			if (num >= 0) System.out.print(num + " ");
			int temp = num;
			num = prenum - num;
			prenum = temp;
		}
	}
}
