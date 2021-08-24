package Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * 2021.08.24 daily algo/commit
 * 
 * 프로그래머스 Level 2 - 오픈채팅방
 * HashMap으로 풀어서 간단하게 key에대한 value체크해서 값 변경하기
 * 각각의 order에 대해 미리 hashmap을 작성한 뒤 enter와 leave에 대해서만 출력값을 더해주면 된다.
 * 
 * 참고자료 : https://sublivan.tistory.com/51
 * hashmap에 대한 자료 : https://kkh0977.tistory.com/42
 */

public class prg_openChatting {
	
	static String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
//	static ArrayList<String[]> userIds = new ArrayList<String[]>();
	static HashMap<String, String> userInfo = new HashMap<String, String>();
	static ArrayList<String> result = new ArrayList<String>();
	
	static String userId;
	static String nickName;

	public static void main(String[] args) {
		System.out.println(solution(record));
	}
	
	public static ArrayList<String> solution(String[] record) {
		StringTokenizer st;
		for(int i=0; i<record.length; i++) {
			st = new StringTokenizer(record[i]);
			String order = st.nextToken();
			userId = st.nextToken();
			
			switch (order) {
			case "Enter": // 입장 명령어 일 때
				nickName = st.nextToken();
				if(!isVisited(userId)) { // 해당 아이디가 방문 기록이 없다면
//					userIds.add(new String[] {userId, nickName});
					userInfo.put(userId, nickName);
				}
				else { // 방문 기록이 있다면
//					change(userId, nickName);
					userInfo.replace(userId, nickName);
				}
//				result.add(new String[] {nickName+"님이 들어왔습니다.", userId});
				break;
			case "Leave":
//				result.add(new String[] {leave(userId)+"님이 나갔습니다.", userId});
//				result.add(new String[] {userInfo.get(userId)+"님이 나갔습니다.", userId});
				break;
			case "Change":
				nickName = st.nextToken();
//				change(userId, nickName);
				userInfo.replace(userId, nickName);
				break;
			}
		}
		
		for(int i=0; i<record.length; i++) {
			st = new StringTokenizer(record[i]);
			String order = st.nextToken();
			String id = st.nextToken();
			if(order.equals("Enter")) {
				result.add(userInfo.get(id) + "님이 들어왔습니다.");
			}
			if(order.equals("Leave")) {
				result.add(userInfo.get(id) + "님이 나갔습니다.");
			}
		}
		
//		String[] answer = new String[result.size()];
//		for(int j=0; j<answer.length; j++) {
//			answer[j] = result.get(j)[0];
//		}
		
        return result;
    }
	
	private static boolean isVisited(String id) { // 방문 여부 검사
//		for(int i=0; i<userIds.size(); i++) {
//			if(userIds.get(i)[0].equals(id)) { // 아이디 방문 했을 때
//				return true;
//			}
//		}
		if(userInfo.containsKey(id)) {
			return true;
		}
		else {
			return false;
		}
	}
	
//	private static String leave(String id) {
//		String name = null;
//		for(int i=0; i<userIds.size(); i++) {
//			if(userIds.get(i)[0].equals(id)) {
//				name = userIds.get(i)[1]; // 해당 아이디의 닉네임
//				break;
//			}
//		}
//		return userInfo.get(id);
//	}
	
//	private static void change(String id, String newNickName) {
//		
//		
//		String oldNickName = "";
//		for(int i=0; i<userIds.size(); i++) {
//			if(userIds.get(i)[0].equals(id)) {
//				oldNickName = userIds.get(i)[1];
//				userIds.get(i)[1] = newNickName; // 닉네임 변경
//				break;
//			}
//		}
//		
//		for(int i=0; i<result.size(); i++) {
//			if(result.get(i)[1].equals(id)) {
//				result.get(i)[0] = result.get(i)[0].replace(oldNickName, newNickName);
//			}
//		}
		
//		String name = null;
//		for(int i=0; i<userIds.size(); i++) {
//			if(userIds.get(i)[0].equals(id)) {
//				name = userIds.get(i)[1]; // 해당 아이디의 닉네임
////				userIds.set(i, userIds.get(i)[1].replaceAll(".", nickname));
//				userIds.get(i)[1] = nickname;
//				return name;
//			}
//		}
//		return "0"; // 존재 안할 때
//	}

}
