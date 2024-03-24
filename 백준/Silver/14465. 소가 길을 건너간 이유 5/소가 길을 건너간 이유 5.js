const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const [n, k, b] = input[0].trim().split(' ').map(Number);
let arr = Array(n).fill(true); 

for(let i=1; i<=b; i++){
    arr[parseInt(input[i])-1] = false;
}

let [start, end, cnt, min] = [0, k-1, 0, 0];
for(let i=0; i<k; i++){
    if(!arr[i]) cnt++;
}
min = cnt;
while(end < n){
    end++;
    if(!arr[start]) cnt--;
    if(!arr[end]) cnt++;
    start++;
    min = Math.min(min, cnt);
}
console.log(min);