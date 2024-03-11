const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim();

let res = [];

let n = parseInt(input);
let num = 2;

while(n>0){
    if(n%num<=parseInt(num/2) && n%num!==0){
        res.push('4');
    }
    else res.push('7');
    n-=num;
    num *= 2;
}

console.log(res.reverse().join(''));