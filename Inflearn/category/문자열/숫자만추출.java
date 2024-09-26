/*
 만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205 이 됩니다.
*/
import java.util.*;
class Main {	
	public int solution(String s){
		//int answer=0;
		String answer="";
		for(char x : s.toCharArray()){
			// 1번 방법
      //if(x>=48 && x<=57) answer=answer*10+(x-48);         // 숫자 0의 아스키코드 = 48
      /*
       x가 숫자이면, answer*10(자릿수), x-48(char형 숫자를 int형으로 변환) 를 더하여 숫자로 만듦.
      */

      // 2번 방법
      /*if(Character.isDigit(x)){                         // x가 숫자라면,
				answer=answer*10+ Character.getNumericValue(x);   // answer*10(자릿수), x-48(char형 숫자를 int형으로 변환) 를 더하여 숫자로 만듦.
			}*/

      // 3번 방법
			if(Character.isDigit(x)) answer+=x;                  // 숫자라면 answer에 붙임.
		}
		return Integer.parseInt(answer);
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.print(T.solution(str));
	}
}
