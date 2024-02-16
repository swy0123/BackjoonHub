let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n').map(Number);
// let input = fs.readFileSync('./input.txt').toString().trim().split('\n').map(Number);

let n = input[0];
let ds = input[1];
let arr = input.slice(2);
if(arr.length === 0){
    console.log(0);
}
else {
    let res=0;
    let max = Math.max(...arr);
    while(ds <= max){
        arr[arr.indexOf(max)]--;
        ds++;
        res++;
        max = Math.max(...arr);
    }
    console.log(res);
}