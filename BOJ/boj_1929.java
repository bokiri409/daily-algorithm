package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2021.07.29 daily algo/commit
 * 
 * 에라토스테네스의 체를 이용한 풀이를 해야 시간초과가 안난다!
 */

public class boj_1929 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken()); // 이상
		int N = Integer.parseInt(st.nextToken()); // 이하
		boolean[] nums = new boolean[N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		int p = (int) Math.sqrt(N); 
		for(int i=2; i<=p; i++) {
			if(cal(i)) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int n = q.poll();
			int m = 2;
			while((n*m) <= N) {
				if(n*m>=M && n*m<=N) {
					nums[n*m] = true;
				}
				m += 1;
			}
		}
		
		nums[1] = true;
		for(int i=M; i<=N; i++) {
			if(!nums[i]) {
				System.out.println(i);
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
