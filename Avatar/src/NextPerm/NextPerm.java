package NextPerm;

import java.util.Arrays;

public class NextPerm {
	static int[] arr = {0, 0, 1, 1};
	public static void main(String[] args) {
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		do {
			// 초기화
			int A = arr.length - 1;
			int B = -1;
			int C = -1;
			
			// A = 꼭대기
			for (int i = arr.length - 1; i >= 0; i--) {
				if (arr[A] <= arr[i]) A = i;
				else break;
			}
			
			// B는 꼭대기 왼쪽
			B = A - 1;
			if (B < 0) {
				break;
			}
			
			// C는 B보다 최초로 큰 수
			for (int i = arr.length - 1; i >= 0; i--) {
				if (arr[B] < arr[i]) {
					C = i;
					break;
				}
			}
			
			swap(arr, B, C);
			
			for (int i = 0; i < (A + arr.length) / 2 - A; i++) {
				swap(arr, A + i, arr.length - 1 - i);
			}

			System.out.println(Arrays.toString(arr));
		} while (true);
	}
	
	static void swap (int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
