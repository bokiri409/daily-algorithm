package BOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * 2022.06.01 daily algo/commit
 * 
 * Brute Force
 * 정렬을 어디서 해줘야 하는지 잘 생각해야한다.
 */

public class boj_1759 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt(); 
		int C = sc.nextInt();
		ArrayList<String> vowels = new ArrayList<String>();
		ArrayList<String> consonants = new ArrayList<String>();
		for(int i=0; i<C; i++) {
			String s = sc.next();
			if(s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u")) vowels.add(s);
			else consonants.add(s);
		}
		
		vowels.sort(Comparator.naturalOrder());
		consonants.sort(Comparator.naturalOrder());
		
		// 모음 최소 한 개 이상, 자음 최소 두 개 이상
		if(vowels.size() < 1 || consonants.size() < 2) return;
		decode(vowels, consonants, L);
		words.sort(Comparator.naturalOrder());
		for(String s : words) {
			System.out.println(s);
		}
	}

	public static void decode(ArrayList<String> vowels, ArrayList<String> consonants, int L) {
		// 자음 최소 개수
		for(int i=1; i<=vowels.size(); i++) {
			if(i+2 > L) break;
			ArrayList<String> word = new ArrayList<String>();
			// 모음 선택
			vowelChoice(vowels.size(), i, 0, vowels, consonants, word, L);
		}
	}
	
	static ArrayList<String> words = new ArrayList<String>();
	public static void vowelChoice(int n, int r, int start, ArrayList<String> vowels, ArrayList<String> consonants, ArrayList<String> word, int L) {
		if(r == 0) {
			// 자음 선택
			consonantChoice(consonants.size(), L-word.size(), 0, consonants, word);
			return;
		}
		for(int i=start; i<n; i++) {
			word.add(vowels.get(i));
			vowelChoice(n, r-1, i+1, vowels, consonants, word, L);
			word.remove(word.size()-1);
		}
	}
	
	public static void consonantChoice(int n, int r, int start, ArrayList<String> consonants, ArrayList<String> word) {
		if(r == 0) {
//			word.sort(Comparator.naturalOrder());
			String str = String.join("", word);
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			words.add(new String(arr));
			return;
		}
		for(int i=start; i<n; i++) {
			word.add(consonants.get(i));
			consonantChoice(n, r-1, i+1, consonants, word);
			word.remove(word.size()-1);
		}
	}
}
