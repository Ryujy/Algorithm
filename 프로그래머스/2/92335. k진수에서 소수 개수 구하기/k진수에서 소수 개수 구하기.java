import java.util.*;
class Solution {
    static boolean[] prime;
    public int solution(int n, int k) {
        int answer = 0;
        String str = Integer.toString(n, k);
        String[] pn = str.split("0");
        
        for (String p : pn){
            if (p.equals("")) continue;
            long num = Long.parseLong(p);
            if (isPrime(num)){ //소수면
                answer++;
            }
        }
        return answer;
    }
    
    private static boolean isPrime(long num){ //소수판별 함수
        if (num == 1) return false;
        for (long i=2; i<=Math.sqrt(num); i++){
                if (num % i == 0){ //소수가 아님
                    return false;
                }
        }
        return true;
    }
}