const fs = require('fs');
// const input = fs.readFileSync('./input.txt').toString().trim().split('\n');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const n = parseInt(input[0]);

const arr = [];
for(let i=1; i<=n; i++){
    arr.push(input[i].trim().split(''));
}
let ret = 0;
for(let i=0; i<n; i++){
    if(arr[i].length%2!==0) continue;
    else {
        let st = [];
        for(let j=0; j<arr[i].length; j++){
            const top = st[st.length-1];
            const cur = arr[i][j];
            if(top===cur) st.pop();
            else st.push(cur)
        }
        if(st.length===0) ret++;
    }
}

console.log(ret);