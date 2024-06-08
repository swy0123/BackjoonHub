import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int idx = 1;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(arr[0], 1);
        
        int max = 1;
        while(idx < n) {
        	if(map.containsKey(arr[idx])) {
        		map.put(arr[idx], map.get(arr[idx])+1);
        	}
        	else if(map.size()==1) {
        		map.put(arr[idx], 1);
        	}
        	else {
        		int cur = idx-1;
        		while(cur>=0) {
        			if(arr[cur-1] == arr[cur]) cur--;
        			else break;
        		}
        		map.clear();
        		map.put(arr[idx-1], idx-cur);
        		map.put(arr[idx], 1);
        	}
        	int nums = 0;
        	for(int num: map.values()) {
        		nums+=num;
        	}
        	max = Math.max(max, nums);
        	idx++;
        }
        
        System.out.println(max);
    }
}