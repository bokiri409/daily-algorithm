package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * 2021.06.18 daily algo/commit
 * 
 * Comparator를 이용한 string 정렬
 * 참고 : https://zoonvivor.tistory.com/59
 * 
 * String 사전순 정렬
 * 참고 : https://st-lab.tistory.com/112
 * 
 */

public class boj_10825 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String[][] list = new String[N][4];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			list[i][0] = st.nextToken();
			list[i][1] = st.nextToken();
			list[i][2] = st.nextToken();
			list[i][3] = st.nextToken();
		}
		
		Arrays.sort(list, new Comparator<String[]>(){
            @Override
            public int compare(String[] t1, String[] t2){
            	if(t1[1].equals(t2[1])) { // 국어점수 같을 때 영어점수 오름차순
            		if(t1[2].equals(t2[2])) { // 국어점수와 영어점수가 같으면 수학점수 내림차순
            			if(t1[3].equals(t2[3])) { // 모든 점수가 같을 때 이름 사전순
            				return t1[0].compareTo(t2[0]);
            			}
            			return Integer.compare(Integer.parseInt(t2[3]),Integer.parseInt(t1[3]));
            		}
            		return Integer.compare(Integer.parseInt(t1[2]),Integer.parseInt(t2[2]));
            	}
            	else { // 국어점수 내림차순
            		return Integer.compare(Integer.parseInt(t2[1]),Integer.parseInt(t1[1]));
            	}
            }
        });
		
		for(int i=0; i<N-1; i++) {
			sb.append(list[i][0]).append("\n");
		}
		sb.append(list[N-1][0]);
		System.out.println(sb);
		
		br.close();
	}

}
