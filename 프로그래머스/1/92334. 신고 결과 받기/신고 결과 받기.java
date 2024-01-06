import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        int size = id_list.length;
        int[] answer = new int[size];
        HashMap<String, Integer> index = new HashMap<>();
        ArrayList<Integer>[] reportList = new ArrayList[id_list.length];
        boolean[][] check = new boolean[size][size];
        for (int i=0; i<size; i++){
            index.put(id_list[i], i); // id - 번호표
            reportList[i] = new ArrayList<>(); // 인접 리스트 배열 초기화
        }
        
        for (String r : report){
            String[] tmp = r.split(" ");
            String user = tmp[0]; //사용자
            String reported = tmp[1]; //신고 당함
            
            int uidx = index.get(user); // 사용자 id의 번호표
            int ridx = index.get(reported); // 신고 당한 id의 번호표
            
            if (!check[ridx][uidx]){ // 신고한 적 없음
                check[ridx][uidx] = true;
                reportList[ridx].add(uidx); // 신고한 id 저장
            }
        }
        // 신고당한 횟수 확인
        for (int i=0; i<size; i++){
            if (reportList[i].size() >= k){
                for (int uidx: reportList[i]){
                    answer[uidx]++;
                }
            }
        }
        
        return answer;
    }
}