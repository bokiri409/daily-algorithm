package Programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/*
 * 2021.09.27 daily algo/commit
 * 
 * 문제를 잘 읽을 것★★★★★
 * lines[i] - seconds[i] : 시작시점
 * lines[i] : 종료시점
 * 
 * 처리량이 변하는 1. 시작시점, 2. 종료시점 두가지만 비교해서 n*n번 비교해서 구할 수 있다.
 * simpleDateFormat으로 millisecond로 시간 차이를 계산한다.
 * getTime() 메소드는 해당 날짜가 1970년 1월 1일 00:00:00시 부터 얼마나 지났는지를 리턴한다. (그 이전시간은 음수 리턴)
 */

public class prg_L3_추석트래픽 {
	
	static String[] lines = {"2016-09-15 20:59:57.421 0.351s",
			"2016-09-15 20:59:58.233 1.181s",
			"2016-09-15 20:59:58.299 0.8s",
			"2016-09-15 20:59:58.688 1.041s",
			"2016-09-15 20:59:59.591 1.412s",
			"2016-09-15 21:00:00.464 1.466s",
			"2016-09-15 21:00:00.741 1.581s",
			"2016-09-15 21:00:00.748 2.31s",
			"2016-09-15 21:00:00.966 0.381s",
			"2016-09-15 21:00:02.066 2.62s"}; // 오름차순 정렬
	
//	static String[] lines = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};

	public static void main(String[] args){
		System.out.println(solution(lines));
	}
	
	public static int solution(String[] lines){
        int answer = 0;
        long[] times = new long[lines.length];
        long[] seconds = new long[lines.length];
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        for(int i=0; i<lines.length; i++) { // 시작 시점, 처리 시간 나누기
        	try {
				times[i] = dateFormat.parse(lines[i].substring(0, 23)).getTime();
				seconds[i] = (long) (Double.parseDouble(lines[i].substring(24, lines[i].length()-1)) * 1000);
			} catch (ParseException e) {
				e.printStackTrace();
			}
        }
        
        long start_startTime, end_endTime, start_endTime, end_startTime; // 기준 시점 변수
        long start, end; // 비교 시점 변수
        long milli = 1;
        long sec = 1000;
        for(int i=0; i<lines.length; i++) {
        	// 기준시점
        	start_startTime = times[i] - seconds[i] + milli; // 시작시점
        	end_startTime = start_startTime + sec; // 시작시점 + 1초
        	start_endTime = times[i]; // 종료시점
        	end_endTime = start_endTime + sec; // 종료시점 + 1초
        	
        	int start_max = 0;
        	int end_max = 0;
        	for(int j=0; j<lines.length; j++) {
    			// 비교시점
    			start = times[j] - seconds[j] + milli;
    			end = times[j];
        		
    			// 1. 시작시간 기점
    			if((start_startTime <= start && start < end_startTime) || (start_startTime <= end && end < end_startTime) || (start_startTime >= start && end_startTime < end)) { // 겹치면
    				start_max += 1;
    			}
    			
    			// 2. 종료시간 기점
    			if((start_endTime <= start && start < end_endTime) || (start_endTime <= end && end < end_endTime) || (start_endTime >= start && end_endTime < end)) {
    				end_max += 1;
    			}
        	}
        	
        	if(Math.max(start_max, end_max) > answer) {
        		answer = Math.max(start_max, end_max);
        	}
        }
        
        return answer;
    }

}
