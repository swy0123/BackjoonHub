const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let n = parseInt(input[0]);
let arr = input[1].trim().split(' ').map(Number);

let [a, b] = [-200, 0];
let ret = new Set();
L: while(a<200){
    b = 0;
    if(arr.length>1){
        b = arr[1] - arr[0]*a;
    }
    for(let i=1; i<arr.length; i++){
        if(arr[i-1]*a+b!==arr[i]){
            a++;
            continue L;
        }
    }
    ret.add(arr[arr.length-1]*a+b);
    if(ret.size>1) break L;
    a++;
}

if(ret.size>1 || arr.length===1) console.log('A');
else if(ret.size===1) console.log([...ret][0]);
else console.log('B');