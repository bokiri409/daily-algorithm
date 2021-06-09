package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
 * 2021.06.09 daily algo/commit
 * 
 * �ð��ʰ� �ڡڡڡڡڡڡ�
 * ArrayList<Integer> + Collections.sort() + StringBuilder�� �̿��ؼ� �ð� ����
 * 
 * Array.sort()�� �־��� ��� �ð� ���⵵�� O2�� �ȴ�.
 */

public class boj_2751 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
//		Integer[] list = new Integer[N];
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		//��������
//		Arrays.sort(list);
		Collections.sort(list);
//		for(int i=0; i<N; i++) {
//			System.out.println(list.get(i));
//		}
		for(int value : list) {
			sb.append(value).append("\n");
		}
		System.out.println(sb);
		
		br.close();
	}

}
