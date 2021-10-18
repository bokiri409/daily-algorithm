package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
 * 2021.10.16 daily algo/commit
 * 
 * Programmers weekly 10 - ����
 */

public class prg_week10_������������� {
	
//	static int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
//	static int[][] line = {{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};
	static int[][] line = {{1, -1, 0}, {2, -1, 0}};
	
	static HashSet<int[]> points = new HashSet<int[]>();
	static int[] point; // ����

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(line)));
	}
	
	public static String[] solution(int[][] line) {
        for(int i=0; i<line.length-1; i++) {
        	for(int j=i+1; j<line.length; j++) {
        		intersection(i, j, line);
        	}
        }
        // hashset�� points�� list�� ��ȯ
        ArrayList<int[]> pointsList = new ArrayList<int[]>(points);
//        Collections.sort(pointsList, (o1, o2) -> (o1[1]-o2[1])); // �������迭�� ����� ������ �ʿ� ����.
        
        int x_max = Integer.MIN_VALUE; // �ּҰ� 0�� �ƴϴ�
        int x_min = Integer.MAX_VALUE;
        int y_max = Integer.MIN_VALUE;
        int y_min = Integer.MAX_VALUE;
        for(int i=0; i<pointsList.size(); i++) {
        	// x�ִ� �ּ� ���ϱ�
        	if(x_max < pointsList.get(i)[0]) {
        		x_max = pointsList.get(i)[0];
        	}
        	if(x_min > pointsList.get(i)[0]) {
        		x_min = pointsList.get(i)[0];
        	}
        	
        	// y�ִ� �ּ� ���ϱ�
        	if(y_max < pointsList.get(i)[1]) {
        		y_max = pointsList.get(i)[1];
        	}
        	if(y_min > pointsList.get(i)[1]){
        		y_min = pointsList.get(i)[1];
        	}
        }
        System.out.println("x: "+x_max+" "+x_min);
        System.out.println("y: "+y_max+" "+y_min);
        
        for(int i=0; i<pointsList.size(); i++) {
        	System.out.println(Arrays.toString(pointsList.get(i)));
        }
        
        String[][] result = new String[Math.abs(y_max - y_min)+1][Math.abs(x_max - x_min)+1];
        for(int i=0; i<result.length; i++) {
        	for(int j=0; j<result[0].length; j++) {
        		result[i][j] = ".";
        	}
        }
        for(int i=0; i<pointsList.size(); i++) {
        	result[pointsList.get(i)[1]-y_min][pointsList.get(i)[0]-x_min] = "*";
        }
        
        String[] answer = new String[result.length];
        for(int i=0; i<answer.length; i++) {
        	answer[i] = "";
        }
        for(int i=result.length-1; i>=0; i--) {
        	for(int j=0; j<result[0].length; j++) {
        		System.out.print(result[i][j]);
        		answer[result.length-1-i] += result[i][j];
        	}
        	System.out.println();
        }
        
        return answer;
    }
    
    // ���� ã��
	public static void intersection(int x, int y, int[][] line){
		point = new int[2];
		long deno = (long) line[x][0] * (long) line[y][1] - (long) line[x][1] * (long) line[y][0]; // �и�
		if(deno != 0) { // ������ ���� ��
			long numer1 = (long) line[x][1] * (long) line[y][2] - (long) line[x][2] * (long) line[y][1]; // BF-ED
			long numer2 = (long) line[x][2] * (long) line[y][0] - (long) line[x][0] * (long) line[y][2]; // EC-AF
			if(numer1 % deno != 0 || numer2 % deno != 0) return; // ������ �ƴϸ� �Ѿ��
			point[0] = (int) (numer1 / deno); // BF-ED / deno
			point[1] = (int) (numer2 / deno); // EC-AF / deno
			points.add(point);
		}
    }

}
