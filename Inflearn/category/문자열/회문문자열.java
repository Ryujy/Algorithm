/*
 회문 문자열 : 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열
 이 문제에서는 회문 검사할 때 대소문자 구분하지 않음.
*/

import java.util.*;
class Main {	
	public String solution(String str){
		String answer="YES";
		str=str.toUpperCase();
		int len=str.length();
		for(int i=0; i<len/2; i++){                             // 앞,뒤로 같은지 비교하므로 i가 len/2까지. 짝홀 상관 X
			if(str.charAt(i)!=str.charAt(len-i-1)) answer="NO";   // 비교
		}
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.print(T.solution(str));
	}
}



import java.util.*;
class Main {	
	public String solution(String str){
		String answer="NO";
		String tmp=new StringBuilder(str).reverse().toString();    // 전체 뒤집어서 같은지 확인
		if(str.equalsIgnoreCase(tmp)) answer="YES";
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.print(T.solution(str));
	}
}
