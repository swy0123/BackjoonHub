const fs = require('fs');
// const input = fs.readFileSync('./input.txt').toString().trim().split('\n');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const n = parseInt(input[0]);

for(let t=0; t<n; t++){
    const n = parseInt(input[t*2+1]);

    const arr = input[t*2+2].trim().split(' ').map(Number);
    const dp = Array(n).fill(0);
    dp[0] = arr[0];
    for(let i=1; i<n; i++){
        if(dp[i-1]>0){
            dp[i] = dp[i-1]+arr[i];
        }
        else{
            dp[i] = arr[i];
        }
    }
    console.log(Math.max(...dp));
}