import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{ // 2792. 보석 상자
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 아이들의 수
        int m = Integer.parseInt(st.nextToken()); // 보석 색상의 수
        int[] gems = new int[m];

        for (int i=0; i<m; i++){
            gems[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(gems);
        int lt = 1;
        int rt = gems[m-1];
        int minA = 0;
        while(lt<=rt){
            int mid = (lt+rt)/2;
            int totalKid = 0;
            for (int g:gems){
                totalKid += (g + mid - 1)/mid; // 보석을 나눠가질 수 있는 인원 올림
            }

            if (totalKid <= n){
                rt = mid - 1;
                minA = mid;
            } else {
                lt = mid + 1;
            }
        }
        System.out.println(minA);
    }
}