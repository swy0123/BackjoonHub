const fs = require('fs');
// const input = fs.readFileSync('./input.txt').toString().trim().split('\n');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
let n = parseInt(input[0]);
let str = input[1];

let idx = 1;
let cnt = 1;
if(str.charAt(0)==='B'){
    while(idx<str.length){
        if(str.charAt(idx)==='R' && str.charAt(idx)!=str.charAt(idx-1)) cnt++;
        idx++;
    }
    console.log(cnt);
}
else {
    while(idx<str.length){
        if(str.charAt(idx)==='B' && str.charAt(idx)!=str.charAt(idx-1)) cnt++;
        idx++;
    }
    console.log(cnt);
}