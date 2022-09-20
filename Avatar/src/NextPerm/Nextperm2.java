package NextPerm;

import java.util.Arrays;

public class Nextperm2 {
	public static void main(String[] args) {
	int[] arr = {0, 0, 0, 1, 1, 1};
	
	do { // 일단 현재를 먼저 출력한 후
		System.out.println(Arrays.toString(arr));
	} while(np(arr)); // 다음 순열이 있다면 또 출력한다.
	// 만약에 없다면 while문을 빠져나온다.
	
}

// 다음 순열을 만드는 함수
// 만약에 다음 순열이 있다면, arr -> 다음 순열로 만들고 -> true
// 만약에 다음 순열이 없다면, false
private static boolean np(int[] arr) {
	// 1. 꼭대기 찾기
	//   - 배열의 가장 끝부터 앞의 순서로 탐색 시작 (오른쪽 -> 왼쪽)
	int i = arr.length - 1; // 배열의 가장 끝
	while(i > 0  && arr[i-1] >= arr[i]) i--;
	// arr[i-1] < arr[i] 인 상황에서 멈춤.
	// 낭떠러지(B) < 꼭대기(A)
	// 1-1. 꼭대기가 0번 인덱스에 있는 경우
	if(i == 0) return false; // 꼭대기가 가장 첫번째 수라면, 이미 제일 큰수
	// 다음 순열이 없으므로 false를 리턴, 낭떠러지가 없는 경우이기도 함
	// 1-2. 낭떠러지가 있는 경우
	// 꼭대기(A): i
	// 낭떠러지(B): i-1
	// 2. 낭떠러지보다 큰 수 찾기. 낭떠러지보다 커지는 최초의 수
	//   - 배열의 오른쪽 -> 앞
	int j = arr.length -1; // 배열의 가장 뒤에서 탐색 시작
	while(arr[i-1] >= arr[j]) j--;
	// 낭떠러지보다 커지는 최초의 수(C): j
	// 3. B와 C 위치 교환하기
	swap(arr, i-1, j);
	// 4. 역순으로 뒤집기
	// 낭떠러지 -> 큰 수: 최고차항이 바뀐 것과 같이
	// 낭떠러지 (i-1) 제외하고 나머지를 가장 작은 수로 만들어줘야함
	// i~끝까지 순서를 역순으로 만들어준다.
	// 시작 : i
	// 끝: arr.length - 1 = k
	int k = arr.length - 1;
	while(i < k) swap(arr, i++, k--);
	return true;
}

// 배열의 i번째 인덱스와 j번째 인덱스 위치의 원소 교환
private static void swap(int[] arr, int i, int j) {
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
}
}
