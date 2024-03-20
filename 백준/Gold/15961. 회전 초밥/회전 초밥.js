const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let [N, d, k, c] = input[0].trim().split(' ').map(Number);
const arr = [];

for(let i=1; i<=N; i++){
    arr.push(parseInt(input[i].trim()));
}
const kind = new Map();

let start = 0;
let end = k;

for(let i=0; i<k; i++){
    if(kind.has(arr[i])){
        kind.set(arr[i], kind.get(arr[i])+1);
    }
    else  {
        kind.set(arr[i], 1);
    }
    arr.push(arr[i]);
}
let max = kind.size;
while(end < arr.length){
    if(kind.get(arr[start])>1){
        kind.set(arr[start], kind.get(arr[start])-1);
    }
    else{
        kind.delete(arr[start]);
    }
    start++;
    if(kind.has(arr[end])){
        kind.set(arr[end], kind.get(arr[end])+1);
    }
    else{
        kind.set(arr[end], 1);
    }
    end++;

    let cur = kind.size;
    if(!kind.has(c)) cur++;
    max = Math.max(max, cur);
}

console.log(max);