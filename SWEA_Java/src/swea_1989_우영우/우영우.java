package swea_1989_快康快;

import java.util.Scanner;

public class 快康快 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		test : for (int t = 1; t <= tc; t++) {
			String input = sc.next();
			
			char[] inputList = input.toCharArray();
			char[] temp = new char[inputList.length];
			
			for (int i = 0; i < inputList.length; i++) {
				temp[i] = inputList[inputList.length - 1 -i];
			}
			
			System.out.print("#" + t + " ");
			
			for (int i = 0; i < inputList.length; i++) {
				if (inputList[i] != temp[i]) {
					System.out.println(0);
					continue test;
				}
			}
			System.out.println(1);
		}
	}
}
