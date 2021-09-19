package Programmers;

import java.util.Arrays;

/*
 * 2021.09.19 daily algo/commit
 * 
 * Arrays.copyOfRange(������ �迭, ���� �ε���, ������ �ε���); �� ����Ͽ� �迭 ����
 * ����Ǵ� �迭�� ������ �ε����� �� ��ұ��� ����ȴ�.
 * 
 * �迭 ��� ��� 
 * Arrays.toString(�迭); 
 */

public class prg_L1_K��°�� {
	
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
    		start = commands[t][0]-1; // list ���� index
    		end = commands[t][1]-1; // list �� index
    		num = commands[t][2]-1; // �̾Ƴ� ���� index
    		
    		int[] list = Arrays.copyOfRange(array, start, end+1);
    		Arrays.sort(list);
//    		System.out.println(Arrays.toString(list));
    		answer[t] = list[num];
        }
        
        return answer;
    }

}
