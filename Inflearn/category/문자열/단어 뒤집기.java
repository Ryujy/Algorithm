import java.util.*;
class Main {	
	public ArrayList<String> solution(int n, String[] str){
		ArrayList<String> answer=new ArrayList<>(); 
		for(String x : str){
			String tmp=new StringBuilder(x).reverse().toString();   // ***** StringBuilder 뒤집기
			answer.add(tmp);
		}
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		String[] str=new String[n];
		for(int i=0; i<n; i++){
			str[i]=kb.next();
		}
		for(String x : T.solution(n, str)){
			System.out.println(x);
		}
	}
}



import java.util.*;
class Main {	
	public ArrayList<String> solution(int n, String[] str){
		ArrayList<String> answer=new ArrayList<>(); 
		for(String x : str){
			char[] s=x.toCharArray();                                // 문자열 -> 문자 배열
			int lt=0, rt=x.length()-1;                               // 왼쪽 idx, 오른쪽 idx 하나씩 교환
			while(lt<rt){                                            // 왼쪽 idx가 오른쪽 idx 보다 작은 동안
				char tmp=s[lt];
				s[lt]=s[rt];
				s[rt]=tmp;
				lt++;
				rt--;
			}
			String tmp=String.valueOf(s);
			answer.add(tmp);
		}
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		String[] str=new String[n];
		for(int i=0; i<n; i++){
			str[i]=kb.next();
		}
		for(String x : T.solution(n, str)){
			System.out.println(x);
		}
	}
}


