const fs = require('fs');
// const input = fs.readFileSync('./input.txt').toString().trim().split('\n');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const [T, W] = input[0].trim().split(' ').map(Number);
const arr = []
for(let t=1; t<=T; t++){
    arr.push(parseInt(input[t]));
}

let dp = Array.from(Array(W+1), ()=>Array(T+1).fill(0));

for(let i=1; i<=T; i++){
    if(arr[i-1]===1) dp[0][i] = dp[0][i-1]+1;
    else dp[0][i] = dp[0][i-1];
}
// console.log('0,'+arr.join(','));
for(let i=1; i<=W; i++){
    for(let j=1; j<=T; j++){
        if(i%2===1){
            if(arr[j-1]===2) dp[i][j] = Math.max(dp[i][j-1]+1, dp[i-1][j-1]+1);
            if(arr[j-1]===1) dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-1]);
        }
        if(i%2===0){
            if(arr[j-1]===1) dp[i][j] = Math.max(dp[i][j-1]+1, dp[i-1][j-1]+1);
            if(arr[j-1]===2) dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-1]);
        }
    }
}
// console.log(dp.join('\n'));
console.log(Math.max(dp[W][T], dp[W-1][T]));