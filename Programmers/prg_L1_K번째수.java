package Programmers;

import java.util.Arrays;

/*
 * 2021.09.19 daily algo/commit
 * 
 * Arrays.copyOfRange(복사할 배열, 시작 인덱스, 마지막 인덱스); 를 사용하여 배열 복사
 * 복사되는 배열은 마지막 인덱스의 전 요소까지 복사된다.
 * 
 * 배열 출력 방법 
 * Arrays.toString(배열); 
 */

public class prg_L1_K번째수 {
	
	static int[] array = {1, 5, 2, 6, 3, 7, 4};
	static int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

	public static void main(String[] args) {
		solution(array, commands);
	}
	
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int start = 0; 
        int end = 0;
        int num = 0;
        for(int t=0; t<commands.length; t++) {
    		start = commands[t][0]-1; // list 시작 index
    		end = commands[t][1]-1; // list 끝 index
    		num = commands[t][2]-1; // 뽑아낼 숫자 index
    		
    		int[] list = Arrays.copyOfRange(array, start, end+1);
    		Arrays.sort(list);
//    		System.out.println(Arrays.toString(list));
    		answer[t] = list[num];
        }
        
        return answer;
    }

}
