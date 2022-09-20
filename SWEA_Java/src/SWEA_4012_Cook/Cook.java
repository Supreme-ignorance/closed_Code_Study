package SWEA_4012_Cook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Cook {
	static int[][] arr;
	static int n;
	static boolean[] cell;
	static int[] adish;
	static int[] bdish;
	static int[] collect = new int[2];
	
	static int a;
	static int b;
	static int res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			res = Integer.MAX_VALUE;

			n = Integer.parseInt(br.readLine());

			arr = new int[n + 1][n + 1];
			cell = new boolean[n + 1];
			adish = new int[n / 2];
			bdish = new int[n / 2];

			for (int r = 1; r < n + 1; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 1; c < n + 1; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			combi(1, 0, n);
			
			res = Math.abs(a - b);

			System.out.println("#" + t + " " + res);
		}
	}
	
	static void aperm (int[] dish, int depth) {
		if (depth == 2) {
			a += arr[collect[0]][collect[1]];
			return;
		} else {
			for (int i = 1; i < dish.length; i++) {
				if (!cell[i]) {
					cell[i] = true;
					collect[depth] = dish[i];
					aperm(dish, depth);
					cell[i] = false;
				}
			}
		}
	}
	
	static void bperm (int[] dish, int depth) {
		if (depth == 2) {
			b += arr[collect[0]][collect[1]];
			return;
		} else {
			for (int i = 1; i < dish.length; i++) {
				if (!cell[i]) {
					cell[i] = true;
					collect[depth] = dish[i];
					bperm(dish, depth);
					cell[i] = false;
				}
			}
		}
	}

	static void combi (int s, int depth, int end) {
		if (depth >= end / 2) {
			int idx = 0;
			if (depth == end) {
				aperm(adish, 0);
				bperm(bdish, 0);
				return;
			}
			for (int i = s; i < n + 1; i++) {
				if (!cell[i]) {
					cell[i] = true;
					bdish[idx++] = i;
					combi(s + 1, depth + 1, end);
					cell[i] = false;
				}
			}
		} else {
			for (int i = s; i < n + 1; i++) {
				if (!cell[i]) {
					cell[i] = true;
					adish[depth] = i;
					combi(s + 1, depth + 1, end);
					cell[i] = false;
				}
			}
		}
	}
}
