import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static char[] arr;
	static int[] min, max;
	static boolean flag;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        arr = new char[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	arr[i] = st.nextToken().charAt(0);
        }
        flag = false;
        min = new int[n+1];
        max = new int[n+1];
        solve(0, new boolean[10], new int[n+1]);
        
//        System.out.println(Arrays.toString(max));
//        System.out.println(Arrays.toString(min));
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<max.length; i++) {
        	sb.append(max[i]);
        }
        sb.append("\n");
        for(int i=0; i<min.length; i++) {
        	sb.append(min[i]);
        }
        System.out.println(sb);
    }
    
    private static void solve(int idx, boolean[] v, int[] tmp) {
    	if(idx == n+1) {
    		if(!flag) {
    			min = tmp.clone();
    		}
    		else {
    			max = tmp;
    		}
    		flag = true;
    		return;
    	}
		int[] next = tmp.clone();
    	for(int i=0; i<=9; i++) {
    		if(v[i]) continue;
    		v[i] = true;
			
    		if(idx==0) {
    			next[idx] = i;
    			solve(idx+1, v, next);
    		}
    		else {
    			switch (arr[idx-1]) {
				case '>':
					if(tmp[idx-1]>i) {
						next[idx] = i;
						solve(idx+1, v, next);
					}
					break;
				case '<':
					if(tmp[idx-1]<i) {
						next[idx] = i;
						solve(idx+1, v, next);
					}
					break;
				default:
					break;
				}
    		}
    		
    		v[i] = false;
    	}
    }
    
    
}