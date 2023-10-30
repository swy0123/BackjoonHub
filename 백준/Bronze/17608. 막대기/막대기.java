import java.io.*;
 
 
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
        	int tmp = Integer.parseInt(br.readLine());
        	arr[i] = tmp;
        }
        int res = 0, max = 0;;
        for(int i=n-1; i>=0; i--) {
        	if(max<arr[i]) {
        		max = arr[i];
        		res++;
        	}
        }
        System.out.println(res);
    }
}