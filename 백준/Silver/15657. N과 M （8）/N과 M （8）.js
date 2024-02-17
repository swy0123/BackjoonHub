let fs = require('fs');
// let input = fs.readFileSync('./input.txt').toString().trim().split('\n');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
let nm = input[0].split(" ").map(Number);
let arr = input[1].split(" ").map(Number).sort((a,b)=>a-b);
let ret = [];
function solve(idx, depth, str){
    if(depth===nm[1]){
        ret.push(str.join(' '))
    }
    else{
        for(let i=idx; i<nm[0]; i++){
            str.push(arr[i]);
            solve(parseInt(i), parseInt(depth+1), str);
            str.pop();
        }
    }
}
solve(parseInt(0), parseInt(0), []);
console.log(ret.join('\n'));