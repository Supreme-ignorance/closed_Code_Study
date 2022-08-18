package swea_1222_Calc1;

import java.util.Scanner;
import java.util.Stack;

public class Calc1 {
	static final int tc = 10;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PostFix pf = new PostFix();
		
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			String calc = sc.next();
			
			String halfres = pf.in(calc, n);
			
			System.out.println(halfres);
			
			int res = pf.out(halfres, n);
			
			System.out.println("#" + t + " " + res);
		}
	}
}

class PostFix {
	
	Stack<Priority> stack = new Stack<Priority>();
	Stack<Integer> stacknum = new Stack<Integer>();
	
	public String in(String calc, int n) {
		String res = "";
		stack.clear();
		
		for (int i = 0; i < n; i++) {
			if('0' <= calc.charAt(i) && calc.charAt(i) <= '9') {
				res += calc.charAt(i);
				continue;
			}
			char notzero = Compare(new Priority(calc.charAt(i)), res);
			if (notzero == 0) continue;
			res += notzero;
		}
		
		while (!stack.isEmpty()) {
			res += stack.pop().ao;
		}
		
		return res;
	}
	
	public int out(String calc, int n) {
		int res = 0;
		stacknum.clear();
		
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
	
	public char Compare(Priority input, String res) {
		if (stack.isEmpty()) {
			stack.push(input);
		} else if (stack.peek().p == input.p) {
			Priority temp = stack.pop();
			stack.push(input);
			return temp.ao;
		} else if (stack.peek().p < input.p) {
			stack.push(input);
		} else if (stack.peek().p > input.p) {
			while (stack.peek().p > input.p) {
				Priority temp = stack.pop();
				res += temp.ao;
			}
			stack.push(input);
		}
		return 0;
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
	}
}
