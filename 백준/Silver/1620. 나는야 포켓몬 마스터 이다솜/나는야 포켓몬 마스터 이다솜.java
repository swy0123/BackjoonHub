import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> strDic = new HashMap<String, Integer>();
		HashMap<Integer, String> numDic = new HashMap<Integer, String>();
		
		for(int i=1; i<=n; i++) {
			String str = br.readLine();
			strDic.put(str, i);
			numDic.put(i, str);
		}
		for(int j=0; j<m; j++) {
			String str = br.readLine();
			if(str.charAt(0)>='0' && str.charAt(0)<='9') {
				sb.append(numDic.get(Integer.parseInt(str))+"\n");
			}
			else sb.append(strDic.get(str)+"\n");
		}
		System.out.println(sb);
	}
}