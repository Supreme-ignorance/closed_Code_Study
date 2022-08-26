package swea_7102_PlayingCard;

import java.util.*;

public class PlayingCard {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int[] count = new int[n + m + 1];
			int max = -1;
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					count[i+j]++;
					if (max < count[i+j]) max = count[i+j];
				}
			}
			
			System.out.print("#" + t);
			for (int i = 1; i <= n + m; i++) {
				if (count[i] == max) System.out.print(" " + i);
			}
			System.out.println();
		}
	}
}
