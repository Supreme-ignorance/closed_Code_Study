package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1486_Shelf {
	static int n;
	static int goalH;
	static int[] clerks;
	static int visited;
	static int res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.valueOf(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			//초기화
			visited = 0;
			res = Integer.MAX_VALUE;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.valueOf(st.nextToken());
			goalH = Integer.valueOf(st.nextToken());
			
			clerks = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				clerks[i] = Integer.valueOf(st.nextToken());
			}
			
			powerSet(0, 0);
			
			sb.append("#" + t + " " + res + "\n");
		}
		System.out.println(sb);
	}
	
	static void powerSet(int start, int depth) {
		if (depth == n) {
			int temp = -goalH;
			
			for (int i = 0; i < n; i++) {
				if ((visited & (1 << i)) != 0) temp += clerks[i];
			}
			
			if (temp >= 0 && temp < res) res = temp;
			return;
		}
		
		if ((visited & (1 << start)) == 0) {
			visited += (1 << start);
			powerSet(start + 1, depth + 1);
			visited -= (1 << start);
			powerSet(start + 1, depth + 1);
		}
	}
}
