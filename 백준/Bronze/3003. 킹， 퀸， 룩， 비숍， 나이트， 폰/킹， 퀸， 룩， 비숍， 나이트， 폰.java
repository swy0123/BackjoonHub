import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ret = {1, 1, 2, 2, 2, 8};
        int[] arr = new int[6];
        for(int i=0; i<6; i++) {
        	arr[i] = ret[i] - Integer.parseInt(st.nextToken());
        	System.out.print(arr[i]+" ");
        }
    }
}