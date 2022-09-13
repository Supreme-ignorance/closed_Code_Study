package swea_2930_Heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Heap_other {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			PriorityQueue<Integer> pQHighest = new PriorityQueue<>(Collections.reverseOrder());

			System.out.print("#" + t);
			for (int i = 0; i < n; i++) {
				int c = sc.nextInt();
				switch (c) {
				case 1: 
					pQHighest.add(sc.nextInt());
					break;
				case 2:
					if (pQHighest.isEmpty()) System.out.print(" " + -1);
					else System.out.print(" " + pQHighest.poll());
					break;
				}
			} System.out.println();
		}
	}
}