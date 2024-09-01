import java.util.*;
class Solution { // 5. 최대길이 바이토닉 수열
    public int solution(int[] nums){
        int n = nums.length;
        int answer = 0;
        ArrayList<Integer> peaks = new ArrayList<>();
        
        // 봉우리 찾기
        int p = 0;
        for (int i=1; i<n-1; i++){
            int cur = nums[i];
            int prev = nums[i-1];
            int next = nums[i+1];

            if (cur > prev && cur > next){ /* 봉우리 조건 잘 생각하기 */
                peaks.add(i);
            }
        }

        // 봉우리 양 옆으로 감소 수열 카운트
        for (int x : peaks){
            int cnt = 1; /* 봉우리 카운트하고 시작 */
            int left = x;
            int right = x;
            while(left-1 >= 0 && nums[left-1] < nums[left]){
                cnt++;
                left--;
            }
            while(right+1 < n && nums[right+1] < nums[right]){
                cnt++;
                right++;
            }
            answer = answer < cnt ? cnt : answer;

        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}
