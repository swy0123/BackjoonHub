import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int start = Integer.MAX_VALUE, max = 0;
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	if(arr[i]<start) {
        		start = arr[i];
        	}
        	if(arr[i]>start) {
        		max = Math.max(max, arr[i]-start);
        	}
        }
        System.out.println(max);
    }
}