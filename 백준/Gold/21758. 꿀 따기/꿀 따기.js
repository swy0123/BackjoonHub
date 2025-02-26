const { log } = require("console");
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const n = Number(input[0].trim())
input[1] = input[1].trim().split(' ').map(Number)

const sum1 = Array.from({length: n}, ()=>0)
const sum2 = Array.from({length: n}, ()=>0)
const get = Array.from({length: n}, ()=>0)

let maxSum = 0;
let maxNum = 0;
let maxIdx = 0;

for(let i=1; i<n; i++){
    sum1[i] = input[1][i] + sum1[i-1];
    sum2[n-i-1] = input[1][n-i-1] + sum2[n-i];
    if(input[1][i] > maxNum){
        maxNum = input[1][i]
        maxIdx = i
    }
}
maxSum = sum1[maxIdx] + sum2[maxIdx]


const getAnswer = (start)=>{
    if(start === 0){
        let sec = 0
        for(let i=0; i<n; i++){
            get[i] = sum1[n-1] - sum1[i];
            if(i!==0){
                sec = Math.max(sec, get[i]-input[1][i])
            }
        }
        maxSum = Math.max(maxSum, get[0]+sec)
    }
    if(start === n){
        let sec = 0
        for(let i=n-1; i>=0; i--){
            get[i] = sum2[0] - sum2[i];
            if(i!==n-1){
                sec = Math.max(sec, get[i]-input[1][i])
            }
        }
        maxSum = Math.max(maxSum, get[n-1]+sec)
    }
}

getAnswer(0)
getAnswer(n)

console.log(maxSum)