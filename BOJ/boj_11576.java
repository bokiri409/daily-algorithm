package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2021.07.27 daily algo/commit
 */

public class boj_11576 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A, B, n = 0; 
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(br.readLine());
		
		int a, sum = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=n-1; i>=0; i--) {
			a = Integer.parseInt(st.nextToken());
			sum += a * Math.pow(A, i);
		}
		
		while(true) {
			if((sum/B) < B) {
				sb.insert(0, sum%B+" ");
				sb.insert(0, sum/B+" ");
				break;
			}
			else {
				sb.insert(0, sum%B+" ");
				sum /= B; // ¸òÀÌ ´Ù½Ã sumÀÌ µÊ
			}
		}
		System.out.print(sb);
		br.close();
	}

}
