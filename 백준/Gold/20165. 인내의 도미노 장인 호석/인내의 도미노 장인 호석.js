const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const [N, M, R] = input[0].trim().split(' ').map(Number);

const d = {E:{x:1, y:0}, W:{x:-1, y:0}, S:{x:0, y:1}, N:{x:0, y:-1}};
const v = Array.from(Array(N), ()=>Array(M).fill('S'));
const map = [];
let idx = 1;
for(let i=1; i<=N; i++){
    map.push(input[i].trim().split(' ').map(Number));
    idx++;
}
let max = 0;

for(let i=idx; i<idx+R*2; i+=2){
    const attack = input[i].trim().split(' ').map(v=>v);
    const dpos = input[i+1].trim().split(' ').map(Number);

    apos = [parseInt(attack[0])-1, parseInt(attack[1])-1];

    if(v[apos[0]][apos[1]]==='S'){
        v[apos[0]][apos[1]] = 'F';
        max++;
        const next = [{x:apos[1], y:apos[0], max:map[apos[0]][apos[1]]}];
        while(next.length>0){
            const node = next.shift();
            let ni, nj;
            for(let i=1; i<map[node.y][node.x]; i++){
                nx = node.x+d[`${attack[2]}`].x*i;
                ny = node.y+d[`${attack[2]}`].y*i;
                if(ny>=0 && ny<N && nx>=0 && nx<M && v[ny][nx]==='S'){
                    v[ny][nx] = 'F';
                    max++;
                    if(map[ny][nx]>node.max-i){
                        next.push({x:nx, y:ny, max:map[ny][nx]});
                    }
                }
            }
        }
    }

    if(v[dpos[0]-1][dpos[1]-1] === 'F'){
        v[dpos[0]-1][dpos[1]-1] = 'S';
    }
}

console.log(max);
for(let i=0; i<N; i++){
    console.log(v[i].join(' '));
}