import java.util.*;
import java.io.*;

public class Main {
	static class node{
		int to, sum;
		public node(int to, int sum) {
			this.to = to;
			this.sum = sum;
		}
	}
	static ArrayList<Integer>[] need;
	static int n, k, times[], sum[];
	
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());
        for(int testCase=0; testCase<t; testCase++) {
        	st = new StringTokenizer(br.readLine());
        	n = Integer.parseInt(st.nextToken());
        	k = Integer.parseInt(st.nextToken());
        	times = new int[n+1];
        	sum = new int[n+1];
        	Arrays.fill(sum, Integer.MAX_VALUE);
        	st = new StringTokenizer(br.readLine());
        	for(int i=1; i<=n; i++) times[i] = Integer.parseInt(st.nextToken());
        	
        	need = new ArrayList[n+1];
        	for(int i=1; i<=n; i++) {
        		need[i] = new ArrayList<>();
        	}
        	int from, to;
        	for(int i=0; i<k; i++) {
        		st = new StringTokenizer(br.readLine());
        		from = Integer.parseInt(st.nextToken());
        		to = Integer.parseInt(st.nextToken());
        		need[to].add(from);
        	}
        	
        	int target = Integer.parseInt(br.readLine());
        	int ret = solve(target);
        	System.out.println(ret);
        }
    }
    private static int solve(int target) {
    	if(need[target].size()==0) {
    		sum[target] = times[target];
    		return sum[target];
    	}
    	
    	int ret = 0;
    	for(int num : need[target]) {
    		if(sum[num]!=Integer.MAX_VALUE) ret = Math.max(ret, sum[num]);
    		else ret = Math.max(ret, solve(num));
    	}
    	ret = ret + times[target];
    	sum[target] = ret;
    	return ret;
    }
}