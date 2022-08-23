package bj_No_9934_PBT;

import java.util.Scanner;

public class PBT {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		
		int[] inorder = new int[(int) Math.pow(2, k) - 1];
		
		for (int i = 0; i < inorder.length; i++) {
			inorder[i] = sc.nextInt();
		}
		
		int[][] bt = new int[k][];
		
		for (int i = 0; i < k; i++) {
			bt[i] = new int[(int) Math.pow(2, i)];
		}
		
		int[] order = new int[k];
		
		insert(bt, inorder, 0, (int) Math.pow(2, k) - 2, 0, order);
		
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < bt[i].length; j++) {
				System.out.print(bt[i][j] + " ");
			}
			System.out.println();
		}
	}	
	
	static void insert (int[][] bt, int[]inorder, int start, int end, int deapth, int[] order) {
		int mid = (start + end) / 2;
		
		if (deapth >= bt.length) return;
		
		bt[deapth][order[deapth]++] = inorder[mid];
		
		insert(bt, inorder, start, mid-1, deapth+1, order);
		insert(bt, inorder, mid+1, end, deapth+1, order);
	}
}


























