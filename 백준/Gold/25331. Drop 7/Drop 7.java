import java.util.*;
import java.io.*;

public class Main {
	static class node {
		int x, y;

		public node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.y + " " + this.x;
		}
	}

	static int[][] map;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[7][7];
		for (int i = 0; i < 7; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 7; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int num = Integer.parseInt(br.readLine());

		int res = getResult(num);
		System.out.println(getResult(num));
	}

	static int getResult(int num) {
		int min = count(map) + 1;
		for (int j = 0; j < 7; j++) {
			if (map[0][j] == 0) {
				map[0][j] = num;
				min = Math.min(min, loop(map, j));
				map[0][j] = 0;
			}
		}

		return min;
	}

	static int count(int[][] cur) {
		int ret = 0;
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (cur[i][j] != 0)
					ret++;
			}
		}
//		System.out.println(ret);
		return ret;
	}

	static int loop(int[][] first, int idx) {
		int[][] tmp = down(first);
		int[][] cur = find(tmp);

		while (!isSame(tmp, cur)) {
			tmp = down(cur);
			cur = find(tmp);
//			System.out.println(count(tmp) + " : " + count(cur));

		}
//		System.out.println();
//		for (int i = 0; i < 7; i++) {
//			System.out.println(Arrays.toString(tmp[i]));
//		}
//
//		System.out.println();
//		for (int i = 0; i < 7; i++) {
//			System.out.println(Arrays.toString(cur[i]));
//		}
//		System.out.println("---------");
		return count(cur);
	}

	static boolean isSame(int[][] cur, int[][] target) {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (cur[i][j] != target[i][j])
					return false;
			}
		}
		return true;
	}

	static int[][] find(int[][] cur) {

		int[][] res = new int[7][7];
		for (int i = 0; i < 7; i++) {
			res[i] = cur[i].clone();
		}

		ArrayDeque<node> arr = new ArrayDeque<>();
//		System.out.println("vvvvvvvvvvvvvvvv");
//		for (int i = 0; i < 7; i++) {
//			System.out.println(Arrays.toString(res[i]));
//		}
		for (int i = 0; i < 7; i++) {
			int cnt = 0;
			for (int j = 0; j < 7; j++) {
				if (res[i][j] != 0) {
					cnt++;
				} else {
					if (cnt == 0)
						continue;
					for (int k = j; k >= j - cnt; k--) {
						if (res[i][k] == cnt)
							arr.add(new node(k, i));
					}
					cnt = 0;
				}
				if(j==6) {
					if (cnt == 0)
						continue;
					for (int k = j; k >= j - cnt+1; k--) {
						if (res[i][k] == cnt)
							arr.add(new node(k, i));
					}
				}
			}
		}
		for (int j = 0; j < 7; j++) {
			int cnt = 0;
			for (int i = 0; i < 7; i++) {
				if (res[i][j] != 0) {
					cnt++;
					if (cnt == 7) {
						for (int k = 0; k < 7; k++) {
							if (res[k][j] == cnt)
								arr.add(new node(j, k));
						}
					}
				} else {
					if (cnt == 0)
						continue;
					for (int k = i; k >= i - cnt; k--) {
						if (res[k][j] == cnt)
							arr.add(new node(j, k));
					}
					cnt = 0;
				}
				if(i==6) {
					if (cnt == 0)
						continue;
					for (int k = i; k >= i - cnt+1; k--) {
						if (res[k][j] == cnt)
							arr.add(new node(j, k));
					}
				}
			}
		}
//		System.out.println(arr.toString());
		while (!arr.isEmpty()) {
			node cn = arr.poll();
			res[cn.y][cn.x] = 0;
		}
//		for (int i = 0; i < 7; i++) {
//			System.out.println(Arrays.toString(res[i]));
//		}
//		System.out.println("^^^^^^^^^^^");
		return res;
	}

	static int[][] down(int[][] cur) {

		int[][] res = new int[7][7];
		for (int i = 0; i < 7; i++) {
			res[i] = cur[i].clone();
		}
		for (int j = 0; j < 7; j++) {
			for (int i = 6; i >= 0; i--) {
				if (res[i][j] == 0) {
					for (int k = i - 1; k >= 0; k--) {
						if (res[k][j] != 0) {
							res[i][j] = res[k][j];
							res[k][j] = 0;
							break;
						}
					}
				}
			}
		}

		return res;
	}
}