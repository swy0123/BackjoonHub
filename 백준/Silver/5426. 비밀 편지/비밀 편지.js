const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const n = Number(input[0].trim())

function solve(str) {
    let result = ''
    const len = Math.sqrt(str.length)
    for (let i=len-1; i>=0; i--) {
        for (let j=0; j<len; j++) {
            result += str.charAt(j*len + i)
        }
    }
    return result
}
for(let i=1; i<=n; i++){
    console.log(solve(input[i].trim()))
}