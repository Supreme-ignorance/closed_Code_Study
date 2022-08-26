package bj_No_2869_SnailCan;

import java.util.Scanner;

public class SnailCan {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int v = sc.nextInt();
		
		int m = a - b;
		
		int cnt = (v - a) / m + 1;
		if ((v - a) % m != 0) cnt++;
		
		System.out.println(cnt);
	}
}
