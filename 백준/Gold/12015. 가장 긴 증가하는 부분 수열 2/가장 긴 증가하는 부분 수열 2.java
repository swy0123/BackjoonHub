import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] map = new int[n+1];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(map[0]);
		
		for(int i=1; i<n; i++) {
			if(list.get(list.size()-1) < map[i]) {
				list.add(map[i]);
			}
			else {
				int tmp = Collections.binarySearch(list, map[i]);
				if(tmp<0) {
					tmp = -1-tmp;
					list.set(tmp, map[i]);
				}
			}
		}
		
		System.out.println(list.size());
	}
}
