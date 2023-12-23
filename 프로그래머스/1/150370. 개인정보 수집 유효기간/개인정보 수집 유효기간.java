import java.util.*;
class Solution { //오늘 날짜, 약관의 유효기관, 개인정보
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> list = new ArrayList<>(); ;
        // 오늘 날짜 YYYY.MM.DD
        // 유효기관  [약관 보관] [달 수]
        // 개인정보  [수집 일자] [약관 종류]
        
        // 수집 일자 + 달 수 => 파기 날짜 >= 오늘 날짜 -> 파기
        StringTokenizer st = new StringTokenizer(today, ".");
        int tyear = Integer.parseInt(st.nextToken());
        int tmonth = Integer.parseInt(st.nextToken());
        int tday = Integer.parseInt(st.nextToken());
        
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i<terms.length; i++){
            st = new StringTokenizer(terms[i], " ");
            map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        
        for (int i=0; i<privacies.length; i++){
            st = new StringTokenizer(privacies[i], " ");
            String privacy = st.nextToken(); //2021.05.02
            String term = st.nextToken(); //A
            
            int period = map.get(term);
            
            st = new StringTokenizer(privacy, ".");
            int y = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            
            int newYear = y + (period / 12);
            int newMonth = m + (period % 12);
            if (newMonth > 12){
                newMonth -= 12;
                newYear += 1;
            }
            d -= 1;
            if (d == 0){
                d = 28;
                newMonth -= 1;
                if (newMonth == 0){
                    newMonth = 12;
                    newYear -= 1;
                }
            }
            
            if (newYear < tyear){
                list.add(i+1);
            } else if (newYear == tyear){
                if (newMonth < tmonth){
                    list.add(i+1);
                } else if (newMonth == tmonth){
                    if (d < tday){
                        list.add(i+1);
                    }
                }
            }
            
        }
        
        int[] ans = new int[list.size()];
        for (int i = 0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}