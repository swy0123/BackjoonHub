import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static String[] eng = {
			"zero", "one", "two", "three", "four", 
			"five", "six", "seven", "eight", "nine"
	};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        
        String[] arr = new String[end-start+1];
        HashMap<String, Integer> dic = new HashMap<>();
        int idx=0;
        for(int i=start; i<=end; i++) {
        	if(i<10) {
        		arr[idx] = eng[i];
        		dic.put(arr[idx], i);
        	}
        	else {
        		int ten = i/10;
        		int one = i%10;
        		arr[idx] = eng[ten] + " " + eng[one];
        		dic.put(arr[idx], i);
        	}
        	idx++;
        }
        Arrays.sort(arr);
        idx = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++) {
        	if(idx==10) {
        		sb.append("\n");
        		idx = 0;
        	}
        	sb.append(dic.get(arr[i])+" ");
        	idx++;
        }
        
        System.out.println(sb);
    }
}