import java.util.*;
import java.io.*;
import java.sql.Array;

public class Main {
	static long a, b, c;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());
        
        System.out.println(solve(a, b)%c);
    }
    private static long solve(long target, long num) {
    	if(num == 1) {
    		return target%c;
    	}
    	long tmp = solve(target, num/2)%c;
    	return (num%2==0) ? tmp*tmp : (tmp*tmp%c)*(target%c);
    }
}