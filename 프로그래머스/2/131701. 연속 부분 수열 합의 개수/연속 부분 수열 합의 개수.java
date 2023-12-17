import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        TreeSet<Integer> ts = new TreeSet<>();
        int len = elements.length;
        
        for (int i=0; i<len*2; i++){
            int sum = 0;
            for (int j=i; j<i+len; j++){ // 1~len
                sum += elements[j%len];
                ts.add(sum);
            }
        }
        
        return ts.size();
    }
}