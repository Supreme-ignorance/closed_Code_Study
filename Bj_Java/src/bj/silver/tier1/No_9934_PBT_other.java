package bj.silver.tier1;

import java.util.Scanner;

public class No_9934_PBT_other {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		
		int[] inorder = new int[(int) Math.pow(2, k) - 1];
		
		for (int i = 0; i < inorder.length; i++) {
			inorder[i] = sc.nextInt();
		}
		
		int[] bt = new int[(int) Math.pow(2, k)];
		
		insert(bt, inorder, 0, (int) Math.pow(2, k) - 2, 0, 1);
		
		for (int i = 0; i < k; i++) {
			for (int j = (int) Math.pow(2, i); j < Math.pow(2, i+1); j++) {
				if (j == 0) continue;
				System.out.print(bt[j] + " ");
			}
			System.out.println();
		}
	}	
	
	static void insert (int[] bt, int[]inorder, int start, int end, int deapth, int idx) {
		int mid = (start + end) / 2;
		
		if (idx >= bt.length) return;
		
		bt[idx] = inorder[mid];
		
		insert(bt, inorder, start, mid-1, deapth+1, 2*idx);
		insert(bt, inorder, mid+1, end, deapth+1, 2*idx + 1);
	}
}


























