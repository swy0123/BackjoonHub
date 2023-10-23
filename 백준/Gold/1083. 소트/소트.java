import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        int s = Integer.parseInt(br.readLine());
        
        for(int i=0; i<n; i++) {
        	int max = arr[i], idx = i, j=i+1;
        	while(j<n) {
        		if(j>s+i) break;
        		if(arr[j]>max) {
        			max = arr[j];
        			idx = j;
        		}
        		j++;
        	}
        	for(int k=idx; k>i; k--) {
        		int tmp = arr[k];
                arr[k] = arr[k-1];
                arr[k-1] = tmp;
                s--;
        	}
        	
        	if(s<=0) break;
        }
        
        for(int i=0; i<n; i++) {
        	sb.append(arr[i]+" ");
        }
        System.out.println(sb);
    }
}