const fs = require('fs');
const [a, b] = fs.readFileSync(0, 'utf-8').toString().trim().split('\n').map(Number);
let ret = 0;
if(a>0 && b>0) ret = 1;
if(a<0 && b>0) ret = 2;
if(a<0 && b<0) ret = 3;
if(a>0 && b<0) ret = 4;
console.log(ret);