package Programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/*
 * 2021.09.27 daily algo/commit
 * 
 * ������ �� ���� �͡ڡڡڡڡ�
 * lines[i] - seconds[i] : ���۽���
 * lines[i] : �������
 * 
 * ó������ ���ϴ� 1. ���۽���, 2. ������� �ΰ����� ���ؼ� n*n�� ���ؼ� ���� �� �ִ�.
 * simpleDateFormat���� millisecond�� �ð� ���̸� ����Ѵ�.
 * getTime() �޼ҵ�� �ش� ��¥�� 1970�� 1�� 1�� 00:00:00�� ���� �󸶳� ���������� �����Ѵ�. (�� �����ð��� ���� ����)
 */

public class prg_L3_�߼�Ʈ���� {
	
	static String[] lines = {"2016-09-15 20:59:57.421 0.351s",
			"2016-09-15 20:59:58.233 1.181s",
			"2016-09-15 20:59:58.299 0.8s",
			"2016-09-15 20:59:58.688 1.041s",
			"2016-09-15 20:59:59.591 1.412s",
			"2016-09-15 21:00:00.464 1.466s",
			"2016-09-15 21:00:00.741 1.581s",
			"2016-09-15 21:00:00.748 2.31s",
			"2016-09-15 21:00:00.966 0.381s",
			"2016-09-15 21:00:02.066 2.62s"}; // �������� ����
	
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
        for(int i=0; i<lines.length; i++) { // ���� ����, ó�� �ð� ������
        	try {
				times[i] = dateFormat.parse(lines[i].substring(0, 23)).getTime();
				seconds[i] = (long) (Double.parseDouble(lines[i].substring(24, lines[i].length()-1)) * 1000);
			} catch (ParseException e) {
				e.printStackTrace();
			}
        }
        
        long start_startTime, end_endTime, start_endTime, end_startTime; // ���� ���� ����
        long start, end; // �� ���� ����
        long milli = 1;
        long sec = 1000;
        for(int i=0; i<lines.length; i++) {
        	// ���ؽ���
        	start_startTime = times[i] - seconds[i] + milli; // ���۽���
        	end_startTime = start_startTime + sec; // ���۽��� + 1��
        	start_endTime = times[i]; // �������
        	end_endTime = start_endTime + sec; // ������� + 1��
        	
        	int start_max = 0;
        	int end_max = 0;
        	for(int j=0; j<lines.length; j++) {
    			// �񱳽���
    			start = times[j] - seconds[j] + milli;
    			end = times[j];
        		
    			// 1. ���۽ð� ����
    			if((start_startTime <= start && start < end_startTime) || (start_startTime <= end && end < end_startTime) || (start_startTime >= start && end_startTime < end)) { // ��ġ��
    				start_max += 1;
    			}
    			
    			// 2. ����ð� ����
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
