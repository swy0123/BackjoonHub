import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        for (int i : arr) {
        	deq.add(i);
		}
        int ret = 0;
        while(!deq.isEmpty()) {
        	int start = deq.pollFirst();
        	while(!deq.isEmpty()) {
        		int end = deq.pollLast();
        		if(start+end<=k) {
        			ret++;
            		break;
        		}
        	}
        }
        System.out.println(ret);
    }
}