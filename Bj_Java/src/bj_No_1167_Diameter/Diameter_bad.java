package bj_No_1167_Diameter;

import java.util.*;

public class Diameter_bad {
	static List<int[]>[] connect;
	static boolean[] visited;
	static int[] distanse;
	static int root;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		connect = new List[n + 1];
		visited = new boolean[n + 1];
		distanse = new int[n + 1];
		visited[0] = true;
		root = n % 2 == 0? n / 2 : n / 2 + 1;
		
		for (int i = 1; i < n + 1; i++) {
			connect[i] = new ArrayList<int[]>();
		}
		
		
		int max = 2;
		for (int i = 0; i < n; i++) {
			int node = sc.nextInt();
			
			while (true) {
				int conneted = sc.nextInt();
				if (conneted == -1) break;
				int dist = sc.nextInt();
				
				int[] in = {conneted, dist};
				
				connect[node].add(in);
			}
			if (max < connect[node].size()) {
				max = connect[node].size();
				root = node;
			}
		}
		System.out.println(root);
		dfs(root, 0);
		
		max = 0;
		for (int i = 1; i < n + 1; i++) {
			for (int j = i + 1; j < n + 1; j++) {
				int temp = distanse[i] + distanse[j];
				if (max < temp) max = temp;
			}
		}
		System.out.println(Arrays.toString(distanse));
		System.out.println(max);
	}
	
	static void dfs(int input, int dist) {
		visited[input] = true;
		
		for (int[] i : connect[input]) {
			if (!visited[i[0]]) {
				distanse[i[0]] = dist + i[1];
				dfs(i[0], dist + i[1]);
			}
		}
	}
}
