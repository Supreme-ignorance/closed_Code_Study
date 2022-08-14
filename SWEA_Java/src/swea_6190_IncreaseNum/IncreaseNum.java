package swea_6190_IncreaseNum;

import java.util.Scanner;

public class IncreaseNum {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			int max = -1;
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					int num = arr[i] * arr[j];
					if (num < max) continue;
					char[] temp = (num + "").toCharArray();
					boolean ismono = true;
					for (int k = 0; k < temp.length-1; k++) {
						if (temp[k] > temp[k+1]) {
							ismono = false;
							break;
						}
					}
					if (ismono) max = num;
				}
			}
			if (max != -1) System.out.println("#" + t + " " + max);
			else System.out.println("#" + t + " " + -1);
		}
	}
}
