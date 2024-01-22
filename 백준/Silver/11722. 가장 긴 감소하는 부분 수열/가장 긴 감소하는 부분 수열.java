import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] map = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] arr = new int[n+2];
		arr[1] = 1;
		for(int i=2; i<=n; i++) {
			int min = 1;
			for(int j=i; j>=0; j--) {
				if(map[i] < map[j]) {
					min = Math.max(min, arr[j]+1);
				}
			}
			arr[i] = min;
		}
		int max = 0;
		for(int i=1; i<=n; i++) {
			max = Math.max(max, arr[i]);
		}
		System.out.println(max);
	}

}