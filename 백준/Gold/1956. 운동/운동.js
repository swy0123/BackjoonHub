const fs = require('fs');
// const input = fs.readFileSync('./input.txt').toString().trim().split('\n');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const [V, E] = input[0].split(' ').map(Number);

let answer = Infinity;
const cost = Array.from(Array(V), () => Array(V).fill(Infinity));

for(let i=1; i<=E; i++){
    const [s, e, c] = input[i].split(' ').map(Number);
    cost[s - 1][e - 1] = c
}

for(let mid=0; mid<V; mid++) {//거쳐가는 지점.
    for(let start=0; start<V; start++) {
        for(let end=0; end<V; end++) {
            if(cost[start][mid] + cost[mid][end] < cost[start][end]) {
                cost[start][end] = cost[start][mid] + cost[mid][end];
            }
        }
    }
}

for(let start=0; start<V; start++) {
    for(let end=0; end<V; end++) {
        if(start === end) continue;
        if(cost[start][end]!==Infinity && cost[end][start]!==Infinity) {
            answer = Math.min(cost[start][end] + cost[end][start], answer)
        }
    }
}

if (answer === Infinity) console.log(-1);
else console.log(answer);