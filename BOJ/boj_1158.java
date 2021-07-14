package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2021.07.14 daily algo/commit
 * 
 * 1. ť�� �̿��Ͽ� K��° �����ϱ� ������ �ڷ� ���̱�
 * 2. ��ũ�� ����Ʈ�� �̿�
 */

public class boj_1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<Integer>();
		int N, K = 0;
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		
		sb.append("<");
		while(!q.isEmpty()) { // ����Ʈ �� ������
			for(int i=0; i<K; i++) {
				if(i==K-1) { // K��° �� ��
					sb.append(q.poll()); // ���ŵ� ��ȣ
					if(!q.isEmpty()) { // �������� �ƴ϶�� ��ǥ �߰�
						sb.append(", ");
					}
				}
				else { // K��° �ƴ� �� �ڷ� ���̱�
					q.add(q.poll());
				}
			}
		}
		sb.append(">");
		System.out.print(sb);
		br.close();
	}

}
