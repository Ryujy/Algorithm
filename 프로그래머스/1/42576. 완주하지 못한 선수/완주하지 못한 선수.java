import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (String part : participant){
            if (map.containsKey(part)){
                int cnt = map.get(part)+1;
                map.put(part, cnt);
            } else {
                map.put(part, 1);
            }
        }
        for (String com : completion){
            int val = map.get(com);
            if (val > 1){
                map.put(com, val-1);
            } else {
                map.remove(com);   
            }
        }
        
        for (String key: map.keySet()){
            answer = key;
        }
        return answer;
    }
}