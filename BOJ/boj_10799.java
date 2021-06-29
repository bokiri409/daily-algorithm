package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2021.06.29 daily algo/commit
 * 
 * �ѹ��� ó���Ϸ��� �� �ʿ䰡 ����, ������ ���� �� �ʿ䰡 ����. 
 * => �׶��׶� �������� �ڸ� ������� ������ ���� �ȴ�.
 */

public class boj_10799 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String bars = br.readLine();
		
		int bar = 0;
		int answer = 0;
		for(int i=0; i<bars.length(); i++) {
			if(bars.charAt(i) == '(') {
				bar += 1;
			}
			else {
				if(bars.charAt(i-1) == '(') {
					bar -= 1;
					answer += bar;
				}
				else {
					bar -= 1;
					answer += 1;
				}
			}
		}
		System.out.print(answer);
		
		br.close();
	}

}
