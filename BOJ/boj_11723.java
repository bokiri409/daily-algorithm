package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * 2022.02.23 daily algo/commit
 * 
 * 배열을 3000001크기로 만들면 시간초과가 난다.
 * 따라서 HashMap을 이용
 */

public class boj_11723 {

	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
//		int M = sc.nextInt();
		int M = Integer.parseInt(st.nextToken());
//		boolean[] number = new boolean[3000001];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		String cal = "";
		int num = 0;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			cal = st.nextToken();
			if(cal.equals("add")) {
				num = Integer.parseInt(st.nextToken());
//				number[num] = true;
				map.put(num, 1);
			}
			else if(cal.equals("remove")) {
				num = Integer.parseInt(st.nextToken());
//				number[num] = false;
				map.remove(num);
			}
			else if(cal.equals("check")) {
				num = Integer.parseInt(st.nextToken());
//				if(number[num]) System.out.println(1);
//				else System.out.println(0);
//				if(number[num]) sb.append(1+"\n");
//				else sb.append(0+"\n");
				if(map.containsKey(num)) sb.append(1+"\n");
				else sb.append(0+"\n");
			}
			else if(cal.equals("toggle")) {
				num = Integer.parseInt(st.nextToken());
//				if(number[num]) number[num] = false;
//				else number[num] = true;
				if(map.containsKey(num)) map.remove(num);
				else map.put(num, 1);
			}
			else if(cal.equals("all")) {
//				Arrays.fill(number, false);
				map.clear();
				for(int j=1; j<=20; j++) {
//					number[j] = true;
					map.put(j, 1);
				}
			}
			else if(cal.equals("empty")) {
//				Arrays.fill(number, false);
				map.clear();
			}
		}
		System.out.println(sb);
	}

}
