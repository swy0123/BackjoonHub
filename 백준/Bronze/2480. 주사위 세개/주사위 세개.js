const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split(" ").map(Number);

const arr = Array(7).fill(0);
input.forEach(element => {
    arr[element]++;
});

let sum =0;
for(let i=1; i<=6; i++){
    if(arr[i]===3){
        sum = 10000+i*1000;
        break;
    }
    if(arr[i]===2){
        sum = 1000+i*100;
        break;
    }
    if(arr[i]===1){
        sum = Math.max(i*100, sum);
    }
}
console.log(sum);