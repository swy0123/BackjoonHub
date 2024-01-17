import java.util.*;
import java.io.*;
/*
 * 귀여운 라이언
 */
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	if(arr[i] == 1)list.add(i);
        }
        if(list.size()<k) System.out.println(-1);
        else {
        	int idx = k-1;
        	int min = Integer.MAX_VALUE;
        	while(idx<list.size()) {
        		min = Math.min(min, list.get(idx)-list.get(idx-k+1)+1);
        		idx++;
        	}
        	System.out.println(min);
        }
    }
}