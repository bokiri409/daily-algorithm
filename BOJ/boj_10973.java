package BOJ;

import java.util.Scanner;

/*
 * 2022.06.17 daily algorithm
 * 
 * Brute Force/Permutation
 * N의 최대 크기가 10,000이기 때문에 전체 경우의 수를 다 해보는 것은 불가능 하다.
 * 
 * next_permutation을 구현한다.
 * - 첫 순열 : 배열의 오름차순
 * - 마지막 순열 : 배열의 내림차순
 * - 다음 순열 : 오른쪽에서 마지막 수 까지 연속된 내림차순을 찾아서 다음 순열의 순서를 찾는다.
 * - 이전 순열 : 오른쪽에서 마지막 수 까지 연속된 오름차순을 찾아서 이전 순열의 순서를 찾는다. 
 */

public class boj_10973 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] order = new int[N];
		for(int i=0; i<N; i++) {
			order[i] = sc.nextInt();
		}
		sc.close();
		
		int index = check_acending(N, order);
		if(index == -1) { // 원래 마지막 순열일 때 
			System.out.println(-1);
		}
		else { 
			for(int i=0; i<order.length; i++) {
				if(i < index) {
					System.out.print(order[i] + " ");
				}
				else if(i == index) {
					for(int j=N-1; j>i; j--) {
						if(order[j] < order[i]) {
							int temp = order[i];
							order[i] = order[j];
							order[j] = temp;
							break;
						}
					}
					System.out.print(order[i] + " ");
					for(int j=N-1; j>i; j--) {
						System.out.print(order[j] + " ");
					}
					break;
				}
			}
		}
	}

	public static int check_acending(int N, int[] order) {
		// 마지막 순서부터 어디까지 내림차순인지 체크
		int num = order[N-1]; // 기준이 되는 맨 마지막 숫자 
		for(int i=N-2; i>=0; i--) {
			if(order[i] > num) return i;
			num = order[i];
		}
		return -1;
	}
}
