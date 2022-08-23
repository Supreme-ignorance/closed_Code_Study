package swea_2930_Heap;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Heap {
	static Node root;
	static int size;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			System.out.print("#" + t);
			for (int i = 0; i < n; i++) {
				int c = sc.nextInt();
				
				switch (c) {
				case 1: 
					add(sc.nextInt());
					break;
				case 2:
					System.out.print(" " + remove());
					break;
				}
			} System.out.println();
		}
	}
	
	static void add(int value) {
		Node node = new Node(value);
		if (root == null) {
			root = node;
			size++;
			return;
		} else {
			Queue<Node> q = new LinkedList<Node>();
			q.add(root);
			
			while (!q.isEmpty()) {
				Node temp = q.poll();
				if (temp.left == null) {
					temp.left = node;
					break;
				} else {
					q.add(temp.left);
				}
				
				if (temp.right == null) {
					temp.right = node;
					break;
				} else {
					q.add(temp.right);
				}
			} 
			size++;
			if (size > 1)sort(root);
		}
	}

	static void sort(Node node) {
		if (node == null || node.left == null)
			return;
		
		
		if ((node.left != null && node.right == null) || node.left.value >= node.right.value) {
			if (node.left.value > node.value) {
				int temp = node.left.value;
				node.left.value = node.value;
				node.value = temp;
				return;
			}
		} else {
			if (node.right.value > node.value) {
				int temp = node.right.value;
				node.right.value = node.value;
				node.value = temp;
				return;
			}
		}
		sort(node.left);
		sort(node.right);		
	}
	
	static int remove() {
		if (root == null) return -1;
		int tempvalue = root.value;
		Node last = root;
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(last);
		
		while (!q.isEmpty()) {
			Node temp = q.poll();
			last = temp;
			if (temp.left != null) {
				q.add(temp.left);
			}
			if (temp.right != null) {
				q.add(temp.right);
			}
		}
		
		q.add(root);
		
		while (!q.isEmpty()) {
			Node temp = q.poll();
			
			if (isSame(temp,last)) {
				root = null;
				size--;
				return tempvalue;
            }
			if (isSame(temp.left, last)) {
				temp.left = null;
				break;
			}
			if (isSame(temp.right, last)) {
				temp.right = null;
				break;
			}
		}
		
		last.right = root.right;
		last.left = root.left;
		root = last;
		size--;
		if (size == 1) {
			root.left = null;
			root.right = null;
		} else if (size == 2) {
			root.right = null;
		}
		if (size > 1) sort(root);
		
		return tempvalue;
	}
	
	static boolean isSame(Node a, Node b) {
        if (a.value == b.value && a.left == b.left && a.right == b.right) {
            return true;
        }
        return false;
    }
}

class Node {
	int value;
	Node left;
	Node right;
	
	public Node (int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}
