import java.util.*;

class Solution {
    static class Data {
        char type;
        int score;
        public Data(char type, int score){
            this.type = type;
            this.score = score;
        }
    }
    public String solution(String[] survey, int[] choices) {
        int[] scores = {0, 3, 2, 1, 0, 1, 2, 3}; // 선택지 별 점수
        Map<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
        
        for (int i=0; i<survey.length; i++){
            String str = survey[i]; //str.charAt(0)
            
            char s = ' ';
            if (choices[i] > 4){
                s = str.charAt(1); //유형
            } else {
                s = str.charAt(0);
            }
            int sc = map.get(s); //점수 가져오기
            map.replace(s, sc+scores[choices[i]]);
        }
        
        Iterator<Map.Entry<Character, Integer>> iter = map.entrySet().iterator();
        
        String answer = "";
        ArrayList<Data> list = new ArrayList<>();
        
        if (map.get('R') >= map.get('T')){
            list.add(new Data('R', map.get('R')));
        } else {
            list.add(new Data('T', map.get('T')));
        }
        if (map.get('C') >= map.get('F')){
            list.add(new Data('C', map.get('C')));
        } else {
            list.add(new Data('F', map.get('F')));
        }
        if (map.get('J') >= map.get('M')){
            list.add(new Data('J', map.get('J')));
        } else {
            list.add(new Data('M', map.get('M')));
        }
        if (map.get('A') >= map.get('N')){
            list.add(new Data('A', map.get('A')));
        } else {
            list.add(new Data('N', map.get('N')));
        }
        
//         while(iter.hasNext()){
//             Map.Entry<Character, Integer> first = iter.next(); //A, C, ...
//             Map.Entry<Character, Integer> second = iter.next(); //N, F, ...
            
//             if (first.getValue() >= second.getValue()){
//                 System.out.println("f"+first.getKey() + second.getKey());
//                 list.add(new Data (first.getKey(), first.getValue()));
//             } else {
//                 System.out.println(second.getKey());
//                 list.add(new Data(second.getKey(), second.getValue()));
//             }
//         }
        
        // Collections.sort(list, new Comparator<Data>() {
        //     @Override
        //     public int compare(Data o1, Data o2){
        //         return o2.score - o1.score;
        //     }
        // });
        
        for (Data cur : list){
            answer += cur.type;
        }
        return answer;
    }
}