package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

/*
 * 2022.02.23 daily algo/commit
 */

public class boj_2108 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] number = new int[N];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			number[i] = Integer.parseInt(st.nextToken());
			if(map.containsKey(number[i])) map.put(number[i], map.get(number[i]) + 1);
			else map.put(number[i], 1);
		}
		
		
		//����
		Arrays.sort(number);
		
		List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
		Collections.sort(entryList, new Comparator<Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				if(o2.getValue() == o1.getValue()) {
					return o1.getKey() - o2.getKey();
				}
				else{
					return o2.getValue() - o1.getValue();
				}
			}
		});
		
		// ������
		double sum = 0;
		for(int i=0; i<N; i++) {
			sum += number[i];
		}
		System.out.println(Math.round(sum/N));
		
		// �߾Ӱ�
		// �ߺ����� �����ؼ� �߾Ӱ��� ���ؾ� ���̵ȴ�.
//		int median = entryList.size()/2;
//		System.out.println(entryList.get(median).getKey());
		int median = N/2;
		System.out.println(number[median]);
		
		// �ֺ�
		if(entryList.size() == 1) {
			System.out.println(entryList.get(0).getKey());
		}
		else {
			if(entryList.get(0).getValue() > entryList.get(1).getValue()) System.out.println(entryList.get(0).getKey());
			else System.out.println(entryList.get(1).getKey());
		}
		
		// ����
		System.out.println(number[N-1] - number[0]);
	}

}
