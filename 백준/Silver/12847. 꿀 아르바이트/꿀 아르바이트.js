let input = require("fs").readFileSync('dev/stdin').toString().trim().split('\n');

let [n, m] = input[0].split(' ').map(Number);
let arr = input[1].split(' ').map(Number);
let sum = [arr[0]];
for(let i=0; i<n-1; i++){
    sum.push(sum[i]+arr[i+1]);
}

let cur = sum[m-1];
let max = cur;
for(let i=m; i<n; i++){
    max = Math.max(max, sum[i]-sum[i-m]);
}

console.log(max);