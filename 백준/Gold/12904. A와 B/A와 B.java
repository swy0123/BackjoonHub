import java.util.*;
import java.io.*;

public class Main {

	static boolean sarr[], tarr[], rtarr[], res;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		int ans = 0;
		while(true){
			char last = t.charAt(t.length()-1);
			if(last == 'A'){
				t = t.substring(0, t.length()-1);
			}
			else if(last == 'B'){
				t = t.substring(0, t.length()-1);
				StringBuffer sb = new StringBuffer(t);
				t = sb.reverse().toString();
			}
			if(t.equals(s)){
				ans = 1;
				break;
			}
			if(t.length() == 1) break;
		}
		System.out.println(ans);
    }

}