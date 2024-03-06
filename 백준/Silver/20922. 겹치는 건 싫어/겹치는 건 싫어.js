const fs = require('fs');
// const input = fs.readFileSync('./input.txt').toString().trim().split('\n');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const [n, k] = input[0].trim().split(' ').map(Number);
const arr = input[1].trim().split(' ').map(Number);
let start = 0, end = 0, max = 0;
const cnt = Array(100001).fill(0);
while(end<arr.length){
    if(cnt[arr[end]]<k){
        cnt[arr[end]]++;
        end++;
    } 
    else{
        max = Math.max(max, end-start);
        cnt[arr[start]]--;
        start++;
    }
}
max = Math.max(max, end-start);
console.log(max);