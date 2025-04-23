import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main { // 2805. 나무 자르기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 나무의 수 N (최대 100만)
        int m = Integer.parseInt(st.nextToken()); // 목표 나무 길이 M (최대 20억)

        int[] trees = new int[n]; // 나무들의 높이 (최대 10억)
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }

        int maxH = 0;

        // 중간값 정하기
        Arrays.sort(trees); // 오름차순 정렬
        int lt = 0;
        int rt = trees[n-1];

        while (lt <= rt){
            int mid = (lt + rt)/2;
            // trees를 mid로 자른 총 길이 구하기
            long sum = 0;
            for (int t : trees){
                sum += Math.max(t- mid, 0); // 음수이면 0, 양수이면 양수
            }
            // 총길이가 m보다 작으면 rt = mid
            if (sum < m){
                rt = mid - 1;
            } else{ // sum과 m이 딱 맞아떨어지지 않을 수도 있음
                // 총길이가 m보다 크거나 같으면 갱신, lt = mid
                maxH = mid;
                lt = mid + 1;
            }
        }

        System.out.println(maxH);
    }
}