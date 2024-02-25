const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n');

const nextUp = ["|", "+", "1", "4", ".", "Z"];
const nextDown = ["|", "+", "2", "3", ".", "Z"];
const nextLeft = ["-", "+", "1", "2", ".", "Z"];
const nextRight = ["-", "+", "3", "4", ".", "Z"];

const up = [-1, 0];
const down = [1, 0];
const left = [0, -1];
const right = [0, 1];

let [n, m] = input[0].trim().split(" ").map(Number);
let map = [];

let mi, mj, zi, zj;
for (let i = 0; i < n; i++) {
  map.push(input[i + 1].trim().split(""));
  for (let j = 0; j < map[0].length; j++) {
    if (map[i][j] === "M") {
      mi = i;
      mj = j;
    }
    if (map[i][j] === "Z") {
      zi = i;
      zj = j;
    }
  }
}

let q = [];
q.push({ i: mi, j: mj, from: "", to: "", type: "" });
while (q.length > 0) {
  let cn = q.shift();
  let ci = cn.i;
  let cj = cn.j;
  let from = cn.to;
  if (cn.to === "up") from = "down";
  if (cn.to === "down") from = "up";
  if (cn.to === "right") from = "left";
  if (cn.to === "left") from = "right";
  if (map[ci][cj] === "M" || map[ci][cj] === ".") {
    let [upi, upj] = [ci - 1, cj];
    let [downi, downj] = [ci + 1, cj];
    let [lefti, leftj] = [ci, cj - 1];
    let [righti, rightj] = [ci, cj + 1];
    let checkUp = upi >= 0 && upi < n && upj >= 0 && upj < m && map[upi][upj] !== "." && map[upi][upj] !== "Z";
    let checkDown = downi >= 0 && downi < n && downj >= 0 && downj < m && map[downi][downj] !== "." && map[downi][downj] !== "Z";
    let checkLeft = lefti >= 0 && lefti < n && leftj >= 0 && leftj < m && map[lefti][leftj] !== "." && map[lefti][leftj] !== "Z";
    let checkRight = righti >= 0 && righti < n && rightj >= 0 && rightj < m &&map[righti][rightj] !== "." && map[righti][rightj] !== "Z";
    if (map[ci][cj] === "M") {
      if (checkUp) q.push({ i: ci + up[0], j: cj + up[1], from: "", to: "up" });
      if (checkDown) q.push({ i: ci + down[0], j: cj + down[1], from: "", to: "down" });
      if (checkLeft) q.push({ i: ci + left[0], j: cj + left[1], from: "", to: "left" });
      if (checkRight) q.push({ i: ci + right[0], j: cj + right[1], from: "", to: "right" });
    }

    if (map[ci][cj] === ".") {
      ci++;
      cj++;
      if (from === "down") {
        if (checkUp && checkLeft && checkRight) {
          console.log(ci, cj, "+");
          break;
        }
        if (checkUp && nextUp.includes(map[upi][upj])) {
          console.log(ci, cj, "|");
          break;
        }
        if (checkRight && nextRight.includes(map[righti][rightj])) {
          console.log(ci, cj, "1");
          break;
        }
        if (checkLeft && nextLeft.includes(map[lefti][leftj])) {
          console.log(ci, cj, "4");
          break;
        }
      }
      if (from === "up") {
        if (checkDown && checkLeft && checkRight) {
          console.log(ci, cj, "+");
          break;
        }
        if (checkDown && nextDown.includes(map[downi][downj])) {
          console.log(ci, cj, "|");
          break;
        }
        if (checkRight && nextRight.includes(map[righti][rightj])) {
          console.log(ci, cj, "2");
          break;
        }
        if (checkLeft && nextLeft.includes(map[lefti][leftj])) {
          console.log(ci, cj, "3");
          break;
        }
      }
      if (from === "left") {
        if (checkDown && checkUp && checkRight) {
          console.log(ci, cj, "+");
          break;
        }
        if (checkDown && nextDown.includes(map[downi][downj])) {
          console.log(ci, cj, "4");
          break;
        }
        if (checkRight && nextRight.includes(map[righti][rightj])) {
          console.log(ci, cj, "-");
          break;
        }
        if (checkUp && nextUp.includes(map[upi][upj])) {
          console.log(ci, cj, "3");
          break;
        }
      }
      if (from === "right") {
        if (checkDown && checkUp && checkLeft) {
          console.log(ci, cj, "+");
          break;
        }
        if (checkDown && nextDown.includes(map[downi][downj])) {
          console.log(ci, cj, "1");
          break;
        }
        if (checkLeft && nextLeft.includes(map[lefti][leftj])) {
          console.log(ci, cj, "-");
          break;
        }
        if (checkUp && nextUp.includes(map[upi][upj])) {
          console.log(ci, cj, "2");
          break;
        }
      }
    }
  }

  if (map[ci][cj] === "|") {
    if (from === "up") q.push({ i: ci + down[0], j: cj + down[1], from: from, to: "down" });
    if (from === "down") q.push({ i: ci + up[0], j: cj + up[1], from: from, to: "up" });
  }
  if (map[ci][cj] === "-") {
    if (from === "left") q.push({ i: ci + right[0], j: cj + right[1], from: from, to: "right" });
    if (from === "right") q.push({ i: ci + left[0], j: cj + left[1], from: from, to: "left" });
  }
  if (map[ci][cj] === "+") {
    if (from === "up") q.push({ i: ci + down[0], j: cj + down[1], from: from, to: "down" });
    if (from === "down") q.push({ i: ci + up[0], j: cj + up[1], from: from, to: "up" });
    if (from === "left") q.push({ i: ci + right[0], j: cj + right[1], from: from, to: "right" });
    if (from === "right") q.push({ i: ci + left[0], j: cj + left[1], from: from, to: "left" });
  }
  if (map[ci][cj] === "1") {
    if (from === "down") q.push({ i: ci + right[0], j: cj + right[1], from: from, to: "right" });
    if (from === "right") q.push({ i: ci + down[0], j: cj + down[1], from: from, to: "down" });
  }
  if (map[ci][cj] === "2") {
    if (from === "up") q.push({ i: ci + right[0], j: cj + right[1], from: from, to: "right" });
    if (from === "right") q.push({ i: ci + up[0], j: cj + up[1], from: from, to: "up" });
  }
  if (map[ci][cj] === "3") {
    if (from === "up") q.push({ i: ci + left[0], j: cj + left[1], from: from, to: "left" });
    if (from === "left") q.push({ i: ci + up[0], j: cj + up[1], from: from, to: "up" });
  }
  if (map[ci][cj] === "4") {
    if (from === "down") q.push({ i: ci + left[0], j: cj + left[1], from: from, to: "left" });
    if (from === "left") q.push({ i: ci + down[0], j: cj + down[1], from: from, to: "down" });
  }
}