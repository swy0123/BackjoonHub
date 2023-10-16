import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		//상근 = true
		boolean[] arr = new boolean[n+1];
		arr[1] = true;
		if(n>=3) arr[3] = true;
		if(n>=4) arr[4] = true;
		
		for(int i=5; i<n+1; i++) {
			if(arr[i-1] && arr[i-3] && arr[i-4]) arr[i] = false;
			else arr[i] = true;
		}
//		System.out.println(Arrays.toString(arr));
		if(arr[n]) System.out.println("SK");
		else System.out.println("CY");
	}
}