const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const n = Number(input[0].trim())
const m = Number(input[1].trim())
const arr = input[2].trim().split(' ').map(Number)


const getRet = () => {
    let max = 0
    for(let i=0; i<m; i++){
        if(i===0){
            max = Math.max(max, arr[i])
        }
        else{
            max = Math.max(max, Math.ceil((arr[i]-arr[i-1]) / 2))
        }
        if(i===m-1){
            max = Math.max(max, n-arr[i])
        }
    }
    return max
}

console.log(getRet())