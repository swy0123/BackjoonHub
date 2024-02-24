const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split(' ').map(Number);
const sum = (a, b) => {return a+b};
console.log(input.reduce(sum, 0));