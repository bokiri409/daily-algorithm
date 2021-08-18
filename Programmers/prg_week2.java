package Programmers;

/*
 * 2021.08.17 daily algo/commit
 */

public class prg_week2 {
	
	static int[][] scores = {{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};
//	static int[][] scores = {{75, 50, 100}, {75, 100, 20}, {100, 100, 20}};

	public static void main(String[] args) {
		System.out.println(solution(scores));
	}
	
	private static String solution(int[][] scores) {
		StringBuilder sb = new StringBuilder();
        String answer = "";
        
        int max, min;
        for(int i=0; i<scores.length; i++) {
        	boolean chk_max = true; 
        	boolean chk_min = true; // 최저, 최고인지 
        	double avg = 0; // 평균값
        	int sum = 0;
        	max = scores[i][i]; // 자기 자신에게 준 점수
        	min = scores[i][i]; // 자기 자신에게 준 점수
        	for(int j=0; j<scores.length; j++) {
        		if(max <= scores[j][i] && i != j) {
        			chk_max = false;
        		}
        		if(min >= scores[j][i] && i != j) {
        			chk_min = false;
        		}
        		sum += scores[j][i];
        	}
        	if(chk_max || chk_min) { // 유일한 최고점 or 최저점 일 때
        		avg = (double)(sum - scores[i][i]) / (scores.length - 1);
        	}
        	else {
        		avg = (double)sum / scores.length;
        	}
        	sb.append(grade(avg));
        }
        answer += sb;
        return answer;
    }
	
	private static char grade(double avg) {
		switch ((int)avg/10) {
		case 10:
		case 9: 
			return 'A';
		case 8:
			return 'B';
		case 7:
			return 'C';
		case 6:
		case 5:
			return 'D';
		default: // 5 밑으로 
			return 'F';
		}
	}

}
