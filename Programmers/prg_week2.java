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
        	boolean chk_min = true; // ����, �ְ����� 
        	double avg = 0; // ��հ�
        	int sum = 0;
        	max = scores[i][i]; // �ڱ� �ڽſ��� �� ����
        	min = scores[i][i]; // �ڱ� �ڽſ��� �� ����
        	for(int j=0; j<scores.length; j++) {
        		if(max <= scores[j][i] && i != j) {
        			chk_max = false;
        		}
        		if(min >= scores[j][i] && i != j) {
        			chk_min = false;
        		}
        		sum += scores[j][i];
        	}
        	if(chk_max || chk_min) { // ������ �ְ��� or ������ �� ��
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
		default: // 5 ������ 
			return 'F';
		}
	}

}
