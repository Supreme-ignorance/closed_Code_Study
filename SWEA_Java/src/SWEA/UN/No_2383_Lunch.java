package SWEA.UN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No_2383_Lunch {
	static int n;
	static int[][] map;
	static ArrayList<Person> persons;
	static ArrayList<Stair> stairs;
	static PriorityQueue<Person> in;
	static boolean[] isin;
	static int res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.valueOf(br.readLine());

		for (int t = 1; t <= tc; t++) {
			n = Integer.valueOf(br.readLine());

			map = new int[n][n];
			persons = new ArrayList<>();
			stairs = new ArrayList<>();
			in = new PriorityQueue<>();
			res = Integer.MAX_VALUE;

			// 입력 받고 배열에 담기
			for (int r = 0; r < n; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < n; c++) {
					map[r][c] = Integer.valueOf(st.nextToken());
					if (map[r][c] == 1)
						persons.add(new Person(r, c));
					else if (map[r][c] != 0)
						stairs.add(new Stair(r, c, map[r][c]));
				}
			}

			cellStair(0);
			
			System.out.println("#" + t + " " + res);
		}
	}

	private static void cellStair(int depth) {
		if (depth == persons.size()) {
			isin = new boolean[persons.size()];
			out(1, 0);
			System.out.println();
			return;
		}
		
		Person person = persons.get(depth);
		
		person.target = 0;
		Stair stair = stairs.get(person.target);
		int time = Math.abs(person.r - stair.r) + Math.abs(person.c - stair.c);
		person.time = time;
		
		cellStair(depth + 1);
		
		person = persons.get(depth);
		
		person.target = 1;
		stair = stairs.get(person.target);
		time = Math.abs(person.r - stair.r) + Math.abs(person.c - stair.c);
		person.time = time;
		
		cellStair(depth + 1);
	}

	private static void out(int timeline, int outperson) {
		for (int i = 0; i < persons.size(); i++) {
			if (!isin[i]) {
				
				persons.get(i).time = persons.get(i).time - 1;
				
				if (persons.get(i).time <= 0 && stairs.get(persons.get(i).target).in < 3) {
					isin[i] = true;
					stairs.get(persons.get(i).target).in++;
					persons.get(i).outtime = timeline + stairs.get(persons.get(i).target).time;
					in.add(persons.get(i));
				}
			}
		}
		while (!in.isEmpty()) {
			if (in.peek().outtime == timeline) {
				stairs.get(in.peek().target).in--;
				in.poll();
				outperson += 1;
			} else {
				break;
			}
		}
		
		if (outperson == persons.size()) {
			if (res > timeline) res = timeline;
			return;
		} else {
			out(timeline + 1, outperson);
		}
	}
}

class Person implements Comparable<Person> {

	int r;
	int c;
	int target;
	int time;
	int outtime;

	public Person(int r, int c) {
		this.r = r;
		this.c = c;
		this.target = -1;
		this.time = 0;
		this.outtime = 0;
	}

	@Override
	public int compareTo(Person o) {
		return this.time - o.time;
	}
	
}

class Stair {
	int r;
	int c;
	int time;
	int in;

	public Stair(int r, int c, int time) {
		this.r = r;
		this.c = c;
		this.time = time;
		this.in = 0;
	}
}