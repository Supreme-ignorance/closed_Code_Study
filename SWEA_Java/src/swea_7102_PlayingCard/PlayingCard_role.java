package swea_7102_PlayingCard;

import java.util.*;

public class PlayingCard_role {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int c = Math.max(n, m) + 1;
			
			System.out.print("#" + t);
			for (int j = Math.abs(n - m); j >= 0; j --) {
				System.out.print(" " + (c - j));
			}
			System.out.println();
		}
	}
}
