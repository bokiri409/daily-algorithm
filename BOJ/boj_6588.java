package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 2021.08.01 daily algo/commit
 * 
 * 에라토스테네스의 체를 이용한 풀이를 해야 시간초과가 안난다!
 */

public class boj_6588 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> N = new ArrayList<Integer>();
		int max = 0;
		while(true) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) break;
			if(input > max) {
				max = input;
			}
			N.add(input);
		}
//		N.sort(Comparator.reverseOrder()); // 내림차순
		
		boolean[] nums = new boolean[max]; // 가장 큰 값의 소수들
		Queue<Integer> q = new LinkedList<Integer>();
		int p = (int) Math.sqrt(max); 
		for(int i=2; i<=p; i++) {
			if(cal(i)) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int n = q.poll();
			int m = 2;
			while((n*m) < max) {
				if(n*m>=2 && n*m<max) {
					nums[n*m] = true; // 소수 아닌 것 true로 바꾸기
				}
				m += 1;
			}
		}
		
		for(int i=0; i<N.size(); i++) {
			for(int j=2; j<nums.length; j++) {
				if(!nums[j]) { // 소수 인 것
					int M = N.get(i) - j;
					if(!nums[M]) { // 소수 일 때
						System.out.println(N.get(i)+" = "+j+" + "+M);
						break;
					}
				}
			}
			
		}
			
		
		br.close();
	}
	
	static boolean cal(int num) { // 소수 판별 함수
		for(int i=2; i<num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
