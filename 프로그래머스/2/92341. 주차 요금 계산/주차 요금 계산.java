import java.util.*;
class Solution {
    static class Data{
        String car;
        int fee;
        private Data(String car, int fee){
            this.car = car;
            this.fee = fee;
        }
    }
    static HashMap<String, String> totalTime = new HashMap<>();
    static HashMap<String, Integer> totalMin = new HashMap<>();
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        ArrayList<String> result = new ArrayList<>();
        
        for (String record : records){
            String[] str = record.split(" ");
            String status = str[2];
            String car = str[1];
            String time = str[0];
            
            if ("IN".equals(status)){
                totalTime.put(car, time); // 주차장에 IN
            } else { //주차장에서 OUT
                int m = calMin(car,time);
                totalMin.put(car, m);
                totalTime.remove(car);
            }
        }
        // 주차장에 남아있는 차량들은 23:59분 OUT
        if (totalTime.size() != 0){
            for (Map.Entry<String, String> entry : totalTime.entrySet()){
                String car = entry.getKey();
                int m = calMin(car,"23:59");
                totalMin.put(car, m);
            }
        }
        
        // 주차 요금 계산
        for (Map.Entry <String, Integer> entry : totalMin.entrySet()){
            int min = entry.getValue();
            int total = fees[1]; //기본 요금 할당
            int btime = fees[0]; //기본시간
            
            if (min > btime){
                System.out.println(min);
                total += Math.ceil((double)(min - btime) /fees[2]) * fees[3];
                
            }
            totalMin.put(entry.getKey(), total);
            result.add(entry.getKey());
        }
        
        Collections.sort(result);
        answer = new int[result.size()];
        for (int i=0; i<result.size(); i++){
            String car = result.get(i);
            answer[i] = totalMin.get(car);
        }
        
        return answer;
    }
    
    public int calMin(String car, String time){
        String[] out = time.split(":"); // 06 30
        String[] in = totalTime.get(car).split(":"); // 05 50

        int h = (Integer.parseInt(out[0]) - Integer.parseInt(in[0])) * 60;
        int m = (Integer.parseInt(out[1]) - Integer.parseInt(in[1])); // -20
        m += h;
        if (totalMin.get(car) != null){
            m += totalMin.get(car);
        }
        return m;
    }
}