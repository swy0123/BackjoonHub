import java.util.*;
import java.io.*;


public class Main {
	static int n;
	static char[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		
		for(int y=0; y<n; y++) {
			String input = br.readLine();
			for(int x=0; x<n; x++) {
				map[y][x] = input.charAt(x);
			}
		}
		
		int row = 0, col = 0;
		for(int i=0; i<n; i++) {
			int curRow = 0, curCol = 0;
			int j = 0;
			while(j<n) {
				if(j+1<n) {
					if(j==0 && map[i][j]=='.' && map[i][j+1]=='.') {
						curRow++;
					}
					if(j>0 && map[i][j-1]=='X' && map[i][j]=='.' && map[i][j+1]=='.') {
						curRow++;
					}
					if(j==0 && map[j][i]=='.' && map[j+1][i]=='.') {
						curCol++;
					}
					if(j>0 && map[j-1][i]=='X' && map[j][i]=='.' && map[j+1][i]=='.') {
						curCol++;
					}
				}
				j++;
			}
			row += curRow;
			col += curCol;
		}
		System.out.println(row + " " + col);
	}
}