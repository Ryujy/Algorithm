import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		HashMap<String, String> map = new HashMap<>();
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}
		
		ArrayList<String> list = new ArrayList<>();
		for (Entry<String, String> name : map.entrySet()) {
			if (name.getValue().equals("enter")) {
				list.add(name.getKey());
			}
		}
		
		Collections.sort(list, Collections.reverseOrder());
		
		for (String n : list) {
			System.out.println(n);
		}
	}
		
}