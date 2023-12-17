class Solution {
    static long cnt;
    public long solution(int n) {
        cnt = 0;
        
        if (n == 1) return 1;
        if (n == 2) return 2;
        long[] dp = new long[n+1];
        dp[1] = 1L;
        dp[2] = 2L;
        dp[3] = 3L;
        
        for (int i=4; i<n+1; i++){
                dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
            
        }
        return dp[n];
    }
}