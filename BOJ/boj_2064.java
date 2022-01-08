package BOJ;

import java.util.Scanner;

/*
 * 2021.01.08 daily algo/commit
 * 
 * simulation
 * 주어진 ip주소들을 먼저 2진수로 변환한 뒤, 모두 비교하면서 공통 부분을 찾고
 * 네트워크 주소와 네트워크 마스크를 각각 구해준다.
 */

public class boj_2064 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] ip = new int[n][32];
		for(int i=0; i<n; i++) {
			String address = sc.next();
			int num = 0;
			int dot = -1;
			int level = 0;
			for(int j=0; j<address.length(); j++) {
				if(address.charAt(j) == '.') {
					num = Integer.parseInt(address.substring(dot+1, j));
					level += 1;
					transfer(i, num, ip, level);
					dot = j;
				}
				if(j == address.length()-1) {
					num = Integer.parseInt(address.substring(dot+1, j+1));
					level += 1;
					transfer(i, num, ip, level);
				}
			}
		}
		sc.close();
		
		int idx = 31; // 공통 부분까지의 인덱스
		loop:
		for(int i=0; i<32; i++) {
			for(int j=0; j<n-1; j++) {
				if(ip[j][i] != ip[j+1][i]) {
					idx = i-1;
					break loop;
				}
			}
		}
		
		System.out.println(idx);
		
		// network address, network mask 주소 
		String netA = "", netM = "";
		int numA = 0;
		int numM = 0;
		for(int i=0; i<32; i++) {
			if(i % 8 == 7 && i < 31) {
				if(i <= idx) {
					if(ip[0][i] == 1) numA += Math.pow(2, 7-i%8);
					numM += Math.pow(2, 7-i%8);
				}
				netA += numA + ".";
				netM += numM + ".";
				numA = 0; // 초기화
				numM = 0; // 초기화
			}
			else {
				if(i <= idx) {
					if(ip[0][i] == 1) numA += Math.pow(2, 7-i%8);
					numM += Math.pow(2, 7-i%8);
				}
			}
		}
		netM += numM;
		netA += numA;
		System.out.println(netA);
		System.out.println(netM);
	}

	public static void transfer(int idx, int num, int[][] ip, int level) {
		int i = level * 8 - 1;
		while(num >= 2) {
			ip[idx][i] = num % 2;
			num /= 2;
			i -= 1;
		}
		ip[idx][i] = num;
		if(i % 8 != 0) {
			i -= 1;
			ip[idx][i] = 0;
		}
	}
}
