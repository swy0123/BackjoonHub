const fs = require('fs');
// const input = fs.readFileSync('./input.txt').toString().trim().split('\n');
const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n');

let array = input[1].trim().split(' ').map(Number);

let arr = []
array.forEach((val, idx)=>{
    arr.push({val:val, idx:idx});
});
arr.sort((a, b)=>{return a.val-b.val})

let min = Math.abs(arr[0].val+arr[1].val+arr[arr.length-1].val);
let ret = [0, 1, arr.length-1];

L: for(let i=0; i<arr.length-2; i++){
    let [start, mid, end] = [i, i+1, arr.length-1];
    let cur = arr[start].val + arr[mid].val + arr[end].val;
    if(min>Math.abs(cur)){
        min = Math.abs(cur);
        ret = [start, mid, end];
    }
    while(mid<end){
        if(cur>0) end--;
        if(cur<0) mid++;
        if(cur===0){
            ret = [start, mid, end];
            break L;
        }
        if(mid>=end) break;
        cur = arr[start].val + arr[mid].val + arr[end].val;
        if(min>Math.abs(cur)){
            min = Math.abs(cur);
            ret = [start, mid, end];
        }
    }
}
let answer = [arr[ret[0]].val, arr[ret[1]].val, arr[ret[2]].val];
answer.sort((a, b)=>{return a-b});
console.log(answer.join(' '));