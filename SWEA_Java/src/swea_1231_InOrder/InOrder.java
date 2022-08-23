package swea_1231_InOrder;

import java.util.Scanner;

public class InOrder {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			char[] bt = new char[sc.nextInt() + 1];

			for (int i = 1; i < bt.length; i++) {
				bt[sc.nextInt()] = sc.next().charAt(0);
				if (2 * i + 1 < bt.length) {
					sc.nextInt();
					sc.nextInt();
				} else if (2 * i < bt.length) {
					sc.nextInt();
				}
			}

			System.out.print("#" + t + " ");
			printbt(bt, 1);
			System.out.println();
		}
	}

	static void printbt(char[] bt, int idx) {
		if (idx >= bt.length) return;
		printbt(bt, 2 * idx);
		System.out.print(bt[idx]);
		printbt(bt, 2 * idx + 1);
	}
}
