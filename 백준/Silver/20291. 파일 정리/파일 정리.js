const fs = require('fs');
const [n, ...arr] = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const map = {};
const answer = [];

for (let line of arr) {
  const [name, tmp] = line.trim().split('.');
  map[tmp] ? map[tmp]++ : (map[tmp] = 1);
}

const res = Object.keys(map).sort();

for (let key of res) {
  answer.push(`${key} ${map[key]}`);
}

console.log(answer.join('\n'));