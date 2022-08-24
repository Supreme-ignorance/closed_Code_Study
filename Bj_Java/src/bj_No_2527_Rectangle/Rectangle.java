package bj_No_2527_Rectangle;

import java.util.Scanner;

public class Rectangle {
	static final int tc = 4;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t = 0; t < tc; t++) {
			
			//직사각형 정보 입력
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			
			int v = sc.nextInt();
			int w = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();


			if (a <= v && b <= w && c >= x && d >= y)
				System.out.println("a"); //
			else if (a >= v && b >= w && c <= x && d <= y)
				System.out.println("a"); //
			else if (a == x && d == w)
				System.out.println("c"); //
			else if (a == x && d == w)
				System.out.println("c"); //
			else if (c == v && d == w)
				System.out.println("c"); //
			else if (a == x && y == b)
				System.out.println("c"); //
			else if (c == v && y == b)
				System.out.println("c"); //
			else if (c < v || x < a || d < w || y < b)
				System.out.println("d"); //
			else if (d == w)
				System.out.println("b"); //
			else if (a == x)
				System.out.println("b"); //
			else if (b == y)
				System.out.println("b"); //
			else if (c == v)
				System.out.println("b"); // 
			else {
				System.out.println("a"); //
			}

		}
	}
}
