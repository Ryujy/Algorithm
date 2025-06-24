import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static class Node{
        HashMap<String, Node> childs;
        public Node(){
            childs = new HashMap<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        StringTokenizer st;
        Node root = new Node();

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int k = parseInt(st.nextToken()); // 먹이 정보 개수
            Node cur = root;
            for (int j=0; j<k; j++){
                String str = st.nextToken();
                if(!cur.childs.containsKey(str)){
                    cur.childs.put(str, new Node());
                }
                cur = cur.childs.get(str);
            }
        }
        out(root, "");
        System.out.println(sb);
    }

    private static void out(Node cur, String s){
        ArrayList<String> list = new ArrayList<>(cur.childs.keySet());
        Collections.sort(list);		//사전 순 정렬
        //정렬 이후 사전 순으로 표시 후 탐색
        for(String str : list){
            sb.append(s).append(str).append("\n");
            out(cur.childs.get(str), s +"--");
        }
    }
}
