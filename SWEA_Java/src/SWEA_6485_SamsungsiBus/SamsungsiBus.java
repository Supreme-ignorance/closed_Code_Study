package SWEA_6485_SamsungsiBus;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class SamsungsiBus {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = sc.nextInt();
		
		for(int t = 1; t <=tc; t++) {
			int n = sc.nextInt();
			
			int[] a = new int[n+1];
			int[] b = new int[n+1];
			
			for(int i = 1; i <= n; i++) {
				a[i] = sc.nextInt();
				b[i] = sc.nextInt();
			}
			
			int p = sc.nextInt();
			
			int[][] c = new int[p+1][2];
			
			for(int i = 1; i <= p; i++) {
				c[i][0] = sc.nextInt();
			}
			
			for(int i = 1; i <= n; i++) {
				for(int j = a[i]; j <= b[i]; j++) {
					for (int k = 1; k <= p; k++) {
						if (c[k][0] == j) c[k][1]++;
					}
				}
			}
			
			bw.write("#" + t);
			
			for (int i = 1; i <= p; i++) {
				bw.write(" " + c[i][1]);
			}
			bw.write("\n");
			bw.flush();
		}
	}
}
