import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes){
            if (map.containsKey(cloth[1])){
                map.put(cloth[1], map.get(cloth[1])+1);
            } else {
                map.put(cloth[1], 1);
            }
        }
        int result = 1;
        for (int val : map.values()){
            result *= (val + 1);
        }
        answer = result -1;
        return answer;
    }
}