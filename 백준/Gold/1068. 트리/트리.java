import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import static java.lang.Integer.*;
import static java.lang.Math.*;

class Main{ // 15681. 트리와 쿼리

    static int[] parents;
    static int[] child;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 노드의 개수
        parents = new int[n];
        child = new int[n];
        tree = new ArrayList[n];

        for (int i=0; i<n; i++){
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            int p = Integer.parseInt(st.nextToken());
            if(p==-1) continue;
            parents[i] = p; //부모 노드 기록
            child[p]++;     //해당 부모에 자식 수 기록
            tree[p].add(i); //부모 노드에 자식 추가
        }
        int remove = Integer.parseInt(br.readLine()); // 지울 노드

        child[parents[remove]]--; // 지울 노드의 부모의 자식 수 감소
        remove(remove);
        int cnt = 0;
        for (int i=0; i<n; i++){
            if (child[i] == 0) cnt++;
        }
        System.out.println(cnt);
    }

    private static void remove(int remove){
        child[remove] = -1; // 지울 노드의 자식 수 초기화
        // 지울 노드의 자식 노드에 방문 -> 자식 수 초기화
        for (int c:tree[remove]){
            remove(c);
        }
    }
}