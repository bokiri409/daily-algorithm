package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2021.07.19 daily algo/commit
 * 
 * ���� Ǯ�� : https://velog.io/@hammii/%EB%B0%B1%EC%A4%80-9613-GCD-%ED%95%A9-java
 */

public class boj_9613 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] nums = new int[n];
			for(int j=0; j<n; j++) {
				nums[j] = Integer.parseInt(st.nextToken());
			}
			
			long sum = 0; // �ִ����� ��
			for(int j=0; j<n-1; j++) {
				for(int k=j+1; k<n; k++) {
					int max = Math.max(nums[j], nums[k]);
					int min = Math.min(nums[j], nums[k]);
					sum += gcd(max, min);
				}
			}
			System.out.println(sum);
		}
		
		br.close();
	}
	
	static int gcd(int max, int min) {
		int gcd = 0;
		while(true) {
			if(max % min == 0) { // �������� 0�̵ɶ� ���� ���� �ִ������� �ȴ�.
				gcd = min;
				break;
			}
			else { // �������� 0�� �ƴ� ��
				gcd = max % min; // �������� �ٽ� ������ ���� �ȴ�.
				max = min;
				min = gcd;
			}
		}
		return gcd;
	}

}
