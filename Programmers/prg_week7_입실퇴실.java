package Programmers;

/*
 * 2021.09.17 daily algo/commit
 * 
 */

public class prg_week7_�Խ���� {
	
	static int[] enter = {1,4,2,3};
	static int[] leave = {2,1,3,4};
	static boolean[] visited;
	static int[] answer;

	public static void main(String[] args) {
		solution(enter, leave);
	}
	
	public static int[] solution(int[] enter, int[] leave) {
        answer = new int[enter.length];
        visited = new boolean[enter.length+1]; // ȸ�ǽ� �Խ� ����
        
        int j = 0;
    	for(int i=0; i<enter.length; i++) {
    		meeting(enter[i]);
    		visited[enter[i]] = true; // �Խ� ����
    		
    		while(j < leave.length) {
    			if(visited[leave[j]]) { // ����ؾ��� ����� �Խ� ������ ��
    				visited[leave[j]] = false;
    				j++;
    			}
    			else {
    				break;
    			}
    		}
    	}
        
        return answer;
    }
	
	public static void meeting(int num) { // ���� ���� Ƚ�� üũ
		for(int i=1; i<visited.length; i++) {
			if(visited[i]) { // ��ȿ� �ִ� ��� üũ
				answer[num-1] += 1;
				answer[i-1] += 1;
			}
		}
	}

}
