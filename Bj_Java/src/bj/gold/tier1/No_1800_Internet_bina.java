package bj.gold.tier1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No_1800_Internet_bina {
	static int n;
	static int p;
	static int k;
	static int[][] map;
	static int[] visited;
	static PriorityQueue<Node> pq = new PriorityQueue<Node>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.valueOf(st.nextToken());
		p = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
		
		map = new int[n + 1][n + 1];
		visited = new int[n + 1];
		Arrays.fill(visited, 1000001);
		
		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			int price = Integer.valueOf(st.nextToken());
			map[r][c] = map[c][r] = price;
		}
		
		pq.add(new Node());
		visited[1] = 0;
		int res = -1;
		
		while (!pq.isEmpty()) {
			
			Node node = pq.poll();
			int now = node.now;
			
			
			if (now == n && (res == -1 || res > node.price)) {
				res = node.price;
			}
			
			for (int i = 1; i < n + 1; i++) {
				if (now != i && map[now][i] != 0) {
					Node next = new Node(node, i, map[now][i]);
					
					if (visited[i] < next.price) 
						continue;
					else
						visited[i] = next.price;
					
					System.out.println(now + "에서" + next.now + " " + Arrays.toString(next.in) + " " + next.price + " 이전 " + node.price + " " + Arrays.toString(node.in));
					pq.add(next);
				}
			}
		}
		
		System.out.println(res);
	}
	
	static class Node implements Comparable<Node>{
		int now;
		int stack;
		int price;
		int[] in;
		
		public Node() {
			this.now = 1;
			this.stack = 0;
			this.price = 0;
			this.in = new int[k];
		}
		
		public Node(Node eve, int next, int nextPrice) {
			this.now = next;
			this.stack = eve.stack;
			
			if (eve.stack < k) {
				this.in = Arrays.copyOf(eve.in, k);
				this.in[eve.stack] = nextPrice;
				this.stack++;
				if (this.stack == k)
					Arrays.sort(eve.in);
			} else {
				this.in = Arrays.copyOf(eve.in, k);
				
				if (this.in[0] < nextPrice) {
					this.price = this.in[0];
					this.in[0] = nextPrice;
					Arrays.sort(this.in);
				} else if (this.price <= nextPrice){
					this.price = nextPrice;
				}
			}
		}

		@Override
		public int compareTo(Node o) {
			if (this.price == o.price) {
				return this.in[0] - o.in[0];
			}
			return this.price - o.price;
		}
	}
}

