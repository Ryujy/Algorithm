import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {

    static int[][] wheels = new int[4][8];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i=0; i<4; i++){ // 톱니바퀴 1~4
            String str = br.readLine();
            for (int j=0; j<8; j++){ // 각 톱니바퀴 상태 (12시 방향부터 시계방향)
                // N극 0, S극 1
                wheels[i][j] = str.charAt(j) - '0';
            }
        }

        int k = parseInt(br.readLine()); // 회전 횟수
        for (int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int number = parseInt(st.nextToken()); // 회전시킨 톱니바퀴 번호
            int dir = parseInt(st.nextToken()); // 회전 방향 (1:시계 / -1:반시계)
            rotate(number-1, dir); // 회전 ㄱㄱ
        }

        // 점수의 합 출력 (12시 방향이 N극 0점, S극 1/2/4/8점)
        System.out.println(result());
    }

    private static void rotate(int number, int dir){
        int[] dirs = new int[4]; // 회전 여부
        dirs[number] = dir;

        // 오른쪽 전파
        for (int i=number; i<3; i++){
            if (wheels[i][2] != wheels[i+1][6]) { // 맞닿은 부분 다르면 회전 여부 저장
                dirs[i+1] = -dirs[i];
            } else break;
        }

        // 왼쪽 전파
        for (int i=number; i>0; i--){
            if (wheels[i][6] != wheels[i-1][2]) { // 맞닿은 부분 다르면 회전 여부 저장
                dirs[i-1] = -dirs[i];
            } else break;
        }

        for (int i=0; i<4; i++){
            if (dirs[i] == 0) continue; // 회전 X
            rotateSingle(i, dirs[i]);
        }
    }

    private static void rotateSingle(int number, int dir){
        if(dir == 1) { // 시계 방향
            int tmp = wheels[number][7];
            for(int w=6; w>=0; w--){
                int rotateIdx = (w+1) % 8;
                wheels[number][rotateIdx] = wheels[number][w];
            }
            wheels[number][0] = tmp;
        } else { // 반시계
            int tmp = wheels[number][0]; //A
            for (int w=1;w<8; w++){
                int rotateIdx = (w+7) % 8;
                wheels[number][rotateIdx] = wheels[number][w];
            }
            wheels[number][7] = tmp;
        }
    }

    private static int result(){ // 점수의 합 출력 (12시 방향이 N극 0점, S극 1/2/4/8점)
        int result = 0;
        // 네 개의 톱니바퀴
        for (int i=0; i<4; i++){
            // 12시 방향 확인
            if (wheels[i][0] == 1) {// S극임 ㅇㅇ -> 점수
                result += (int) Math.pow(2, i); // 점수가 2의 거듭제곱
            }
        }
        return result;
    }
}
