package swea_1223_Calc2;

import java.util.Scanner;
import java.util.Stack;

public class Calc2 {
	static final int tc = 10;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PostFix pf = new PostFix();
		
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			String calc = sc.next();
			
			String halfres = pf.in(calc, n);
			
			int res = pf.out(halfres, halfres.length());
			
			System.out.println("#" + t + " " + res);
		}
	}
}

class PostFix {
	
	Stack<Priority> stack = new Stack<Priority>();
	Stack<Integer> stacknum = new Stack<Integer>();
	
	public String in(String calc, int n) {
		String res = "";
		
		for (int i = 0; i < n; i++) {
			if('0' <= calc.charAt(i) && calc.charAt(i) <= '9') {
				res += calc.charAt(i);
				continue;
			}
			res = Compare(new Priority(calc.charAt(i)), res);
		}
		
		while (!stack.isEmpty()) {
			res += stack.pop().ao;
		}
		
		return res;
	}
	
	public int out(String calc, int n) {
		int res = 0;
		
		for (int i = 0; i < n; i++) {
			if('0' <= calc.charAt(i) && calc.charAt(i) <= '9') {
				stacknum.add(calc.charAt(i) - '0');
			} else {
				if (calc.charAt(i) == '+') {
					int temp = stacknum.pop() + stacknum.pop();
					stacknum.add(temp);
				}
				if (calc.charAt(i) == '*') {
					int temp = stacknum.pop() * stacknum.pop();
					stacknum.add(temp);
				}
			}
		}
		res = stacknum.pop();
		
		return res;
	}

	public String Compare(Priority input, String res) {
		
		while (!stack.isEmpty() && stack.peek().p > input.p) {
			res += stack.pop().ao;
		}
		while (input.ao == ')') {
			if (stack.peek().p == 0) {
				stack.pop();
				return res;
			}
			res += stack.pop().ao;
		}

		if (stack.isEmpty()) {
			if (input.ao == '(') input.p = 0;
			stack.push(input);
		} else if (stack.peek().p == input.p) {
			Priority temp = stack.pop();
			stack.push(input);
			res += temp.ao;
		} else if (stack.peek().p < input.p) {
			if (input.ao == '(') input.p = 0;
			stack.push(input);
		} 
		return res;
	}
}

class Priority {
	char ao;
	int p;
	
	public Priority(char ao) {
		super();
		this.ao = ao;
		if (ao == '+') this.p = 1;
		else if (ao == '*') this.p = 2;
		else if (ao == '(') this.p = 3;
	}
}
