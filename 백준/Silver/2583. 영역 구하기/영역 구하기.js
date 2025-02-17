const fs = require('fs');
// const input = fs.readFileSync('./input.txt').toString().trim().split('\n');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const [m, n, k] = input[0].trim().split(' ').map(Number);
const board = Array.from({length: m}, ()=>new Array(n).fill(false));
let i, j;
for(i=1; i<=k; i++){
    const [x1, y1, x2, y2] = input[i].trim().split(' ').map(Number);
    let x, y;
    for(x=x1; x<x2; x++){
        for(y=y1; y<y2; y++){
            if(!board[y][x]) board[y][x] = true;
        }
    }
}
const dx = [-1, 1, 0 ,0];
const dy = [0, 0 ,-1, 1];

const bfs = (x, y) =>{
    const q = [];
    let cnt = 1;
    q.push({x:x, y:y})

    while(q.length!==0){
        const cn = q.shift();
        if(board[cn.y][cn.x])
        for(let d=0; d<4; d++){
            const nx = cn.x+dx[d];
            const ny = cn.y+dy[d];
            if (ny >= 0 && ny < m && nx >= 0 && nx < n && !board[ny][nx]){
                board[ny][nx] = true;
                cnt++;
                q.push({x:nx, y:ny});
            }
        }
    }
    return cnt;
}
let ret = 0;
let ansList = []
for(i=0; i<m; i++){
    for(j=0; j<n; j++){
        if(!board[i][j]){
            board[i][j] = true
            ret++;
            ansList.push(bfs(j, i));
        }
    }
}
console.log(ret);
console.log(ansList.sort((a, b)=>a-b).join(' '));