import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = parseInt(st.nextToken()); // 집합의 개수
        int m = parseInt(st.nextToken()); // 연산의 개수

        parent = new int[n+1];
        for (int i=0; i<n+1; i++){
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int operationType = parseInt(st.nextToken());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());

            if(operationType == 0){ //합집합
                unionSet(a, b);
            } else { // 같은 집합인지 확인
                if (find(a) == find(b)) {
                    sb.append("yes");
                } else {
                    sb.append("no");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
    // 합집합 연산
    private static void unionSet(int a, int b){
        // 합하게 되면 a와 b 중에 더 작은 수의 집합으로 합치는 규칙으로 설정하자
        int rootA = find(a); // a의 대표 원소 찾기
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    // x의 대표 원소 찾기 (경로 압축, union find)
    private static int find(int x){
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}
