let input = require('fs').readFileSync("/dev/stdin").toString().trim().split('\n');
let n = Number(input[0]);
const arr = [];
const ret = [];

for(let i=1; i<=n; i++){
    const tmp = input[i].trim().split(' ');
    if(tmp[0]==='push'){
        arr.push(Number(tmp[1]));
    }
    else if(tmp[0]==='pop'){
        ret.push(arr.length>0?arr.shift():-1);
    }
    else if(tmp[0]==='size'){
        ret.push(arr.length)
    }
    else if(tmp[0]==='empty'){
        ret.push(arr.length===0?1:0)
    }
    else if(tmp[0]==='front'){
        ret.push(arr.length>0?arr[0]:-1)
    }
    else if(tmp[0]==='back'){
        ret.push(arr.length>0?arr[arr.length-1]:-1)
    }
}

console.log(ret.join('\n'));