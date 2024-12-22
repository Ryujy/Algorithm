import java.io.*;
import java.util.*;

public class Main {
	static HashSet<Integer> set=new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st;

		String word=br.readLine();
		String find=br.readLine();

		while(find.length()!=word.length()) {
			if(find.charAt(find.length()-1)=='A')
				find=find.substring(0,find.length()-1);
			else {
				StringBuilder sbr=new StringBuilder(find);
				find=sbr.reverse().toString();
				find=find.substring(1,find.length());
			}
		}
		
		if(find.equals(word)){
			System.out.println(1);
        }else{
            System.out.println(0);   
        }	
	}
}