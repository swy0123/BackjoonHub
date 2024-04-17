let input = require("fs").readFileSync('dev/stdin').toString().trim();

let n = parseInt(input);

let answer = 0;
if(n%2===1) console.log(0);
else{
    const dp = Array.from(n+1);
    dp[0] = 0;
    dp[1] = 0;
    dp[2] = 3;
    dp[3] = 0;

    for(let i=4; i<=n; i++){
        if(i%2===1) continue;
        dp[i] = dp[i-2]*3+2;
        for(let j=2; j<i-2; j+=2){
            dp[i] += dp[j]*2;
        }
    }

    console.log(dp[n]);
}