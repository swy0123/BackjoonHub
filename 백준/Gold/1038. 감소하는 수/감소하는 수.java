import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static ArrayList<Long> arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        
        for(int i=0; i<10; i++) {
        	solve(1, i);
        }
        Collections.sort(arr);
        if(n<arr.size()) System.out.println(arr.get(n));
        else System.out.println("-1");
    }
    private static void solve(int idx, long num) {
    	if(idx>10) return;
    	
    	arr.add(num);
    	for(int i=0; i<10; i++) {
    		if(i>=num%10) break;
    		solve(idx+1, num*10 + i);
    	}
    }
}