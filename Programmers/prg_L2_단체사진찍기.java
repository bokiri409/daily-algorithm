package Programmers;

/*
 * 2021.09.09 daily algo/commit
 * 
 * DFS - 완탐으로 전체 확인한 후 조건에 맞는 개수 세기
 */

public class prg_L2_단체사진찍기 {
	
	static int n = 2;
	static String[] data = {"N~F=0", "R~T>2"};
//	static String[] data = {"M~C<2", "C~M>1"};
	static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
	static boolean[] visited = new boolean[8];
	static String picture = "";
	static int answer = 0;

	public static void main(String[] args) {
		System.out.println(solution(n, data));
	}
	
	public static int solution(int n, String[] data) {
		answer = 0;
        dfs(data);
        return answer;
    }
	
	private static void dfs(String[] data) {
		if(picture.length() == 8) { // 모두 줄 세웠을 때 종료
			if(check(data, picture)) {
				answer++;
			}
			return;
		}
		
		for(int i=0; i<8; i++) {
			if(!visited[i]) {
				visited[i] = true;
				picture += friends[i];
				dfs(data);
				visited[i] = false; // 돌아온 후 방문체크 해제
				picture = picture.substring(0, picture.length()-1); // 단어 추가도 삭제
			}
		}
	}

	private static boolean check(String[] data, String picture) {
		for(String datum : data) {
			int f1 = picture.indexOf(datum.charAt(0)); //프렌즈 1
			int f2 = picture.indexOf(datum.charAt(2)); //프렌즈 2
			
			char op = datum.charAt(3); // 계산
			int distance = datum.charAt(4) - '0';
			
			if(op == '=') { // 같을 때 
				if(Math.abs(f1-f2) != distance+1) return false;
			}
			else if(op == '<') {
				if(Math.abs(f1-f2) >= distance+1) return false;
			}
			else {
				if(Math.abs(f1-f2) <= distance+1) return false;
			}
		}
		return true;
	}
}
