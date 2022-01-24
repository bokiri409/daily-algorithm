package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2021.01.24 daily algo/commit
 * 
 * DP or ��������
 * int[][] ������ �迭 -> �޸��ʰ�
 * �������迭�� ���� ���� ���� �ʰ� �Է� �����鼭 ������ �� �ִ�.
 */


public class boj_2056 {
	
	static int n, time = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
//		int[][] prework = new int[n+1][n+1];
//		LinkedList<ArrayList<Integer>> prework = new LinkedList<ArrayList<Integer>>();
		int[] times = new int[n+1]; // �ҿ� �ð�
		int[] taken = new int[n+1]; // �ɸ� �ð�
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			times[i] = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
//			ArrayList<Integer> pre = new ArrayList<Integer>();
			int max = 0;
			for(int j=0; j<num; j++) {
				int work = Integer.parseInt(st.nextToken());
				max = Math.max(max, taken[work]);
//				prework[i][work] = 1;
			}
			taken[i] = times[i] + max;
		}
		br.close();
		
		/*
		for(int i=0; i<n; i++) {
			int max = 0;
			for(int j=0; j<prework.get(i).size(); j++) {
//				System.out.println(prework.get(i).get(j));
				max = Math.max(max, taken[prework.get(i).get(j)]);
			}
//			for(int j=1; j<=i; j++) {
//				if(prework[i][j] == 1) {
//					max = Math.max(max, taken[j]);
//				}
//			}
			max += times[i+1];
			taken[i+1] += max;
		}
		*/
		Arrays.sort(taken);
		
		bw.write(String.valueOf(taken[n]));
		bw.flush();
	}

}
