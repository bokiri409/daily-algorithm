package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * 2022.05.10 daily algo/commit
 * 
 * �������� ���� - �����佺�׳׽��� ü Ȱ��
 * 10^18���Ͽ����� ���� ���� �̹� ����Ǿ� �����Ƿ� 1,000,000������ ��� ���� ��� ������ ���� �ִٰ� �����ϰ� Ǯ�� �ȴ�.
 */

public class boj_6588_2 {
	
	static final int MAX = 1000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// �����佺�׳׽��� ü
		List<Integer> prime = new ArrayList<Integer>();
		boolean[] primes = new boolean[MAX+1];
		primes[0] = primes[1] = true;
		for(int i=2; i*i<=MAX; i++) {
			if(primes[i]) continue;
			else prime.add(i);
			for(int j=2; i*j<=MAX; j++) {
				primes[i*j] = true; // �Ҽ� x
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
