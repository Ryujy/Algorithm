import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        String[] arr = new String[T];
        for (int i = 0; i < T; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < T; i++) {
            String current = arr[i];
            System.out.println(point(0, current.length() - 1, current, 0));
        }
    }

    private static int point(int start, int end, String s1, int check) {
    
        if(check >=2) return 2;

        while (start < end) { 
            if (s1.charAt(start) == s1.charAt(end)) {
                start++;
                end--;
            } else {
                return Math.min(point(start + 1, end, s1, check + 1), point(start, end - 1, s1, check + 1));
            }
        }
        return check;
    }
}