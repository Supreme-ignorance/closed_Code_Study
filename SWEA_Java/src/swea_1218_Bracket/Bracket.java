package swea_1218_Bracket;

import java.util.Scanner;
import java.util.Stack;

public class Bracket {
	static final int tc = 10;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		test : for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			Stack<Character> stack = new Stack<>();
			String brackets = sc.next();

			for (int i = 0; i < n; i++) {
				char temp = brackets.charAt(i);
				if (temp == '}' && '{' != stack.pop()) {
					System.out.println("#" + t + " " + 0);
					continue test;
				} else if (temp == ']' && '[' != stack.pop()) {
					System.out.println("#" + t + " " + 0);
					continue test;
				} else if (temp == ')' && '(' != stack.pop()) {
					System.out.println("#" + t + " " + 0);
					continue test;
				} else if (temp == '>' && '<' != stack.pop()) {
					System.out.println("#" + t + " " + 0);
					continue test;
				} else if (temp != '>' && temp != '}' && temp != ')' && temp != ']')
					stack.add(temp);
			}
			
			System.out.println("#" + t + " " + 1);
		}
	}
}
