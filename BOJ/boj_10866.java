package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 2021.07.01 daily algo/commit
 * 
 * 큐, 데크 참고:
 * https://velog.io/@thalals/java-%EC%9E%90%EB%B0%94-%ED%81%90-Queue-Deque
 * 
 * StringBuilder 사용 시 시간 : 184ms
 * 그냥 print 사용 시 시간 : 384ms
 */

public class boj_10866 {

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
				case "push_front": dq.addLast(Integer.parseInt(st.nextToken()));
					break;
				case "push_back": dq.addFirst(Integer.parseInt(st.nextToken()));
				break;
				case "pop_front": 
					if(dq.isEmpty()) {
						sb.append(-1).append("\n");
					}else {
						sb.append(dq.pollLast()).append("\n");
					}
					break;
				case "pop_back": 
					if(dq.isEmpty()) {
						sb.append(-1).append("\n");
					}else {
						sb.append(dq.pollFirst()).append("\n");
					}
					break;
				case "size": 
					sb.append(dq.size()).append("\n");
					break;
				case "empty": 
					if(dq.isEmpty()) {
						sb.append(1).append("\n");
					}else {
						sb.append(0).append("\n");
					}
					break;
				case "front": 
					if(dq.isEmpty()) {
						sb.append(-1).append("\n");
					}else {
						sb.append(dq.peekLast()).append("\n");
					}
					break;
				case "back": 
					if(dq.isEmpty()) {
						sb.append(-1).append("\n");
					}else {
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
