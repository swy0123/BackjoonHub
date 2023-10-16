import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		HashSet<Integer> set = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<a; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<b; i++) {
			set.remove(Integer.parseInt(st.nextToken()));
		}
		
		Integer[] arr = set.toArray(new Integer[0]);
		Arrays.sort(arr);
		
		System.out.println(set.size());
		for(Integer item:arr) {
			System.out.print(item+" ");
		}
		
	}
}