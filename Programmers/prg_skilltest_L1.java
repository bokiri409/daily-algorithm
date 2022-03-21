package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class prg_skilltest_L1 {
	
	static int[] arr = {5, 9, 7, 10};
	static int divisor = 5;

	public static void main(String[] args) {
		System.out.println(solution(arr, divisor));
	}

	public static List<Integer> solution(int[] arr, int divisor) {
		List<Integer> answer = new ArrayList<Integer>();
		Arrays.sort(arr);
		for(int i=0; i<arr.length; i++) {
			if(arr[i] % divisor == 0) answer.add(arr[i]);
		}
		if(answer.size() == 0) answer.add(-1);
        return answer;
    }
}
