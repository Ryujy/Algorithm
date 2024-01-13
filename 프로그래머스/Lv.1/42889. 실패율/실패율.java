import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        double[] answer = new double[N];
        int[] result = new int[N];
        int n = stages.length; // 사용자 수

        HashMap<Integer, Integer> map = new HashMap<>(); //스테이지 : 도전중
        
        for (int i = 0; i<n; i++){
            if (map.get(stages[i]) == null){
                map.put(stages[i], 1);
            } 
            else if (map.get(stages[i]) > 0){
                int num = map.get(stages[i]);
                map.put(stages[i], num+1);
            }
        }
        int user, clear = n;
        double fail;
            
        for (int j=1; j<N+1; j++){
            if (map.get(j) == null){
                user = 0;
            } else {
                user = map.get(j);   
            }
            
            if(clear == 0)
                fail = 0;
            else
                fail = 1.0 * user / clear;
            clear = clear - user;
            answer[j-1] = fail;
        }
        ArrayList<double[]> list = new ArrayList<>();
        for (int i=0; i<N; i++){
            list.add(new double[] {answer[i], i+1}); // 실패율, 스테이지 번호
        }
        
        Collections.sort(list, (o1, o2) -> Double.compare(o2[0], o1[0]));
        
        for (int i=0; i<N; i++){
            result[i] = (int)list.get(i)[1];
        }
        return result;
    }
}