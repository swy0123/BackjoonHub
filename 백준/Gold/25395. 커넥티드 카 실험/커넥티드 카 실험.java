import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int s = Integer.parseInt(st.nextToken());
    	
    	int[] arr = new int[n];
    	int[] fuels = new int[n];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<n; i++) {
    		fuels[i] = Integer.parseInt(st.nextToken());
    	}

		boolean[] v = new boolean[n];
		int left = s - 1;
		int right = s - 1;
		long min = (long) arr[left] - fuels[left];
		long max = (long) arr[right] + fuels[right];

		while (true) {
			int prevLeft = left;
			int prevRight = right;

			while (left > 0 && arr[left - 1] >= min) {
				left--;
				min = Math.min(min, (long) arr[left] - fuels[left]);
				max = Math.max(max, (long) arr[left] + fuels[left]);
			}

			while (right < n - 1 && arr[right + 1] <= max) {
				right++;
				min = Math.min(min, (long) arr[right] - fuels[right]);
				max = Math.max(max, (long) arr[right] + fuels[right]);
			}

			if (prevLeft == left && prevRight == right) {
				break;
			}
		}

		for (int x = left; x <= right; x++) {
			v[x] = true;
		}
		StringBuilder sb = new StringBuilder();
    	for(int x=0; x<n; x++) {
    		if(v[x]) {
        		sb.append(x+1+" ");
    		}
    	}
    	System.out.println(sb);
    }
}
