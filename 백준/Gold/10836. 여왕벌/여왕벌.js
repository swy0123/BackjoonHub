const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n');

const [M, N] = input[0].trim().split(' ').map(Number);
const map = Array.from(Array(M), ()=>Array(M).fill(1));
const days = [];

for(let i=1; i<=N; i++){
    days.push(input[i].trim().split(' ').map(Number));
}

for(let i=0; i<N; i++){
    for(j=M-1; j>0; j--){
        if(days[i][0] !== 0){
            days[i][0]--;
        }
        else if(days[i][1] !== 0){
            days[i][1]--;
            map[j][0] += 1;
        }
        else if(days[i][2] !== 0){
            days[i][2]--;
            map[j][0] += 2;
        }
    }

    for(j=0; j<M; j++){
        if(days[i][0] !== 0){
            days[i][0]--;
        }
        else if(days[i][1] !== 0){
            days[i][1]--;
            map[0][j] += 1;
        }
        else if(days[i][2] !== 0){
            days[i][2]--;
            map[0][j] += 2;
        }
    }
}

for(let i=1; i<M; i++){
    for(let j=1; j<M; j++){
        map[i][j] = Math.max(map[i-1][j], map[i][j-1], map[i-1][j-1]);
    }
}


for(let i=0; i<M; i++){
    console.log(map[i].join(' '));
}