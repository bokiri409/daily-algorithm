package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * 2021.06.15 daily algo/commit
 * 
 * Comparator를 이용한 string 정렬
 * 참고 : https://zoonvivor.tistory.com/56
 */

public class boj_10814 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String[][] list = new String[N][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			list[i][0] = st.nextToken();
			list[i][1] = st.nextToken();
		}
		
		// 오름차순
//		Arrays.sort(list, (t1, t2) -> {
//			if(t1[0].equals(t2[0])) {
////				return Integer.compare(t1[1], t2[1]);
//				return t1[1].compareTo(t2[1]);
//			}else {
////				return Integer.compare(t1[0], t2[0]);
//				return t1[0].compareTo(t2[0]);
//			}
//		});
		
		Arrays.sort(list, new Comparator<String[]>(){
            @Override
            public int compare(String[] one, String[] two){
                return Integer.compare(Integer.parseInt(one[0]),Integer.parseInt(two[0]));
            }
        });
		
		for(int i=0; i<N; i++) {
			sb.append(list[i][0]).append(" ").append(list[i][1]).append(" ").append("\n");
		}
		System.out.println(sb);
		
		br.close();
	}

}
