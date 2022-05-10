package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * 2022.05.10 daily algo/commit
 * 
 * 골드바흐의 추측 - 에라토스테네스의 체 활용
 * 10^18이하에서는 참인 것이 이미 증명되어 있으므로 1,000,000이하의 모든 수는 모두 가능한 답이 있다고 생각하고 풀면 된다.
 */

public class boj_6588_2 {
	
	static final int MAX = 1000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 에라토스테네스의 체
		List<Integer> prime = new ArrayList<Integer>();
		boolean[] primes = new boolean[MAX+1];
		primes[0] = primes[1] = true;
		for(int i=2; i*i<=MAX; i++) {
			if(primes[i]) continue;
			else prime.add(i);
			for(int j=2; i*j<=MAX; j++) {
				primes[i*j] = true; // 소수 x
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int num = 0;
		while((num = Integer.parseInt(br.readLine())) != 0) {
			for(int i=1; i<=prime.size(); i++) {
				int a = prime.get(i);
				int b = num - a;
				if(!primes[b]) {
					sb.append(num+" = "+a+" + "+b+"\n");
					break;
				}
			}
		}
		System.out.println(sb.toString());
	}

}
