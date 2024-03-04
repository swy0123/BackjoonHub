const fs = require('fs');
// const input = fs.readFileSync('./input.txt').toString().trim().split('\n');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const [n, s, m] = input[0].trim().split(' ').map(Number);
const arr = input[1].trim().split(' ').map(Number);
const dp = Array.from(Array(n+1), () => new Set());
dp[0].add(s);

let ret = 0;
for(let i=1; i<=n; i++){
    dp[i-1].forEach(element => {
        let add = element+arr[i-1], sub = element-arr[i-1];
        if(add>=0 && add<=m) dp[i].add(add);
        if(sub>=0 && sub<=m) dp[i].add(sub);
    });
    if(dp[i].size===0) ret = -1;
}

if(ret === -1) console.log(-1);
else {
    dp[n].forEach(element => {
        ret = element>ret ? element : ret;
    });
    console.log(ret);
}