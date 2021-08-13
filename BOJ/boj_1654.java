package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2021.08.13 daily algo/commit
 * 
 * �̺� Ž��
 */

public class boj_1654 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken()); // ������ �ִ� ���� ��
		int N = Integer.parseInt(st.nextToken()); // �ʿ��� ���� ��
		int[] lans = new int[K];
		for(int i=0; i<K; i++) {
			lans[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(lans); // �迭 ����
		
		long min = 1; // ������ �ּҰ�
		long max = lans[K-1]; // ������ �ִ밪
		long mid = 0;
		
		while(min <= max) {
			int num = 0;
			mid = (min + max)/2;
			for(int i=0; i<K; i++) {
				num += lans[i]/mid;
			}
			if(num >= N) {
				min = mid + 1;
			}
			else {
				max = mid - 1;
			}
		}
		System.out.print(max);
		
		br.close();
	}

}
