import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int h = Integer.parseInt(st.nextToken());
    	int w = Integer.parseInt(st.nextToken());
    	int[] arr = new int[w];
    	int[] tmp = new int[w];
    	int max = 0;
    	int maxIndex = 0;
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<w; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    		if(arr[i]>max) {
    			max = arr[i];
    			maxIndex = i;
    		}
    	}
    	
    	int cur = 0;
    	int sum = 0;
    	for(int i=0; i<=maxIndex; i++) {
    		if(arr[i]>cur) cur = arr[i];
    		else sum+=cur-arr[i];
    	}
    	cur = 0;
    	for(int i=w-1; i>maxIndex; i--) {
    		if(arr[i]>cur) cur = arr[i];
    		else sum+=cur-arr[i];
    	}
    	
    	System.out.println(sum);
    }
}