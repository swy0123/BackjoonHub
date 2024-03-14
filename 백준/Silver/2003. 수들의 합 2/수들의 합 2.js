const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n');

const [N, M] = input[0].trim().split(' ').map(Number);
const arr = input[1].trim().split(' ').map(Number);
for(let i=1; i<arr.length; i++){
    arr[i] = arr[i-1]+arr[i];
}
arr.unshift(0);

let start=0, end = 1, cnt = 0;

while(end<arr.length){
    if(arr[end] - arr[start]>M){
        start++;
    }
    else if(arr[end] - arr[start]<M){
        end++;
    }
    else if(arr[end] - arr[start]===M){
        cnt++;
        start++;
    }
}
console.log(cnt);