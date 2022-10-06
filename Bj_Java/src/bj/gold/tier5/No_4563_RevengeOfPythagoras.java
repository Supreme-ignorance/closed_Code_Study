package bj.gold.tier5;

import java.util.Scanner;

public class No_4563_RevengeOfPythagoras {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			long a = sc.nextInt();
			
			if (a == 0) break;
			int cnt = 0;
			long aa = (long) Math.pow(a, 2);
			
			for (long i = 1; i <= a; i++) {
				if (aa % i == 0) {
					long stemp = i;
					long btemp = aa / stemp;
					
					if ((btemp - stemp) % 2 == 0 && (btemp + stemp) % 2 == 0 && (btemp - stemp) / 2 > a) {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
