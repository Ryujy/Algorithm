import java.util.*;

class Solution {
    static boolean[] prime;
    public int solution(int n, int k) {
        int answer = 0;
        prime = new boolean[1000001];

        String[] nums = Integer.toString(n, k).split("0");
        for(String num: nums){
            if (num.equals("")) continue;
            long p = Long.parseLong(num);
            if(isPrime(p)) answer++;
        }
        return answer;
    }
    
    private static boolean isPrime(long num){
        if (num == 1) return false;
        for (int i=2; i<=Math.sqrt(num); i++){
            if (num % i == 0) return false;
        }
        return true;
    }
}