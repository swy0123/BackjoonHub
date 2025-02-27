const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('');

let tmp = 0
let len = input.length
let index = 0

while(index < len){
    tmp++
    let str = String(tmp)
    for(let i=0; i<str.length; i++){
        if(str[i] === input[index]) index++;
    }
}

console.log(tmp)