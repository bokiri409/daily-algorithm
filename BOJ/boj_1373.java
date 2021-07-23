package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2021.07.23 daily algo/commit
 * 
 * 풀이1 : 2진수 -> 10진수 -> 8진수, 10진수로 바꿀 때 long타입 필요
 * 풀이2 : 2진수 (3자리씩 끊어서) -> 8진수 로 바로 변환가능
 */

public class boj_1373 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String S = br.readLine();
		
		int n = 1; // 3의 배수 측정 변수
		int sum = 0;
		for(int i=S.length()-1; i>=0; i--) {
			sum += (S.charAt(i) - '0') * Math.pow(2, n-1);
			switch (n) {
			case 1:
				n++;
				break;
			case 2:
				n++;
				break;
			case 3:
				n = 1;
				sb.insert(0, sum);
				sum = 0;
				break;
			}
		}
		if(sb.length() == 0 || sum != 0) { // 처음부터 0인 경우 생각해줘야 한다!
			sb.insert(0, sum);
		}
		System.out.print(sb);
		br.close();
	}

}
