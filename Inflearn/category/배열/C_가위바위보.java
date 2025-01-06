package b_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class C_가위바위보 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] A = br.readLine().split(" ");
        String[] B = br.readLine().split(" ");

        ArrayList<String> ans = new ArrayList<>();
        for (int i=0; i<n; i++){
            if (A[i].equals("3") && B[i].equals("1")) ans.add("B"); // Condition 'A[i].equals(3) && B[i].equals(1)' is always 'false' => 비교를 String으로 해줘야함 "3"
            else if (A[i].equals(B[i])) ans.add("D");
            else ans.add(Integer.parseInt(A[i]) > Integer.parseInt(B[i]) ? "A" : "B");
        }

        for (String s : ans){
            System.out.println(s);
        }
    }
}
