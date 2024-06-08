import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int num = (int)Math.sqrt(n);
        
        System.out.println(num);
    }
}