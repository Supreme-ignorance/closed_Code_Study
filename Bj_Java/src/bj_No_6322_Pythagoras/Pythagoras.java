package bj_No_6322_Pythagoras;

import java.util.Scanner;

public class Pythagoras {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a;
		int b;
		int c;
		int t = 0;
		
		do {
			StringBuilder sb = new StringBuilder();
			
			t++;
			
			sb.append("Triangle #" + t + "\n");
			
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			
			if (a == 0 && b == 0 && c == 0) break;
			
			double res = -1;
			
			if (a == -1 && c > b) {
				sb.append("a = ");
				res = Math.sqrt(Math.pow(c, 2) - Math.pow(b, 2));
			} else if (b == -1 && c > a) {
				sb.append("b = ");
				res = Math.sqrt(Math.pow(c, 2) - Math.pow(a, 2));
			} else if (c == -1) {
				sb.append("c = ");
				res = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
			} else {
				sb.append("Impossible.\n");
			}
			
			if (res != -1) {
				sb.append(String.format("%.3f\n", res));
			}
			
			System.out.println(sb);
			
		} while(true);
	}
}
