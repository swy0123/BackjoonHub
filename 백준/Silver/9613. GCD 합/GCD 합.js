const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const testCase = parseInt(input[0]);
const gcd = (a, b) =>{
    if(a%b===0) return b;
    else return gcd(b, a%b);
}

for(let t=1; t<=testCase; t++){
    let [n, ...tmp] = input[t].trim().split(' ').map(Number);
    tmp.sort();
    let len = tmp.length;
    let max = 0;
    for(let i=0; i<len-1; i++){
        for(let j=i+1; j<len; j++){
            max += gcd(tmp[j], tmp[i]);
        }
    }
    console.log(max);
}