const fs = require("fs");
// const input = fs.readFileSync("./input.txt").toString().trim().split("\n");
const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n');

const [n, m] = input[0].trim().split(" ").map(Number);

const dy = [-1, 1, 0, 0];
const dx = [0, 0, -1, 1];
let map = [];
let min = 2500;
let virus = [];

for (let i = 1; i <= n; i++) {
  map.push(input[i].trim().split(" ").map(Number));
}

for (let i = 0; i < n; i++) {
  for (let j = 0; j < n; j++) {
    if (map[i][j] === 2) {
      virus.push({ y: i, x: j });
    }
  }
}

const solve = (depth, idx, arr) => {
  if (depth === m) {
    const ret = bfs(arr);
    // console.log(ret);
    if (ret !== -1) {
      min = ret < min ? ret : min;
    }
    return;
  }

  for (let i = idx; i <= virus.length - m + depth; i++) {
    const tmp = [...arr];
    tmp.push(virus[i]);
    solve(depth + 1, i + 1, tmp);
  }
};
const bfs = (list) => {
  const q = [];
  const v = Array.from(Array(n), () => new Array(n).fill(0));
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (map[i][j] === 0) {
        v[i][j] = -1;
      }
      if (map[i][j] === 1) {
        v[i][j] = -2;
      }
      if (map[i][j] === 2) {
        v[i][j] = -3;
      }
    }
  }
//   console.log(map.join('\n'));
//   console.log(v.join('\n'), q);
  list.forEach((el) => {
    q.push(el);
    v[el.y][el.x] = 0;
  });

  while (q.length > 0) {
    const cn = q.shift();

    for (let d = 0; d < 4; d++) {
      const ny = cn.y + dy[d];
      const nx = cn.x + dx[d];
      if (ny >= 0 && ny < n && nx >= 0 && nx < n && v[ny][nx] !== -2) {
        if (v[ny][nx] === -3) {
          v[ny][nx] = v[cn.y][cn.x]+1;
          q.push({ y: ny, x: nx });
        }
        if (v[ny][nx] === -1 || v[ny][nx]> v[cn.y][cn.x]+1) {
          v[ny][nx] = v[cn.y][cn.x] + 1;
          q.push({ y: ny, x: nx });
        }
      }
    }
  }
  let tmp = 0;
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (v[i][j] === -1) return -1;
      if(v[i][j]>=0 && map[i][j]===2) continue;
      tmp = Math.max(tmp, v[i][j]);
    }
  }
//   console.log(v.join('\n'));
  return tmp;
};

solve(0, 0, []);
if(min===2500) console.log(-1);
else console.log(min);
// console.log(map.join('\n'));