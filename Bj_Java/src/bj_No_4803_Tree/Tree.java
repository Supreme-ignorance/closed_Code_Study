package bj_No_4803_Tree;

import java.util.*;

public class Tree {
	static List<Integer>[] connect;
	static boolean[] visited;
	static boolean isloop;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = 0;
		
		while (true) {
			c++;
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			if (n == 0 && m == 0) break;
			
			connect = new List[n + 1];
			visited = new boolean[n + 1];
			visited[0] = true;
			
			for (int i = 1; i < n + 1; i++) {
				connect[i] = new ArrayList<Integer>();
			}
			
			for (int i = 0; i < m; i++) {
				int first = sc.nextInt();
				int second = sc.nextInt();
				
				connect[first].add(second);
				connect[second].add(first);
			}
			
			int cnt = 0;
			
			for (int i = 1; i < n + 1; i++) {
				isloop = false;
				if (!visited[i]) {
					cnt += dfs(i, i, 0);
				}
			}
			
			if (cnt == 0) System.out.println("Case " + c + ": No trees.");
			else if (cnt == 1) System.out.println("Case " + c + ": There is one tree.");
			else System.out.println("Case " + c + ": A forest of " + cnt + " trees.");
		}
	}
	
	static int dfs(int input, int start, int before) {
		visited[input] = true;

		for (int i : connect[input]) {
			if (!visited[i]) {
				dfs(i, start, input);
			} else {
				// 직전에 간 곳이 아닌데 이전에 갔던곳으로 연결이 되어 있다면
				if (i != before && visited[i]) {
					isloop = true;
				}
			}
		}

		if (!isloop) return 1;
		else return 0;
	}
}
