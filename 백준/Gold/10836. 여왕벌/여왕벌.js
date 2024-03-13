const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n');

const [M, N] = input[0].trim().split(' ').map(Number);
const size = Array(input[1].trim().split(' ').map(Number).reduce((sum, val)=>sum+val, 0,)).fill(N);
const map = Array.from(Array(M), ()=>Array(M).fill(1));
for(let i=1; i<=N; i++){
    const days = input[i].trim().split(' ').map(Number);
    for(let i=0; i<days[0]; i++){
        size[i]--;
    }
    for(let i=0; i<days[2]; i++){
        size[size.length-1-i]++;
    }
}
// console.log(size);
let idx = 0;
for(let i=M-1; i>=0; i--){
    map[i][0] += size[idx];
    idx++;
}
for(let i=1; i<M; i++){
    map[0][i] += size[idx];
    idx++;
}

for(let i=1; i<M; i++){
    for(let j=1; j<M; j++){
        map[i][j] = Math.max(map[i-1][j], map[i][j-1], map[i-1][j-1]);
    }
}
for(let i=0; i<M; i++){
    console.log(map[i].join(' '));
}