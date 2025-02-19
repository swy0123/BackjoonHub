const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const [n, m] = input[0].trim().split(' ').map(Number)
const MAX_INTEGER = 10000

const map = Array.from({length: n}, ()=> new Array(m))
const dp = Array.from({length: n}, ()=> Array.from({length: m}, ()=> new Array(3).fill(MAX_INTEGER)))

for(let i=0; i<n; i++){
    map[i] = input[i+1].trim().split(' ').map(Number)
}
for(let i=0; i<m; i++){
    dp[0][i][0] = map[0][i]
    dp[0][i][1] = map[0][i]
    dp[0][i][2] = map[0][i]
}

for(let i=1; i<n; i++){
    for(let j=0; j<m; j++){        
        if(j-1>=0){
            dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2])+map[i][j]
        }
        dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2])+map[i][j]
        if(j+1<m){
            dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1])+map[i][j]
        }
    }
}

let min = MAX_INTEGER

for(let i=0; i<m; i++){
    min = Math.min(min, ...dp[n-1][i])
}
console.log(min);