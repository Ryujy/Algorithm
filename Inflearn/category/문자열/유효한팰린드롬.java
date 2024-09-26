// 회문 문자열 == 팰린드롬
// 이 문제에서는 알파벳만 가지고 회문 검사 (특수문자 제외)
import java.util.*;
class Main {	
	public String solution(String s){
		String answer="NO";
		s=s.toUpperCase().replaceAll("[^A-Z]", "");            // []:정규식, ^:not, A-Z:alphabets
    /*
     replaceAll : 대상 문자열을 원하는 문자 값으로 변환
     정규식을 통해 표현할 수 있음
    */
		String tmp=new StringBuilder(s).reverse().toString();
		if(s.equals(tmp)) answer="YES";
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.nextLine();
		System.out.print(T.solution(str));
	}
}
