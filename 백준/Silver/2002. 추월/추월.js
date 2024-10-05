const fs = require('fs');
const input = fs.readFileSync('dev/stdin').toString().trim().split('\n');
const n = Number(input[0])

const enter = new Set();
const exit = new Set();
for(let i=1; i<=n; i++){
    enter.add(input[i].trim())
}
for(let i=n+1; i<=2*n; i++){
    exit.add(input[i].trim())
}

let res = 0;
for(let cur of enter.values()){
    if(!exit.has(cur)) continue
    for(let tmp of exit.values()){
        exit.delete(tmp);
        if(cur === tmp){
            break;
        }
        else res++;
    }
}
console.log(res);