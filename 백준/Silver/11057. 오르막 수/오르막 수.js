const fs = require("fs");
const input = parseInt(fs.readFileSync("/dev/stdin").toString().trim());

const dp = Array.from(Array(10), ()=>new Array(input+1).fill(0));

for(let i=0; i<10; i++){
    dp[i][1] = 1;
}

for(let i=2; i<=input; i++){
    dp[9][i] = 1;
    for(let j=8; j>=0; j--){
        dp[j][i] = (dp[j+1][i] + dp[j][i-1])%10007;
    }
}
let ret = 0;
for(let i=0; i<10; i++){
    ret += dp[i][input];
}
console.log(ret%10007);