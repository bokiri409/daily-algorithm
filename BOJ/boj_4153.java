package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2021.08.31 daily algo/commit
 */

public class boj_4153 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int x2,y2,z2;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			if(x == 0) break;
			
			x2 = (int) Math.pow(x, 2);
			y2 = (int) Math.pow(y, 2);
			z2 = (int) Math.pow(z, 2);
			
			if(x2 == y2 + z2 || y2 == x2 + z2 || z2 == x2 + y2) {
				System.out.println("right");
			}
			else{
				System.out.println("wrong");
			}
		}
	}

}
