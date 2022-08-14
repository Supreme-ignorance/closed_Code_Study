package swea_4789_GreatShow;

import java.util.Scanner;

public class GreatShow {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			
			String input = sc.next();
			int[] arr = new int[input.length()];
			
			for (int i = 0; i < input.length(); i++) {
				arr[i] = input.charAt(i) - '0';
			}
			
			int clap = 0;
			int need = 0;
			
			for (int i = 0; i < input.length(); i++) {
				if (i <= clap) clap += arr[i];
				else {
					need += (i - clap);
					clap += (i - clap) + arr[i];
				}
			}
			
			System.out.println("#" + t + " " + need);
		}
	}
}
