import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        HashMap<String, String> map = new HashMap<>();
        map.put("Enter", "들어왔습니다.");
        map.put("Leave", "나갔습니다.");
        
        ArrayDeque<String[]> q = new ArrayDeque<>();
        for (String r : record){
            String[] str = r.split(" ");
            String status = str[0];
            String id = str[1];
            String nick = "";
            
            switch(status){
                case "Change":
                    nick = str[2];
                    map.put(id, nick);
                    break;
                case "Enter":
                    nick = str[2];
                    map.put(id, nick);
                    q.offer(new String[] {id, map.get(status)});
                    break;
                case "Leave":
                    q.offer(new String[] {id, map.get(status)});
                    break;
            }
        }
        ArrayList<String> list = new ArrayList<>();
            
            while(!q.isEmpty()){
                String[] temp = q.poll();
                String st = map.get(temp[0]) + "님이 "+ temp[1];
                list.add(st);
            }
            int size = list.size();
            answer = new String[size];
            for (int i=0; i<size; i++){
                answer[i] = list.get(i);
            }
        return answer;
    }
}