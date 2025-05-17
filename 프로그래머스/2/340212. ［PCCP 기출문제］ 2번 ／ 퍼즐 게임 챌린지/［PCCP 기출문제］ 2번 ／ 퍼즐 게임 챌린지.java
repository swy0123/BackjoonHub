class Solution {
    static class data {
        long time;
        boolean isPass;
        public data(long time, boolean isPass){
            this.time = time;
            this.isPass = isPass;
        }
    }
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        long[] sumArr = new long[times.length];
        for(int i=0; i<times.length; i++){
            if(i==0){
                sumArr[i] = times[i];
            }
            else{
                sumArr[i] = times[i] + times[i-1];
            }
        }
        
        int start = 1;
        int end = 100000;

        while (start <= end) {
            int level = (start + end)/2;
            data tmp = checkPass(diffs, times, limit, level, sumArr);

            if (tmp.isPass && tmp.time<=limit) {
                answer = level;
                end = level - 1;
            } else {
                start = level + 1;
            }
        }
        
        return answer;
    }

    
    public static data checkPass(int[] diffs, int[] times, long limit, int level, long[] sumArr){
        int len = diffs.length;
        long time = 0;
        for(int i=0; i<len; i++){
            if(time > limit) {
                return new data(time, false);
            }
            if(diffs[i] <= level){
                time += times[i];
            }
            else{
                if(i==0){
                    time += (diffs[i]-level) * times[i];
                }
                else{
                    long prev = sumArr[i];
                    time += (diffs[i]-level) * prev + times[i];
                }
            }
        }
        return new data(time, true);
    }
}
