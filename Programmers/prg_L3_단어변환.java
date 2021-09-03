package Programmers;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 2021.08.30 daily algo/commit
 * 
 * DFS는 가능한 모든 탐색을 깊이 우선으로 탐색하기 때문에 
 * BFS를 활용하여 가장 깊이가 얕은 탐색부터 하고 답을 찾으면 탐색을 마치도록 한다.
 * => visited로 방문 체크를 한다. 어차피 최단 depth를 찾는 거기 때문에 모든 경우는 볼 필요가 없다.
 * 
 * 참고 : https://real-012.tistory.com/202
 */

public class prg_L3_단어변환 {
	
	static String begin = "hit";
	static String target = "cog";
	static String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
	static boolean[] visited;

	public static void main(String[] args) {
		System.out.println(solution(begin, target, words));
	}
	
	public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        if(checked(target, words)) { // words안에 존재할 때
        	answer = bfs(begin, target, words);
        }
        else {
        	answer = 0;
        }
        
        return answer;
    }
	
	static boolean checked(String target, String[] words) {
		for(int i=0; i<words.length; i++) {
			if(target.equals(words[i])) { // 존재하면 true 반환
				return true;
			}
		}
		return false;
	}
	
	private static int bfs(String begin, String target, String[] words) {
		Queue<Word> q = new LinkedList<Word>();
		visited = new boolean[words.length];
		
		q.offer(new Word(begin, 0));
		while(!q.isEmpty()) {
			Word curWord = q.poll();
			
			for(int i=0; i<words.length; i++) {
				if(!visited[i]) {
					int cnt = 0;
					for(int j=0; j<words[i].length(); j++) {
						if(curWord.word.charAt(j) != words[i].charAt(j)) {
							cnt++;
							if(cnt > 1) break; // 다른 알파벳이 2개 이상일 때
						}
					}
					if(cnt == 1) {  // 단어 변환 가능할 때
						if(words[i].equals(target)) {
							return curWord.depth+1;
						}
						q.offer(new Word(words[i], curWord.depth+1));
						visited[i] = true;
					}
				}
				
			}
		}
		return 0;
	}
	
	private static class Word{
		String word;
		int depth;
		
		Word(String word, int depth){
			this.word = word;
			this.depth = depth;
		}
	}
	
}
