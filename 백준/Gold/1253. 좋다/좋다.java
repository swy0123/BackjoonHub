import java.util.*;
import java.io.*;
/*
 * 좋다
 */
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int res = 0;
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int start, end;
        for(int i=0; i<n; i++) {
        	start = 0;
        	end = n-1;
        	while(start<end) {
//        		System.out.println(arr[start]+arr[end]+" "+arr[i]);
        		if(start == i) {
        			start++;
        			continue;
        		}
        		if(end == i) {
        			end--;
        			continue;
        		}
        		if(arr[start]+arr[end]>arr[i]) end--;
        		else if(arr[start]+arr[end]<arr[i]) start++;
        		else {
        			res++;
        			break;
        		}
        	}
        }
        
        System.out.println(res);
    }
}