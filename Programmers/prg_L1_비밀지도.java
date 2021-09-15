package Programmers;

/*
 * 2021.09.15 daily algo/commit
 */

public class prg_L1_비밀지도 {
	
	static int n = 5;
	static int[] arr1 = {9, 20, 28, 18, 11};
	static int[] arr2 = {30, 1, 21, 17, 28};

	public static void main(String[] args) {
		solution(n, arr1, arr2);
	}
	
	public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] wall; 
        
    	for(int i=0; i<n; i++) {
    		// 이진법
    		wall = new String[n];
    		for(int j=0; j<n; j++) {
    			if(arr1[i] % 2 == 1 || arr2[i] % 2 == 1) { // 벽이면
    				wall[n-j-1] = "#";
    			}
    			arr1[i] /= 2;
    			arr2[i] /= 2;
    		}
    		
    		answer[i] = "";
    		for(int j=0; j<n; j++) {
    			if(wall[j] == "#") {
    				answer[i] += "#";
    			}
    			else {
    				answer[i] += " ";
    			}
    		}
    	}
        
        return answer;
    }

}
