package Programmers;

/*
 * 2021.09.17 daily algo/commit
 * 
 */

public class prg_week7_입실퇴실 {
	
	static int[] enter = {1,4,2,3};
	static int[] leave = {2,1,3,4};
	static boolean[] visited;
	static int[] answer;

	public static void main(String[] args) {
		solution(enter, leave);
	}
	
	public static int[] solution(int[] enter, int[] leave) {
        answer = new int[enter.length];
        visited = new boolean[enter.length+1]; // 회의실 입실 여부
        
        int j = 0;
    	for(int i=0; i<enter.length; i++) {
    		meeting(enter[i]);
    		visited[enter[i]] = true; // 입실 여부
    		
    		while(j < leave.length) {
    			if(visited[leave[j]]) { // 퇴실해야할 사람이 입실 상태일 때
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
	
	public static void meeting(int num) { // 서로 만난 횟수 체크
		for(int i=1; i<visited.length; i++) {
			if(visited[i]) { // 룸안에 있는 사람 체크
				answer[num-1] += 1;
				answer[i-1] += 1;
			}
		}
	}

}
