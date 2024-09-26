import java.util.*;
class Main {	
	public String solution(String str){
		String answer="";
		for(int i=0; i<str.length(); i++){
			//System.out.println(str.charAt(i)+" "+i+" "+str.indexOf(str.charAt(i)));   // 문자 순서, 해당 문자 중 최초의 인덱스
			if(str.indexOf(str.charAt(i))==i) answer+=str.charAt(i);                    

      /*
      str = ksekkset
      char c = str.charAt(i) 는 ksekkset 에서 차례로 'k', 's', 'e', 'k', ... 
      str.indexOf(c) 는 'k', 's', 'e', 'k', ... 의 index
      따라서 이 index와 반복문의 i가 같으면 같은 문자 중 가장 첫 번째 문자 (첫 번째 'k')
      이 index와 반복문의 i가 다르면 같은 문자 중 다른 순서의 문자. 즉, 이 문자가 중복되었다 = 이미 나왔다 = 이미 채택했다.. 등
      */
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
