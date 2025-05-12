import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{ // 13397. 구간 나누기 2
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        int lt = 0;
        int rt = -1;
        int res = 0;
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            rt = Math.max(rt, arr[i]);
        }

        while(lt <= rt){
            int group = 1;
            int mid = (lt + rt)/2;
            int aMin = Integer.MAX_VALUE;
            int aMax = Integer.MIN_VALUE;

            for (int i=0; i<n; i++){
                aMin = Math.min(aMin, arr[i]);
                aMax = Math.max(aMax, arr[i]);
                if ((aMax - aMin) > mid){
                    aMin = Integer.MAX_VALUE;
                    aMax = Integer.MIN_VALUE;
                    group++;
                    i--;
                }
            }

            if (group <= m){
                res = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        System.out.println(res);
    }
}