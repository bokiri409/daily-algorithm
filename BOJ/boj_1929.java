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
 * �����佺�׳׽��� ü�� �̿��� Ǯ�̸� �ؾ� �ð��ʰ��� �ȳ���!
 */

public class boj_1929 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken()); // �̻�
		int N = Integer.parseInt(st.nextToken()); // ����
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
	
	static boolean cal(int num) { // �Ҽ� �Ǻ� �Լ�
		for(int i=2; i<num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
