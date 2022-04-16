package Programmers;

import java.util.Arrays;

public class prg_L2_거리두기확인하기 {
	
	static String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(places)));
	}
	
	public static int[] solution(String[][] places) {
        int[] answer = new int[5];
        char[][] waitingR = new char[5][5];
        for(int i=0; i<5; i++) {
        	for(int j=0; j<5; j++) {
        		for(int k=0; k<5; k++) {	
        			waitingR[j][k] = places[i][j].charAt(k);
        		}
        	}
        	// 거리두기 체크
        	answer[i] = check(waitingR);
        }
        
        return answer;
    }
	
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	
	static int[] ddx = {-2, 0, 2, 0};
	static int[] ddy = {0, 2, 0, -2};
	public static int check(char[][] waitingR) {
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(waitingR[i][j] == 'P') {
					// 대각선과 거리 1인경우
					for(int k=0; k<8; k++) {
						if(i+dx[k] < 0 || i+dx[k] >= 5 || j+dy[k] < 0 || j+dy[k] >= 5) continue;
						if(waitingR[i+dx[k]][j+dy[k]] == 'P') {
							// 거리가 1일 때
							if(Math.abs(dx[k]) + Math.abs(dy[k]) == 1) return 0;
							// 거리가 2일 때
							if(Math.abs(dx[k]) + Math.abs(dy[k]) == 2) {
								if(waitingR[i+dx[k]][j] == 'O') return 0;
								if(waitingR[i][j+dy[k]] == 'O') return 0;
							}
						}
					}
					// 가로 세로 거리 2인 경우
					for(int k=0; k<4; k++) {
						if(i+ddx[k] < 0 || i+ddx[k] >= 5 || j+ddy[k] < 0 || j+ddy[k] >= 5) continue;
						if(waitingR[i+ddx[k]][j+ddy[k]] == 'P') {
							if(waitingR[i+ddx[k]/2][j+ddy[k]/2] == 'O') return 0;
						}
					}
				}
			}
		}
		return 1;
	}
}
