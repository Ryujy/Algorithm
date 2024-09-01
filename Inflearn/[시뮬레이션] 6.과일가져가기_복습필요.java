import java.util.*;
class Solution { // 6.과일 가져가기
    // 최소 바구니의 값 구하기
    public int getMin(int[] fruit){
        int min = 51;
        for (int x : fruit){
            min = min > x ? x : min;
        }
        return min;
    }
    // 최소 바구니 구하기
    public int getMinIdx(int[] fruit){
        int min = getMin(fruit);
        for (int i = 0; i<3; i++){
            if (fruit[i] == min) return i;
        }
        return 0;
    }
    // 최소 바구니 유니크 여부
    public boolean isMinUnique(int[] fruit){
        int min = getMin(fruit);
        int cnt = 0;
        for (int x : fruit){
            if (x == min) cnt++;
        }
        /*
        if (cnt > 1) return false;
        return true;
         */
        return cnt == 1;
    }

    public int solution(int[][] fruits){
        int answer = 0;
        int n = fruits.length; // 학생 수
        boolean[] ch = new boolean[n];

        for (int i=0; i<n; i++){
            // 최소바구니 유니크 확인
            if (!isMinUnique(fruits[i])) continue;
            if (ch[i]) continue;
            // a학생의 최소바구니 구하기
            int aidx = getMinIdx(fruits[i]);
            for (int j=i+1; j<n; j++){
                if (ch[j]) continue;    /* 주의 */
                // b학생의 최소바구니 구하기
                int bidx = getMinIdx(fruits[j]);
                // 교환할 바구니 서로 다름 확인 && 교환할 수량 되는지 확인
                if (bidx != aidx && fruits[i][aidx] > 0 && fruits[j][bidx] > 0){
                    if (fruits[i][aidx] + 1 <= fruits[i][bidx] - 1
                            && fruits[j][bidx] + 1 <= fruits[j][aidx] - 1){
                        fruits[i][aidx]++;
                        fruits[i][bidx]--;
                        fruits[j][aidx]--;
                        fruits[j][bidx]++;
                        ch[i] = ch[j] = true;
                        break;
                    }
                }
            }
        }
        // 바구니 총합
        for (int[] x : fruits){
            answer += getMin(x);
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
//        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
//        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
//        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}
