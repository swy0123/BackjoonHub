import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//나무제테크 16235
public class Main {
	
	static int n, m, k, energy[][], robot[][];
	static ArrayList<Integer>[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[n][n];
		energy = new int[n][n];
		robot = new int[n][n];

		for(int y=0; y<n; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<n; x++) {
				robot[y][x] = Integer.parseInt(st.nextToken());
				energy[y][x] = 5;
				map[y][x] = new ArrayList<>();
			}
		}

		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			int age = Integer.parseInt(st.nextToken());
			map[y][x].add(age);
//			System.out.println(map[y][x].size());
		}
		
		
		for(int r=0; r<k; r++) {
			for(int y=0; y<n; y++) {
				for(int x=0; x<n; x++) {
//					System.out.println(energy[y][x]);
//					System.out.println("size " + map[y][x].size());
					//봄
					int dieTmp = 0;
					boolean notEnough = false;
					map[y][x].sort((o1, o2) -> (o1.compareTo(o2)));
					int idx = 0;
					while(idx<map[y][x].size()) {
						int curTreeAge = map[y][x].get(idx);
						if(notEnough) {
							map[y][x].remove(idx);
							dieTmp += curTreeAge/2;
							idx--;
//							System.out.println("die");
						}
						else {
							if(curTreeAge<=energy[y][x]) {
								energy[y][x] -= curTreeAge;
								map[y][x].set(idx, curTreeAge+1);
							}
							else {
								map[y][x].remove(idx);
								dieTmp += curTreeAge/2;
								idx--;
								notEnough = true;
//								System.out.println("die");
							}
						}
						idx++;
					}
					//여름
					energy[y][x] += dieTmp;

				}
			}
			//가을
			for(int y=0; y<n; y++) {
				for(int x=0; x<n; x++) {
					for(int idx=0; idx<map[y][x].size(); idx++) {
						int curTreeAge = map[y][x].get(idx);
						if(curTreeAge>0 && curTreeAge%5==0) {
							for(int dx=-1; dx<=1; dx++) {
								for(int dy=-1; dy<=1; dy++) {
									if(dx==0 && dy==0) continue;
									if(y+dy>=0 && x+dx>=0 && y+dy<n && x+dx<n){
										map[y+dy][x+dx].add(1);
									}
								}
							}
						}
					}
					energy[y][x] += robot[y][x];
				}
			}
//			for(int y=0; y<n; y++) {
//				for(int x=0; x<n; x++) {
//					System.out.print(map[y][x].toString()+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		int count = 0;
		for(int y=0; y<n; y++) {
			for(int x=0; x<n; x++) {
//				System.out.println(map[y][x].size());
				count+=map[y][x].size();
			}
		}
		
		System.out.println(count);
	}
}