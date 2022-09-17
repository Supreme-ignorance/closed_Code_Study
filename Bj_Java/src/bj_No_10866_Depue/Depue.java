package bj_No_10866_Depue;

import java.util.*;

public class Depue {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static List<Integer> deque = new LinkedList<Integer>();
	static int size = 0;
	public static void main(String[] args) {
		
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			comand(sc.next());
		}
		System.out.println(sb);
	}
	
	static void comand(String input) {
		switch (input) {
		case "push_front":
			pushFront(sc.nextInt());
			break;
		case "push_back":
			pushBack(sc.nextInt());
			break;
		case "pop_front":
			popFront();
			break;
		case "pop_back":
			popBack();
			break;
		case "size":
			viewsize();
			break;
		case "empty":
			empty();
			break;
		case "front":
			front();
			break;
		case "back":
			back();
			break;
		}
	}
	
	static void pushFront(int input) {
		deque.add(0, input);
		size++;
	}
	
	static void pushBack(int input) {
		deque.add(size, input);
		size++;
	}
	
	static void popFront() {
		int temp = -1;
		if (size != 0) {
			temp = deque.get(0);
			deque.remove(0);
			size--;
		}
		sb.append(temp +  "\n");
	}
	
	static void popBack() {
		int temp = -1;
		if (size != 0) {
			temp = deque.get(size - 1);
			deque.remove(size - 1);
			size--;
		}
		sb.append(temp +  "\n");
	}
	
	static void viewsize() {
		sb.append(size +  "\n");
	}
	
	static void empty() {
		sb.append((size == 0)? 1 +  "\n":0 +  "\n");
	}
	
	static void front() {
		int temp = -1;
		if (size != 0) {
			temp = deque.get(0);
		}
		sb.append(temp +  "\n");
	}
	
	static void back() {
		int temp = -1;
		if (size != 0) {
			temp = deque.get(size - 1);
		}
		sb.append(temp +  "\n");
	}
}
