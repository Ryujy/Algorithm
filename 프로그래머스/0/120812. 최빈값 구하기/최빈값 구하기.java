class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int[] nums = new int[1000];
        
        for (int n : array){
            nums[n]++;
        }
        
        int max = -1;
        for(int i=0; i<1000; i++){
            if(nums[i]==0) continue;
            if(nums[i]>max){
                max = nums[i];
                answer = i;
            }
        }
        
        for(int n : array){
            if(n==answer) continue;
            if(nums[n] == max){
                answer = -1;
                break;
            }
        }
        return answer;
    }
}