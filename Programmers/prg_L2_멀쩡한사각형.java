package Programmers;

/*
 * 2021.02.14 daily algo/commit
 */

public class prg_L2_멀쩡한사각형 {
	
	static int w = 8;
	static int h = 12;

	public static void main(String[] args) {
		System.out.println(solution(w, h)); 
	}
	
	public static long solution(int w, int h) {
        long answer = 1;
        
        double x = 1 , y = 1;
        double gradient = (double) h / w;
        while(true) {
        	if(x / y == gradient) {
        		answer *= (w / y);
        		break;
        	}
        	else if(x / y < gradient) { // 기울기 작을 때
        		x += 1;
        		answer += 1;
        	}
        	else if(x / y > gradient) {
        		y += 1;
        		answer += 1;
        	}
        }
        
        return (long)w*h - answer;
    }

}
