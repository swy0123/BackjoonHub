const fs = require('fs');
// const input = fs.readFileSync('./input.txt').toString().trim().split('\n');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
for(let t=0; t<parseInt(input[0]); t++){
    let [n, m] = input[t*2+1].split(' ').map(Number);
    let arr = [];
    input[t*2+2].split(' ').map(Number).forEach((val, idx)=>{
        arr.push({val:val, idx:idx});
    })
    let max;
    let idx = 0;
    let cnt = 0;
    while(arr.length>0){
        max = arr.reduce((prev, cur)=>{
            return prev.val > cur.val ? prev : cur
        });
        if(arr[idx].val === max.val){
            cnt++;
            if(arr[idx].idx === m) break;
            arr.splice(idx, 1);
        }
        else idx++;
        if(idx===arr.length) idx = 0;
    }
    console.log(cnt);
}