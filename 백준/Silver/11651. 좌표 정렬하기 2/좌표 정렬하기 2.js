const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");
const n = parseInt(input[0]);
let arr = [];

for (let i = 1; i <= n; i++) {
  arr.push(input[i].split(" ").map(Number));
}

arr.sort((a, b) => {
  return a[1] !== b[1] ? a[1] - b[1] : a[0] - b[0];
});
let res = '';
arr.forEach(element => {
    res += `${element[0]} ${element[1]}\n`;
});
console.log(res);