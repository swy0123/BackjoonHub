let input = require("fs").readFileSync('dev/stdin').toString().trim().split("\n");
const n = parseInt(input[0]);
const k = parseInt(input[1]);

const inputArr = input[2].trim().split(" ").map(Number);
const set = Array.from(new Set(inputArr)).sort((a, b) => a - b);;
const arr = [];
const cnt = set.length;

for(let i=0; i<cnt-1; i++){
    arr.push(set[i+1]-set[i]);
}
arr.sort((a, b) => b-a);
let ret=0;
for(let i=k-1; i<cnt-1; i++){
    ret += arr[i];
}
console.log(ret);