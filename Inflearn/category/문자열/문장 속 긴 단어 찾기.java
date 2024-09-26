/*
한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어 출력
*/
import java.util.*;

// 1번 방법 : split(" ") 활용
class Main {	
	public String solution(String str){
		String answer="";
		int m=Integer.MIN_VALUE;           // 최대 길이 갱신용
		String[] s = str.split(" ");
		for(String x : s){
			int len=x.length();
			if(len>m){                       // 이전 단어(m)와 길이 비교
				m=len;                         // 현재 단어가 더 긴 경우 m에 저장
				answer=x;
			}
		}
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.nextLine();
		System.out.print(T.solution(str));
	}
}


// 2번 방법 : substring(s, e) 활용
class Main {	
	public String solution(String str){
		String answer="";
		int m=Integer.MIN_VALUE, pos;         // 변수 m, pos
		while((pos=str.indexOf(' '))!=-1){    // 공백이 -1이 아니라면 다음 단어가 있음
			String tmp=str.substring(0, pos);   // pos = 공백, 단어 추출
			int len=tmp.length();
			if(len>m){
				m=len;
				answer=tmp;
			}
			str=str.substring(pos+1);            // 다음 단어 시작점부터 끝까지
		}
		if(str.length()>m) answer=str;         // ********* 마지막 단어는 while문에서 처리하지 못하므로 필요
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.nextLine();
		System.out.print(T.solution(str));
	}
}
