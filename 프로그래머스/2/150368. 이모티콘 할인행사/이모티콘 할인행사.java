class Solution {
    static int[] percent = {10, 20, 30, 40};
    static double[] sales;
    static int plus, result;
    public int[] solution(int[][] users, int[] emoticons) {
        int m = emoticons.length;
        sales = new double[m];
        plus = 0;
        result = 0;
        perm(0, m, emoticons, users); // cnt, emoticons.length, emoticons[]
    
        int[] answer = {plus, result};
        return answer;
    }
    
    private static void perm(int cnt, int m, int[] emoticons, int[][] users){
        
        if (cnt >= m){ //sales[]
            //emoticons 정가 <- sales 할인률 계산
            int[] prices = new int[m];
            for (int i=0; i<m; i++){
                double discount = emoticons[i] * (sales[i]/100);
                prices[i] = emoticons[i] - (int)discount; //할인된 가격
            }
            int[] res = purchase(prices, users);
            if (plus < res[0]){ //가입자 갱신
                plus = res[0];
                result = res[1];
            } else if (plus == res[0]){
                plus = res[0];
                if (result < res[1]) result = res[1];
            }
            return;
        }
        for (int i=0; i<4; i++){
            sales[cnt] = percent[i];
            perm(cnt+1, m, emoticons, users);
        }
    }
    
    private static int[] purchase(int[] prices, int[][] users){ // 할인된 가격
        // 이모티콘 구매 -> 플러스 가입자, 판매액
        int cnt = 0;
        int total = 0;
        for (int i=0; i<users.length; i++){
            int sum = 0;
            for (int j=0; j<prices.length; j++){
                if (sales[j] >= users[i][0]){ // 사용자의 구매 할인률 기준 이상
                    sum += prices[j];
                } else {
                    continue;
                }
            }
            if (sum >= users[i][1]){ // 사용자의 가격 기준 이상 -> 플러스 가입
                cnt++;
            } else {
                total += sum;
            }
        }
        int[] res = {cnt, total};
        return res;
    }
}