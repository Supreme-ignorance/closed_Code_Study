package SWEA.UN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class No_1249_SupplyLine {
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static PriorityQueue<Place> pq;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.valueOf(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			n = Integer.valueOf(br.readLine());
			
			
			map = new int[n][n];
			visited = new boolean[n][n];
			pq = new PriorityQueue<>();
			
			for (int r = 0; r < n; r++) {
				char[] temp = br.readLine().toCharArray();
				
				for (int c = 0; c < n; c++) {
					map[r][c] = temp[c] - '0';
				}
			}
			
			pq.add(new Place (0, 0, map[0][0]));
			
			while (!pq.isEmpty()) {
				Place current = pq.poll();
				
				int r = current.r;
				int c = current.c;
				int manHour = current.manHour;
				
				visited[r][c] = true;
				
				if (r == n - 1 && c == n - 1) {
					System.out.println("#" + t + " " + manHour);
					break;
				}
				
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					
					if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc]) 
						continue;
					
					pq.add(new Place (nr, nc, manHour + map[nr][nc]));
				}
			}
		}
	}
}

class Place implements Comparable<Place> {
	int r;
	int c;
	int manHour;
	
	public Place(int r, int c, int manHour) {
		this.r = r;
		this.c = c;
		this.manHour = manHour;
	}

	@Override
	public int compareTo(Place o) {
		return this.manHour - o.manHour;
	}
}
