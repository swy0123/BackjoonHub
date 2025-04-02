const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim();

const n = parseInt(input) + 1000000
const MOD = 1000000000

let dp = new Array(2000001).fill(0)
dp[1000001] = 1

if (n<1000000) {
    for (let i=999999; i>=n; i--) {
        dp[i] = (dp[i+2] - dp[i+1]) % MOD
    }
} else {
    for (let i=1000002; i<=n; i++) {
        dp[i] = (dp[i-1] + dp[i-2]) % MOD
    }
}

const printResult = (dp, n) => {
    if (dp[n] > 0) {
        console.log(1)
    } else if (dp[n] === 0) {
        console.log(0)
    } else {
        console.log(-1)
    }
    console.log(Math.abs(dp[n]))
}

printResult(dp, n)