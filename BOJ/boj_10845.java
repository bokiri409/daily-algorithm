package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 2021.06.29 daily algo/commit
 * 
 * 큐, 데크 참고:
 * https://velog.io/@thalals/java-%EC%9E%90%EB%B0%94-%ED%81%90-Queue-Deque
 * 
 * StringBuilder 사용 시 시간 : 184ms
 * 그냥 print 사용 시 시간 : 384ms
 */

public class boj_10845 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Deque<Integer> dq = new LinkedList<Integer>();
		
		String cal = null;
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			cal = st.nextToken();
			switch (cal) {
				case "push": dq.push(Integer.parseInt(st.nextToken()));
					break;
				case "pop": 
					if(dq.isEmpty()) {
//						System.out.println(-1);
						sb.append(-1).append("\n");
					}else {
//						System.out.println(dq.pollFirst());
						sb.append(dq.pollLast()).append("\n");
					}
					break;
				case "size": 
//					System.out.println(dq.size());
					sb.append(dq.size()).append("\n");
					break;
				case "empty": 
					if(dq.isEmpty()) {
//						System.out.println(1);
						sb.append(1).append("\n");
					}else {
//						System.out.println(0);
						sb.append(0).append("\n");
					}
					break;
				case "front": 
					if(dq.isEmpty()) {
//						System.out.println(-1);
						sb.append(-1).append("\n");
					}else {
//						System.out.println(dq.peekLast());
						sb.append(dq.peekLast()).append("\n");
					}
					break;
				case "back": 
					if(dq.isEmpty()) {
//						System.out.println(-1);
						sb.append(-1).append("\n");
					}else {
//						System.out.println(dq.peekFirst());
						sb.append(dq.peekFirst()).append("\n");
					}
					break;
				default:
					break;
				}
		}
		System.out.print(sb);
		
		br.close();
	}

}
