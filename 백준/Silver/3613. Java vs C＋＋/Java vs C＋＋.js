const fs = require('fs');
// const str = fs.readFileSync('./input.txt').toString().trim().split('');
const str = fs.readFileSync('/dev/stdin').toString().trim().split('');
const lower = 'abcdefghijklmnopqrstuvwxyz'.split('');
const upper = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'.split('');
let ret = [];
let idx = 0;
let isJava = false, isC = false, isError = false;
while(idx<str.length){
    if(lower.includes(str[idx])){
        ret.push(str[idx]);
    }
    else if(str[idx]==='_'){
        idx++;
        if(!lower.includes(str[idx]) || idx===1){
            isError = true;
            break;
        }
        if(!isC) isC = true;
        ret.push(str[idx].toUpperCase());
    }
    else if(upper.includes(str[idx])){
        if(idx===0){
            isError = true;
            break;
        }
        if(!isJava) isJava = true;
        ret.push('_');
        ret.push(str[idx].toLowerCase());
    }
    idx++;
    if(isC && isJava){
        isError = true;
        break;
    }
}
if(!isError) console.log(ret.join(''));
else console.log("Error!");