function solution(n, money) {
    var answer = 0;
    
    let len = money.length;
    let dp = new Array(n+1).fill(0);
    dp[0] = 1;
    for(let i=0; i<len; i++){
        for(let j=money[i]; j<=n; j++){
            dp[j] = (dp[j]+dp[j-money[i]]) % 1_000_000_007;
        }
    }
    answer = dp[n];
    
    return answer;
}