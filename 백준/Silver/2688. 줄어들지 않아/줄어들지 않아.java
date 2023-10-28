import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] arr = new long[65][10];
        for(int i=0; i<10; i++) {
        	arr[1][i] = 1;
        }
        for(int i=1; i<=64; i++) {
        	arr[i][9] = 1;
        }
    	for(int i=2; i<=64; i++) {
    		for(int j=8; j>=0; j--) {
    			arr[i][j] = arr[i-1][j]+arr[i][j+1];
    		}
    	}
        for(int i=0; i<n; i++) {
        	int len = Integer.parseInt(br.readLine());
        	long cnt = 0;
        	for(int j=0; j<10; j++) {
        		cnt+=arr[len][j];
        	}
        	System.out.println(cnt);
        }
    }
}