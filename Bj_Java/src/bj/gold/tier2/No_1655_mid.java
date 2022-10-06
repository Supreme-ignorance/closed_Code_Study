package bj.gold.tier2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class No_1655_mid {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.valueOf(br.readLine());
		
		PriorityQueue<Integer> LQ = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});
		
		PriorityQueue<Integer> RQ = new PriorityQueue<>();
		
		RQ.add(Integer.valueOf(br.readLine()));
		sb.append(RQ.peek() + "\n");
		
		for (int i = 1; i < n; i++) {
			int input = Integer.valueOf(br.readLine());
			
			if (RQ.peek() <= input)
				RQ.add(input);
			else
				LQ.add(input);
			
			while (true) {
				if (LQ.size() == RQ.size() || LQ.size() + 1 == RQ.size())
					break;
				if (LQ.size() < RQ.size())
					LQ.add(RQ.poll());
				else
					RQ.add(LQ.poll());
			}
			
			if (LQ.size() == RQ.size())
				sb.append(LQ.peek() + "\n");
			else if (LQ.size() + 1 == RQ.size())
				sb.append(RQ.peek() + "\n");
		}
		
		System.out.println(sb);
	}
}
