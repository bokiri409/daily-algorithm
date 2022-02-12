package BOJ;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * 2021.02.12 daily algo/commit
 */

public class boj_1966 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for(int i=0; i<t; i++) {
			int docs = sc.nextInt(); // ���� ����
			int order = sc.nextInt(); // �ش� ������ ����
			// �߿䵵
			int[] importance = new int[docs];
			Integer[] imp_order = new Integer[docs];
			for(int j=0; j<docs; j++) {
				importance[j] = imp_order[j] = sc.nextInt();
			}
			Arrays.sort(imp_order, Collections.reverseOrder());
			System.out.println(print(order, importance, imp_order));
		}
		sc.close();
	}
	
	public static int print(int order, int[] importance, Integer[] imp_order) {
		boolean[] visited = new boolean[importance.length];
		int idx_max = 0; // �߿�� �ε���
		int idx_print = 0; // ��� �ε���
		int idx = 0; // ���� �ε���
		
		while(true) {
			if(!visited[idx] && importance[idx] == imp_order[idx_max]) {
				idx_print += 1;
				if(order == idx) return idx_print;
				visited[idx] = true;
				idx_max += 1;
			}
			idx += 1;
			if(idx == importance.length) idx = 0;
		}
	}

}
