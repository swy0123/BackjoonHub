import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0, end = n-1;
		
		int min = arr[start]+arr[end];
		int tmp = min;
		int minS = start, minE = end;
		while(true) {
			if(tmp>0) {
				end--;
				if(start==end) break;
				tmp = arr[start]+arr[end];
//				System.out.println(min+" "+tmp);
				if(Math.abs(tmp)<Math.abs(min)) {
					min = tmp;
					minS = start;
					minE = end;
				}
			}
			else {
				start++;
				if(start==end) break;
				tmp = arr[start]+arr[end];
//				System.out.println(min+" "+tmp);
				if(Math.abs(tmp)<Math.abs(min)) {
					min = tmp;
					minS = start;
					minE = end;
				}
			}
		}
		System.out.println(arr[minS] +" "+arr[minE]);
	}
}