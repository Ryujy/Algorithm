import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
 
public class Main {
	
	public static int N, M;
	public static int[] arr;
	public static int answer = 0;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	st = new StringTokenizer(br.readLine());
    	M = Integer.parseInt(st.nextToken());
    	
    	arr = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for(int i=0;i<N;i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	Arrays.sort(arr);
    	
    	twoPointer();
    	
    	System.out.println(answer);
    }
    
    public static void twoPointer() {
    	int start = 0;
    	int end = N - 1;
    	int intervalSum = 0;
    	
    	while(start < end) {
    		intervalSum = arr[start] + arr[end];
    		
    		if(intervalSum < M) {
    			start += 1;
    		}
    		else if(intervalSum > M) {
    			end -= 1;
    		}
    		else if(intervalSum  == M) {
    			answer += 1;
    			start += 1;
    			end -= 1;
    		}
    		
    	}
    }
    
}