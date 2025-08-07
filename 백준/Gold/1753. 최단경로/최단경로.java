import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

public class Main {
    static class Node implements Comparable<Node>{
        int vertex;
        int weight;
        private Node(int v, int w){
            this.vertex = v;
            this.weight = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    static ArrayList<Node>[] graph;
    static int INF = MAX_VALUE;
    static int[] d;
    private static void dijkstra(int v, int start){
        // 최단경로 저장 배열 초기화
        d = new int[v+1];
        for (int i=1; i<v+1; i++){ // 정점은 1부터 v
            d[i] = INF;
        }
        d[start] = 0; // 시작 정점은 최단 거리 0

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            // 가장 가까운 노드 추출
            Node current = pq.poll();
            int curVertex = current.vertex;
            int curWeight = current.weight;

            // 이미 짧은 경로를 찾았다면 스킵
            if (curWeight > d[curVertex]) continue;
            for (Node next : graph[curVertex]) {
                int newVertex = next.vertex;
                int newDist = d[curVertex] + next.weight;
                if(newDist < d[newVertex]){
                    d[newVertex] = newDist;
                    pq.offer(new Node(newVertex, newDist));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = parseInt(st.nextToken()); // 정점의 개수
        int e = parseInt(st.nextToken()); // 간선의 개수
        int k = parseInt(br.readLine()); // 시작 정점의 번호

        graph = new ArrayList[v+1];
        for (int i=1; i<v+1; i++){
            graph[i] = new ArrayList<>();
        }
        for (int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int start = parseInt(st.nextToken()); // 시작 정점
            int end = parseInt(st.nextToken());   // 도착 정점
            int weight = parseInt(st.nextToken()); // 간선 가중치

            graph[start].add(new Node(end, weight));
        }

        dijkstra(v, k);
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<v+1; i++){
            if (d[i] == MAX_VALUE) {
                sb.append("INF");
            } else {
                sb.append(d[i]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
