let input = require('fs').readFileSync("/dev/stdin").toString().trim().split('\n');
let n = Number(input[0]);
const ret = [];

function solve(sarr, data, idx, result) {
    if (idx === sarr.length) {
        // console.log(result);
        ret.push(result)
        return;
    }
    for (let i in data) {
        if (data[i] > 0) {
            data[i]--;
            solve(sarr, data, idx + 1, result + i);
            data[i]++;
        }
    }
}

function init(input) {
    const sarr = input.trim().split('').sort();
    const data = {};
    for (let char of sarr) {
        data[char] = data[char] ? data[char] + 1 : 1;
    }
    solve(sarr, data, 0, "");
}
for (let i = 1; i <= n; i++) {
    init(input[i]);
}

console.log(ret.join('\n'));