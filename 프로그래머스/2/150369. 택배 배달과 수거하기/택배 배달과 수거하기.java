class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int didx = n-1; // 배달 idx
        int pidx = n-1; // 픽업 idx
        long answer = 0; //이동 거리
        
        while(true){
            if (didx < 0 && pidx < 0){
                break;
            }
            int d = -1;
            int p = -1;
            int bring = cap; // 상자 개수
            int pick = 0;
            while(bring > 0 && didx != -1){
                if (deliveries[didx] > 0){
                    d = d > didx ? d : didx;
                    deliveries[didx]--;
                    bring--;
                } else {
                    didx--;
                }
            }
            while(pick < cap && pidx != -1){
                if (pickups[pidx] > 0){
                    p = p > pidx ? p : pidx;
                    pickups[pidx]--;
                    pick++;
                } else {
                    pidx--;
                }
            }
            answer += Math.max(p+1, d+1) * 2;
        }
        
        return answer;
    }
}