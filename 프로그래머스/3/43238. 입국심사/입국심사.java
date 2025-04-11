import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        // 특정 시간 동안 몇 명을 심사할 수 있는가??
        // mid 시간 동안 각 심사관이 처리 가능한 인원
        // -> n명을 모두 처리가능한 mid 시간으로 좁혀가기 (이분 탐색)
        // 1. mid 시간 구하기
        int size = times.length;
        Arrays.sort(times);
        
        long left = times[0];
        long right = (long)times[size-1] * n;
        while(left <= right){
            long mid = (left + right)/2;
             // 2. 각 심사관별 처리 가능한 인원 구하기 => 총 처리 가능 인원
            long cnt = 0;
            for (int i=0; i<size; i++){
                cnt += mid/times[i];
            }

            if (cnt < n) {
                // 3-1. n명보다 적으면 mid 시간 늘리기
                left = mid+1;
            } else if (cnt >= n){
                // 3-2. n명보다 크거나 같으면 일단 현재 값 저장하고, mid 시간 줄이기
                answer = mid;
                right = mid -1;
            }
        }
        return answer;
    }
}