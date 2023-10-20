import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int m = Integer.parseInt(br.readLine());
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			String oper = st.nextToken();
			if(oper.equals("add")) {
				int num = Integer.parseInt(st.nextToken());
				set.add(num);
			}
			else if(oper.equals("remove")) {
				int num = Integer.parseInt(st.nextToken());
				set.remove(num);
			}
			else if(oper.equals("check")) {
				int num = Integer.parseInt(st.nextToken());
				if(set.contains(num)) sb.append("1\n");
				else sb.append("0\n");
			}
			else if(oper.equals("toggle")) {
				int num = Integer.parseInt(st.nextToken());
				if(set.contains(num)) set.remove(num);
				else set.add(num);
			}
			else if(oper.equals("all")) {
				set = new HashSet<Integer>();
				for(int j=1; j<=20; j++) {
					set.add(j);
				}
			}
			else if(oper.equals("empty")) {
				set = new HashSet<Integer>();
			}
		}
		System.out.println(sb);
	}
}