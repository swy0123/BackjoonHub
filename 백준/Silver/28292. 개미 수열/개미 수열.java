import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n<3) System.out.println("1");
        else if(n<6) System.out.println("2");
        else System.out.println("3");
    }
}