import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int max = 0;
		int[] arr = new int[n+k];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int i=n; i<n+k; i++) {
			arr[i] = arr[i-n];
		}
		HashMap<Integer, Integer> dic = new HashMap<>();
		dic.put(c, 1);
		for(int i=0; i<k; i++) {
			if(dic.containsKey(arr[i])) {
				dic.put(arr[i], dic.get(arr[i])+1);
			}
			else dic.put(arr[i], 1);
		}
		max = dic.size();
		for(int i=k; i<n+k; i++) {
			dic.put(arr[i-k], dic.get(arr[i-k])-1);
			if(dic.get(arr[i-k])<=0) dic.remove(arr[i-k]);
			
			if(dic.containsKey(arr[i])) {
				dic.put(arr[i], dic.get(arr[i])+1);
			}
			else dic.put(arr[i], 1);
			max = Math.max(max, dic.size());
		}
		System.out.println(max);
	}
}