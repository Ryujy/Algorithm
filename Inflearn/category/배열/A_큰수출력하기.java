package b_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class A_큰수출력하기 { // 큰 수 출력하기

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[N];
        for (int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
            // 자신의 바로 앞 수보다만 크면 되는데 굳이 배열에 저장하고 for문을 두 번 돌릴 필요있을까?
            // -> 출력받기에 따라 안 받아도 될 듯
        }

        sb.append(nums[0]); // 첫 번째 수는 무조건 출력한다
        for (int i=1; i<N; i++){
            if(nums[i-1] < nums[i]){
                sb.append(" ").append(nums[i]);
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        A_큰수출력하기 T = new A_큰수출력하기();
        T.solution();
//        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
//        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
//        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
//        System.out.println(T.solution(6, new int[]{7, 3, 9, 5, 6, 12});
    }
}
