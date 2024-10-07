/* 문제 내용
 * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우
 * 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축한다.
 * 단, 반복횟수가 1인 경우 생략
 *
 * [입력예제] KKHSSSSSSSE
 * [출력예제] K2HS7E
 */

public class Main {
    public String solution(String str){
        /* SOL 1 ****************************** */
        String answer="";
        str=str+" "; // 마지막 문자까지 확인하기 위해 빈 칸 삽입
        int cnt=1;
        for(int i=0; i<str.length()-1; i++){ // 빈칸까지는 반복X
            if(str.charAt(i)==str.charAt(i+1)) cnt++;
            else{
                answer+=str.charAt(i);
                if(cnt>1) answer+=String.valueOf(cnt);
                cnt=1;
            }
        }
        return answer;

        /* SOL 2 ****************************** */
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        char p = str.charAt(0);
        sb.append(p);
        for(int i=1; i<str.length(); i++){
            char c = str.charAt(i);
            if(p==c) cnt++;
            else {
                if (cnt != 1) sb.append(cnt);
                cnt = 1;
                p = c;
                sb.append(p);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in); // 문자열의 길이는 100을 넘지 않음.
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
