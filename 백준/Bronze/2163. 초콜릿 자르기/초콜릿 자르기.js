const fs = require('fs')
const [n, m] = fs.readFileSync('/dev/stdin').toString().trim().split(' ')

if(n === m) console.log(n**2 - 1);
else console.log(n * m - 1);