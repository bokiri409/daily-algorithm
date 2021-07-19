package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2021.07.19 daily algo/commit
 * 
 * 입력 : 첫째 줄에 두 자연수 A와 B를 이루는 1의 개수가 주어진다. 입력되는 수는 263보다 작은 자연수이다.
 * 
 * 정수타입
 * byte  : 1byte,  -2^7 ~ (2^7-1)
 * short : 2byte, -2^15 ~ (2^15-1)
 * char  : 2byte,     0 ~ (2^16-1)
 * int   : 4byte, -2^31 ~ (2^31-1)
 * long  : 8byte, -2^63 ~ (2^63-1) 
 * 
 * 
 * 일반 print는 시간초과
 * => StringBuilder 사용!
 */

public class boj_1850 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Long A = Long.parseLong(st.nextToken());
		Long B = Long.parseLong(st.nextToken());
		Long max = Math.max(A, B);
		Long min = Math.min(A, B);
		Long gcd; // 최대공약수
		
		while(true) {
			if(max % min == 0) {
				gcd = min;
				break;
			}
			else {
				gcd = min;
				min = max % gcd;
				max = gcd;
			}
		}
		
		for(int i=0; i<gcd; i++) {
			sb.append(1);
		}
		System.out.print(sb);
		
		br.close();
	}

}
