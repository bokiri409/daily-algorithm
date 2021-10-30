package Programmers;

import java.util.*;

public class prg_L3_숫자게임 {
	
	static int[] A = {5,1,3,7};
	static int[] B = {2,2,6,8};

	public static void main(String[] args) {
		System.out.println(solution(A, B));
	}

    public static int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int a = 0;
        for(int i=0; i<B.length; i++) {
            if(B[i] > A[a]) { //B의 점수가 크면
                answer += 1;
                a += 1;
                continue;
            }
        }

        return answer;
    }

}
