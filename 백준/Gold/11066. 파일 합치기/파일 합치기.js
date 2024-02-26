const fs = require('fs');
// const input = fs.readFileSync('./input.txt').toString().trim().split('\n');
const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n');

const T = parseInt(input[0]);

for(let t=0; t<T; t++){
    let k = parseInt(input[t*2+1]);
    let arr = input[t*2+2].split(' ').map(Number);
    let sum = [arr[0]];
    let dp = Array.from(Array(k), ()=> new Array(k).fill(0));
    // console.log(arr);
    for(let i=0; i<k-1; i++){
        sum[i+1] = sum[i]+arr[i+1];
        dp[i][i+1] = arr[i]+arr[i+1];
    }
    // console.log(dp, sum);
    for(let len=2; len<k; len++){
        for(let i=0; i<k; i++){
            if(i+len >= k) break;
            for(let j=i; j<i+len; j++){
                let cost = 0;
                if(i===0) cost = sum[i+len];
                else cost = sum[i+len] - sum[i-1];
                if(dp[i][i+len]===0) dp[i][i+len] = dp[i][j] + dp[j+1][i+len] + cost;
                else dp[i][i+len] = Math.min(dp[i][i+len], dp[i][j]+dp[j+1][i+len]+cost);
            }
        }
    }
    console.log(dp[0][k-1]);
}