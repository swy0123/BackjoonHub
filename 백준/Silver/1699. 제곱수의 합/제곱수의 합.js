const fs = require('fs');
const n = parseInt(fs.readFileSync('/dev/stdin').toString().trim());

let dp = Array(n+1).fill(0);
for(let i=1; i<=n; i++){
    dp[i] = i;
}
for(let i=2; i<=n; i++){
    let idx = 1;
    while(idx*idx<=n){
        if(dp[i]>dp[i-idx*idx]+1) dp[i] = dp[i-idx*idx]+1;
        idx++;
    }
}

console.log(dp[n]);