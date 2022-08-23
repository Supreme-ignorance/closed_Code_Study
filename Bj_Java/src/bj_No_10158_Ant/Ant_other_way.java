package bj_No_10158_Ant;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ant_other_way {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input1 = br.readLine().split(" ");
		String[] input2 = br.readLine().split(" ");
		
		int n = Integer.parseInt(input1[0]);
		int m = Integer.parseInt(input1[1]);
		
		int x = Integer.parseInt(input2[0]);
		int y = Integer.parseInt(input2[1]);
		
		int time = Integer.parseInt(br.readLine());
		
		if ((x + time) / n % 2 == 0) x = (x + time) % n;
		else x = n - (x + time) % n;
		if ((y + time) / m % 2 == 0) y = (y + time) % m;
		else y = m - (y + time) % m;
		
		bw.write(x + " " + y);
		bw.flush();
	}
}
