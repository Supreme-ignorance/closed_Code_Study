package bj_No_2628_ConfettiCut;

import java.util.*;

public class ConfettiCut {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
 		
		int t = sc.nextInt(); // 몇번 자르는지
		
		List<Integer> row = new ArrayList<>();
		List<Integer> column = new ArrayList<>();
		
		for (int i = 0; i < t; i++) {
			int type = sc.nextInt();
			
			if (type == 1) row.add(sc.nextInt());
			else if (type == 0) column.add(sc.nextInt());
		}
		
		row.add(n);
		column.add(m);
		row.sort(Comparator.naturalOrder());
		column.sort(Comparator.naturalOrder());
		
		for (int i = row.size()-1; i > 0; i--) {
			row.set(i, row.get(i) - row.get(i-1));
		}
		for (int i = column.size()-1; i > 0; i--) {
			column.set(i, column.get(i) - column.get(i-1));
		}
		
		row.sort(Comparator.reverseOrder());
		column.sort(Comparator.reverseOrder());
		
		System.out.println(row.get(0) * column.get(0));
	}
}
