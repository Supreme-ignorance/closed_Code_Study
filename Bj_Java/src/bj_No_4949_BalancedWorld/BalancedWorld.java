package bj_No_4949_BalancedWorld;

import java.util.Scanner;
import java.util.Stack;

public class BalancedWorld {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		line : while (true) {
			String input = "";
			
			do {
				input += sc.nextLine();
			} while (input.charAt(input.length()-1) != '.');
			
			if (input.equals(".")) break;
			
			char[] c = input.toCharArray();
			
			Stack<Character> s = new Stack<>();
			
			for (char i : c) {
				if (i == '(' || i == '[') {
					s.add(i);
				} else if (i == ')' &&  (s.isEmpty() || s.pop() != '(')) {
					System.out.println("no");
					continue line;
				} else if (i == ']' &&  (s.isEmpty() || s.pop() != '[')) {
					System.out.println("no");
					continue line;
				}
			}
			
			if (s.isEmpty()) System.out.println("yes");
			else System.out.println("no");
		}
		sc.close();
	}
}
