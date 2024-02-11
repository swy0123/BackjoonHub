import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), idx = 1000001;
        int[] input = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	input[i] = Integer.parseInt(st.nextToken());
        }
        int[] arr = new int[idx];
        Arrays.fill(arr, Integer.MIN_VALUE);
        for(int i=0; i<n; i++) arr[input[i]] = 0;
        
        for(int i : input) {
        	for(int j=i+i; j<idx; j+=i) {
        		if(arr[j]!=Integer.MIN_VALUE) {
        			arr[i]++;
        			arr[j]--;
        		}
        	}
        }
        StringBuilder sb = new StringBuilder();
        for(int i : input) {
        	sb.append(arr[i]+" ");
        }
//        System.out.println(Arrays.toString(arr));
        System.out.println(sb);
    }
}