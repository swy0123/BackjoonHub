import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        int t = 1;
        int idx = 1;

        while (t <= T) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<int[]> arr = new ArrayList<>();
            while (n-- > 0) {
                idx++;
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr.add(new int[]{x, y});
            }
            idx++;
            String[] numsStr = br.readLine().split(" ");
            int m = Integer.parseInt(numsStr[0]);
            int[] nums = new int[m];
            for (int i = 0; i < m; i++) {
                nums[i] = Integer.parseInt(numsStr[i + 1]);
            }
            arr.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
            idx++;
            t++;
            int startY = 0, curX = 0, curIdx = 0;
            ArrayList<int[]> ret = new ArrayList<>();
            while (curIdx < arr.size()) {
                curX = arr.get(curIdx)[0];
                int si = curIdx, ei = curIdx;
                while (curIdx < arr.size() && arr.get(curIdx)[0] == curX) {
                    curIdx++;
                }
                ei = curIdx;
                if (arr.get(si)[1] == startY) {
                    for (int i = si; i < ei; i++) {
                        ret.add(arr.get(i));
                    }
                    startY = arr.get(ei - 1)[1];
                } else {
                    for (int i = ei - 1; i >= si; i--) {
                        ret.add(arr.get(i));
                    }
                    startY = arr.get(si)[1];
                }
            }
            for (int num : nums) {
                int[] point = ret.get(num - 1);
                System.out.println(point[0] + " " + point[1]);
            }
        }
        br.close();
            
    }
}