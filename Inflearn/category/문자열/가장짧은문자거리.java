/* 문제 내용
* 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력.
* [입력 예제] teachermode e
* [출력 예제] 1 0 1 2 1 0 1 2 2 1 0
 * */

public class Main {
    public int[] solution(String s, char t){
        int[] ans = new int[s.length()];
        int p = 1000; // 문자열의 길이는 100을 넘지 않으므로 사용되지 않을 숫자로 초기화
        for(int i=0; i<s.length(); i++){ // 앞에서 부터 거리 측정
            if(s.charAt(i)==t) {
                p=0; // 주어진 문자 t와 같으면 자기 자신이므로 0으로 거리 초기화
                ans[i]=p;
            } else {
                p++;
                ans[i]=p;
            }
        }
        p= 1000; // 뒤에서부터 다시 확인하기 위해 초기화
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i)==t) p=0; // 주어진 문자 t와 같으면 0으로 거리 초기화
            else {
                p++;
                ans[i]=Math.min(ans[i], p); // 앞에서부터 잰 거리와 뒤에서부터 잰 거리 중 최소
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str=kb.next();
        char c = kb.next().charAt(0);
        for(int x : T.solution(str, c)){
            System.out.print(x+" ");
        }
    }
}
