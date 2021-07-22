package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2021.07.22 daily algo/commit
 * 
 * Á¦°ö¼ö °è»ê : Math.pow()
 */

public class boj_2745 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String N = st.nextToken();
		int B = Integer.parseInt(st.nextToken());
		int sum = 0;
		
		for(int i=0; i<N.length(); i++) {
			if(N.charAt(i) - '0' >= 17) {
				sum += ((N.charAt(i) - '0') - 7) * Math.pow(B, N.length()-i-1);
			}
			else {
				sum += (N.charAt(i) - '0') * Math.pow(B, N.length()-i-1);
			}
		}
		System.out.print(sum);
		br.close();
	}

}
