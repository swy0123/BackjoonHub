import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        int[] x = new int[a];
        int[] y = new int[a];
        
        x[0] = b;
        x[1] = b;
        y[0] = 0;
        y[1] = -1;
        for(int i=2; i<a; i++) {
        	x[i] = x[i-2]-x[i-1];
        	y[i] = y[i-2]-y[i-1];
        }
//        System.out.println(Arrays.toString(x));
//        System.out.println(Arrays.toString(y));
        
        int cnt = 1;
        while(true) {
        	boolean flag = true;
        	for(int i=1; i<a; i++) {
        		int next = x[i-1] + y[i-1]*cnt;
        		int cur = x[i] + y[i]*cnt;
//            	System.out.println(i+ " "+cur+" "+next);
        		if(cur<=0 || next<=0 || cur>next) {
        			flag = false;
        			break;
        		};
        	}
//        	System.out.println(cnt);
        	if(flag) break;
        	cnt++;
        }
        System.out.println(x[a-1] + y[a-1]*cnt);
        System.out.println(x[a-2] + y[a-2]*cnt);
    }
}