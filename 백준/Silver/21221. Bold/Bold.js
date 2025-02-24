const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const [n, m] = input[0].trim().split(' ').map(Number)

const board = Array.from({length: n},)
const ret = Array.from({length: n}, ()=>Array(m).fill('.'))

for(let i=0; i<n; i++){
    board[i] = [...input[i+1].trim().split('')]
}

for(let i=0; i<n; i++){
    for(let j=0; j<m; j++){
        if(board[i][j] === '#'){
            ret[i][j] = '#' 
            if(i+1<n) ret[i+1][j] = '#'
            if(j+1<m) ret[i][j+1] = '#'
            if(i+1<n && j+1<m) ret[i+1][j+1] = '#'
        }
    }
}

console.log(ret.map(row=>row.join('')).join('\n'))