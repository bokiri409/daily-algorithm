package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 2021.06.22 daily algo/commit
 */

public class boj_11652 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] list = new long[N];
		
		for(int i=0; i<N; i++) {
			list[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(list);
		
		long result = card(N, list);
		System.out.println(result);
		br.close();
	}
	
	static long card(int N, long[] list) {
		int max = 0;
		int num = 1;
		long answer = list[0];
		for(int i=1; i<N; i++) {
			if(list[i] == list[i-1]) { // 같은 수 나올 때
				num += 1;
			}
			else { // 다른 수 나올 때
				if(max == 0) {
					max = num;
				}
				else if(max != 0 && max < num) {
					max = num;
					answer = list[i-1];
				}
				num = 1;
			}
			if(i == N-1) {
				if(max < num) {
					max = num; 
					answer = list[i];
				}
			}
		}
		return answer;
	}

}
