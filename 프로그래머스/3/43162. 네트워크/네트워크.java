import java.io.*;
import java.util.*;

class Solution {
    
    static boolean[] v;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        v = new boolean[n];
        
        for (int i=0; i<n; i++){
            if(!v[i]){ //방문하지 않은 노드
                answer++;
                dfs(i, computers, n);
            }
            
        }
        
        return answer;
    }
    static void dfs(int node, int [][] computers, int N){
        v[node] = true;
        for (int i = 0; i<N; i++){
            if(computers[node][i] == 1 && !v[i]){
                dfs(i,computers, N);
                
            }
        }
    }
    
}